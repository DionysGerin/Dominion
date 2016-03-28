package dominion;

import java.util.*;

public class Maintester 
{
    private Game game; 
    
    public static void main(String[] args)
    {
        Maintester testGame = new Maintester();
    }
    
    
    public Maintester()
    {
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Welcome to dominion");
        System.out.println("How many players do you want to play with? (Static amount of 2 atm, in development)"); // needs to be added
        System.out.println();
        
        System.out.print("Enter player1 name: ");
        String name1 = nameScanner.next();
        System.out.println();
        Player player1 = new Player(name1);
        
        System.out.print("Enter player2 name: ");
        String name2 = nameScanner.next();
        System.out.println();
        Player player2 = new Player(name2);
        
        game = new Game(player1, player2);
        
        gameLoop();
    }
    
    public void gameLoop()
    {
        int isturn = 0;
        game.getPlayer(0).getCardCollection().drawCard(5);
        game.getPlayer(1).getCardCollection().drawCard(5);
        while(!game.getShop().isGameOver())
        {
            turn(isturn);
            isturn++;
            if (isturn == 2) isturn = 0;
        }
        System.out.println("Game over");
    }
    
    public void turn(int playerIndex)
    {
        Scanner choiceScanner = new Scanner(System.in);
        Turn turn = new Turn();
        while (!turn.isOver())
        {
            System.out.println(game.getPlayer(playerIndex).getPlayerName() + "'s turn");
            System.out.println();
            printShop();
            printSupply(playerIndex);
            System.out.println("Make a choice:   1. Play Action Card   2. Buy Card   3. End Turn");
            int Choise = choiceScanner.nextInt();
            System.out.println();
            System.out.println();
            switch(Choise)
            {
                case 1: //play action
                    break;
                case 2: //buy card
                    
                    boolean playMoreCards = true;
                    while (playMoreCards)
                    {
                        System.out.println("Which treasurecard do you want to use to buy?");
                        // added by anas
                         printSupply(playerIndex);
                        //----
                        int playChoice = choiceScanner.nextInt();
                        game.getPlayer(playerIndex).getCardCollection().playCard(playChoice);
                        System.out.println("Play more cards?(No = 0, Yes = 1");
                        int moreChoice = choiceScanner.nextInt();
                        if (moreChoice == 0) playMoreCards = false;
                        else playMoreCards = true;
                        // added by anas
                        if (game.getPlayer(playerIndex).getCardCollection().getSupply().isEmpty()) playMoreCards = false;
                        //----
                    }
                    
                    System.out.println("What card do you want to buy?");
                    int buyChoice = choiceScanner.nextInt();
                    if (game.getShop().getShopCard(buyChoice).getAmount() > 0)
                    {
                        turn.setActionsToZero();
                        turn.reduceBuys();
                        game.getShop().getShopCard(buyChoice).reduceAmount(); //ok dit zal niet lukken, we moeten de shop aanpassen en in ShopCard de Card steken die erbij hoort,
                        //dan kunnne we die returnen en verwijderen en is kopen 1000% makkelijker!!!
                        game.getShop().getShopCard(buyChoice).getName();
                        game.getPlayer(playerIndex).getCardCollection().addNewCardToDiscard(card); //moet naar gekocht kaart (nieuw object) verwijzen
                    }
                    break;
                case 3: //end turn
                    turn.endTurn();
                    game.getPlayer(playerIndex).getCardCollection().discardAllCards();
                    game.getPlayer(playerIndex).getCardCollection().drawCard(5);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void printPlayerDeck(int playerIndex)
    {
        System.out.println("Player " + (playerIndex + 1) + ": " + game.getPlayers().get(playerIndex).getPlayerName());
        System.out.println(); 
        ArrayList<Card> deck = game.getPlayers().get(playerIndex).getCardCollection().getDeck();

        for (int j = 0; j < deck.size();j++) //foreach?
        {
            Card cardFromDeck = deck.get(j);
            System.out.println("Name: " + cardFromDeck.getName());
            System.out.println("Cost: " + cardFromDeck.getCost());
            if (cardFromDeck.getType().equals("Treasure Card")) System.out.println("Money: " + ((TreasureCard) cardFromDeck).getTreasurePoints());
            if (cardFromDeck.getType().equals("Victory Card")) System.out.println("Victory Points: " + ((VictoryCard) cardFromDeck).getVictoryPoints());
            System.out.println("Type: " + cardFromDeck.getType());
            System.out.println();
        } 
    }
    
    public void printShop()
    {
        System.out.println("Cards in Shop: (Curse Card is not buyable!)");
        for (ShopCard cards : game.getShop().getShopCollection()) System.out.print(cards.getName() + "(" + cards.getAmount() + ")  "); //foreach?
        System.out.println();
        System.out.println();
    }
    
    public void printSupply(int playerIndex)
    {
        System.out.println("Cards in hand:");
        for (Card cards : game.getPlayer(playerIndex).getCardCollection().getSupply()) System.out.print(cards.getName() + "   ");
        System.out.println();
        System.out.println();
    }
}
