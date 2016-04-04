package dominion;

import java.sql.SQLException;
import java.util.*;

public class Console 
{
    private Game game;
    private Scanner scanner;
    
    public static void main(String[] args) throws SQLException
    {
        Console testGame = new Console();
    }
    
    
    public Console() throws SQLException // dit klopt niet, waar moeten we de cardcreator zetten zodat we niet overal de sqlexception moeten throwen
    {
        scanner = new Scanner(System.in);
        
        printIntro();
        System.out.println("Welcome to dominion");
        System.out.println("How many players do you want to play with? (Static amount of 2 atm, in development)"); // needs to be added
        System.out.println();
        
        System.out.print("Enter player1 name: ");
        String name1 = scanner.next();
        System.out.println();
        Player player1 = new Player(name1);
        
        System.out.print("Enter player2 name: ");
        String name2 = scanner.next();
        System.out.println();
        Player player2 = new Player(name2);
        
        game = new Game(player1, player2);
        
        gameLoop();
    }
    
    public void gameLoop() throws SQLException
    {
        int isturn = 0;
        game.getPlayer(0).getCardCollection().drawCard(5);
        game.getPlayer(1).getCardCollection().drawCard(5);
        while(!game.getSupply().isGameOver(game.getPlayers().size()))
        {
            turn(isturn);
            isturn++;
            if (isturn == 2) isturn = 0;
        }
        System.out.println("Game over");
    }
    
    public void turn(int playerIndex) throws SQLException
    {
        Turn turn = new Turn();
        Player currentPlayer = game.getPlayer(playerIndex);
        
        while (!turn.isOver())
        {
            System.out.println(currentPlayer.getPlayerName() + "'s turn\n");
            printShop();
            printHand(currentPlayer);
            System.out.println("Make a choice:   1. Play Action Card   2. Buy Card   3. End Turn");
            int Choice = scanner.nextInt();
            System.out.println();
            switch(Choice)
            {
                case 1: //play action
                    actionPhase(currentPlayer, turn);
                    break;
                case 2: //buy card
                    buyPhase(currentPlayer, turn);
                    break;
                case 3: //end turn
                    cleanUpPhase(currentPlayer, turn);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void actionPhase(Player currentPlayer, Turn turn)
    {
        
    }
    
    public void buyPhase(Player currentPlayer, Turn turn)
    {
        boolean playMoreCards = true;
        while (playMoreCards)
        {
            System.out.println("Which treasurecard do you want to use to buy?");
            // Nodig?
            printHand(currentPlayer);
            //----
            int playChoice = scanner.nextInt();
            currentPlayer.getCardCollection().playCard(playChoice);
            System.out.println("Play more cards?(No = 0, Yes = 1");
            int moreChoice = scanner.nextInt();
            if (moreChoice == 0) playMoreCards = false;
            // temp?
            if (currentPlayer.getCardCollection().getHand().isEmpty()) playMoreCards = false;
        }

        System.out.println("What card do you want to buy?");
        printShop();
        int buyChoice = scanner.nextInt();
        if (!game.getSupply().getSupplyCard(buyChoice).isEmpty())
        {
            turn.setActionsToZero();
            turn.reduceBuys();
            currentPlayer.getCardCollection().addNewCardToDiscard(game.getSupply().cardPurchase(buyChoice));
            currentPlayer.getCardCollection().tablePileToDiscard();
        }
    }
    
    public void cleanUpPhase(Player currentPlayer, Turn turn)
    {

        turn.endTurn();
        currentPlayer.getCardCollection().discardAllCards();
        currentPlayer.getCardCollection().drawCard(5);
    }
    
    public void printShop()
    {
        System.out.println("Cards in Shop:");
        for (ArrayList<Card> supplyCards : game.getSupply().getSupply()) System.out.println(supplyCards.get(0).getName() + " Cost: " + supplyCards.get(0).getCost() + " (" + supplyCards.size() + ")");
        System.out.println();
    }
    
    public void printHand(Player player)
    {
        System.out.println("Cards in hand:");
        for (Card cards : player.getCardCollection().getHand()) System.out.println(cards.getName() + "   ");
        System.out.println();
    }
    
    public void printIntro()
    {
        
    }
}
