package dominion;

import java.sql.SQLException;
import java.util.*;

public class Console 
{
    private Game game;
    private Scanner scanner;
    
    public static void main(String[] args) throws SQLException
    {
        //Start a new game
        Console testGame = new Console();
    }
    
    
    public Console() throws SQLException // SQLException solution?
    {
        //Create scanner for choices during game
        scanner = new Scanner(System.in);
        
        //Sets the game up
        setUpGame();
        
        //While loop till win condition is triggered by a turn
        gameLoop();
    }
    
    public void gameLoop() throws SQLException
    {
        //Keeps making and ending turns till win condition is triggered
        int isturn = 0;
        int aantalSpelers = game.getPlayers().size();
        while(!game.getSupply().isGameOver(aantalSpelers))
        {
            turn(isturn);
            isturn++;
            if (isturn == aantalSpelers) isturn = 0;
        }
        System.out.println("Game over");
    }
    
    public void turn(int playerIndex) throws SQLException
    {
        //Creates turn object en stores the current player in variable
        Turn turn = new Turn();
        Player currentPlayer = game.getPlayer(playerIndex);

        //Print current player, the supply and current player's hand
        System.out.println(currentPlayer.getPlayerName() + "'s turn\n");
        printSupply();
        printHand(currentPlayer);

        //Go through turn phases
        actionPhase(currentPlayer, turn);
        buyPhase(currentPlayer, turn);
        cleanUpPhase(currentPlayer, turn);
    }
    
    public void actionPhase(Player currentPlayer, Turn turn)
    {
        //Keuze opvragen en bewaren of er een actiekaart gespeeld moet worden, indien mogelijk
        Boolean playAction = true;
        int playActionChoice;
        if (currentPlayer.getCardCollection().hasTypeInHand(2))
        {
            System.out.println("Play an action card? (1 = yes, 0 = no)");
            playActionChoice = scanner.nextInt();
            if (playActionChoice == 0) playAction = false;
        } else playAction = false;
        
        //Zolang de spelers actiekaarten, acties overheeft of een kaart wil spelen zal hij vragen om ze te leggen op de table
        while (playAction)
        {
            //Eerste deel, ...
            turn.reduceActions();
            
            //Tweede deel, Opnieuw keuze opvragen en bewaren of er nog een actiekaart gespeeld moet worden, indien mogelijk
            if (turn.getActions() != 0 && currentPlayer.getCardCollection().hasTypeInHand(2))
            {
                System.out.println("Play another action card? (1 = yes, 0 = no)");
                playActionChoice = scanner.nextInt();
                if (playActionChoice == 0) playAction = false;
            } else playAction = false;
        }
    }
    
    public void buyPhase(Player currentPlayer, Turn turn)
    {
        //Keuze opvragen en bewaren of er een kaart gekocht moet worden
        Boolean buyCard = true;
        System.out.println("Buy a card? (1 = yes, 0 = no)");
        int buyCardChoice = scanner.nextInt();
        if (buyCardChoice == 0) buyCard = false;
        
        //Zolang de speler buys over heeft en een kaart wil kopen
        while (turn.getBuys() != 0 && buyCard)
        {
            //Eerste deel van de buyphase, de kaarten kiezen om te spelen, duurt zolang er treasurekaarten kunnen gespeeld worden en er gelegd willen worden, deze gaan naar table
            boolean playMoreCards = true;
            while (currentPlayer.getCardCollection().hasTypeInHand(0) && playMoreCards)
            {
                System.out.println("Which treasurecard do you want to use to buy? (-1 to stop playing cards)");
                printHand(currentPlayer);
                int playChoice = scanner.nextInt();
                
                if (playChoice == -1) playMoreCards = false;
                else currentPlayer.getCardCollection().playCard(playChoice);
            }

            //Tweede deel van de buyphase, de kaart kiezen om te kopen, hier worden ook controles uitgevoerd
            printSupply();
            System.out.println("What card do you want to buy?");
            printTable(currentPlayer);
            int buyChoice = scanner.nextInt();
            
            //Hier wordt gekeken of er nog over zijn en je het kan betalen (money in turn and money on table), vervolgens wordt buys verminderd, de kaart en de table aan discard toegevoegd
            if (!game.getSupply().getSupplyCard(buyChoice).isEmpty() && game.getSupply().getSupplyCard(buyChoice).get(0).getCost() <= currentPlayer.getCardCollection().getValueOnTable() + turn.getMoney())
            {
                turn.reduceBuys();
                currentPlayer.getCardCollection().addNewCardToDiscard(game.getSupply().cardPurchase(buyChoice));
                currentPlayer.getCardCollection().tablePileToDiscard();
            }
            
            //Derde deel, Opnieuw keuze opvragen en bewaren of er nog een kaart gekocht moet worden, indien mogelijk
            if (turn.getBuys() != 0)
            {
                System.out.println("Buy a card? (1 = yes, 0 = no)");
            buyCardChoice = scanner.nextInt();
            if (buyCardChoice == 0) buyCard = false;
            }
        }
    }
    
    public void cleanUpPhase(Player currentPlayer, Turn turn)
    {
        currentPlayer.getCardCollection().discardAllCards();
        currentPlayer.getCardCollection().drawCard(5);
    }
    
    public void setUpGame()
    {
        //Basic settings
        System.out.println("Welcome to dominion\nHow many players do you want to play with? (Static amount of 2 atm, in development)\n"); // needs to be added
        
        System.out.print("Enter player1 name: ");
        String name1 = scanner.next();
        System.out.println();
        Player player1 = new Player(name1);
        
        System.out.print("Enter player2 name: ");
        String name2 = scanner.next();
        System.out.println();
        Player player2 = new Player(name2);
        
        //initialise game with basic settings
        game = new Game(player1, player2);
        
        //Players have to draw 5 cards each at start of new game
        game.getPlayer(0).getCardCollection().drawCard(5);
        game.getPlayer(1).getCardCollection().drawCard(5);
    }
    
    public void printSupply()
    {
        //Goes through all cards in shop and prints them
        System.out.println("Cards in Shop:");
        for (ArrayList<Card> supplyCards : game.getSupply().getSupply()) System.out.println(supplyCards.get(0).getName() + " Cost: " + supplyCards.get(0).getCost() + " (" + supplyCards.size() + ")");
        System.out.println();
    }
    
    public void printHand(Player player)
    {
        //Goes through all cards in hand from current player and prints them
        System.out.println("Cards in hand:");
        for (Card cards : player.getCardCollection().getHand()) System.out.println(cards.getName());
        System.out.println();
    }
    
    public void printTable(Player player)
    {
        System.out.println("Cards on the table");
        for (Card tableCards : player.getCardCollection().getTable()) System.out.println(tableCards.getName());
        System.out.println();
    }
}
