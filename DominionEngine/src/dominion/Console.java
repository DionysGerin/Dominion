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
   
    public Console() throws SQLException //SQLException solution?
    {
        //Create scanner for choices during game
        scanner = new Scanner(System.in);
        //Sets the game up
        setUpGame();
        //While loop till win condition is triggered by a turn
        gameLoop();
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
    
    public void gameLoop() throws SQLException
    {
        //Keeplarss making and ending turns till win condition is triggered
        int isturn = 0;
        int aantalSpelers = game.getPlayers().size();
        while(!game.getSupply().winCondition(aantalSpelers))
        {
            turn(isturn);
            isturn++;
            if (isturn == aantalSpelers) isturn = 0;
        }
        System.out.println("Game over\n");
        game.getWinner();
    }
    
    public void actionPhase(Player currentPlayer, Turn turn)
    {
        //Keuze opvragen en bewaren of er een actiekaart gespeeld moet worden, indien mogelijk
        int playActionChoice = 0;
        if (currentPlayer.getCardCollection().hasTypeInHand(2))
        {
            System.out.println("Play an action card? (1 = yes, 0 = no)");
            playActionChoice = scanner.nextInt();
        }
        
        //Zolang de spelers actiekaarten, acties overheeft of een kaart wil spelen zal hij vragen om ze te leggen op de table
        while (playActionChoice == 1)
        {
            //Eerste deel, maak een interpreter object die de acties overloopt en uitvoert en speel de kaart naar de tafel
            System.out.println("What action card do you want to play?");
            int playChoice = scanner.nextInt();
            currentPlayer.getCardCollection().playCard(playChoice);
            ArrayList<Card> playerTable = currentPlayer.getCardCollection().getTable();
            AbilityInterpreter interpreter = new AbilityInterpreter(turn, game.getSupply(), currentPlayer, game.getPlayers(), ((KingdomCard) playerTable.get(playerTable.size()-1)).getAbilities());
            turn.reduceActions();
            printHand(currentPlayer);
            
            //Tweede deel, Opnieuw keuze opvragen en bewaren of er nog een actiekaart gespeeld moet worden, indien mogelijk
            System.out.println("Play another action card? (1 = yes, 0 = no)");
            playActionChoice = scanner.nextInt();
        }
    }
    
    public void buyPhase(Player currentPlayer, Turn turn)
    {
        //Keuze opvragen en bewaren of er een kaart gekocht moet worden
        System.out.println("Buy a card? (1 = yes, 0 = no)");
        int buyCardChoice = scanner.nextInt();
        
        //Zolang de speler buys over heeft en een kaart wil kopen
        while (turn.getBuys() != 0 && buyCardChoice == 1)
        {
            //Eerste deel van de buyphase, de kaarten kiezen om te spelen, duurt zolang er treasurekaarten kunnen gespeeld worden en er gelegd willen worden, deze gaan naar table
            int playChoice = 0;
            while (currentPlayer.getCardCollection().hasTypeInHand(0) && playChoice != -1)
            {
                System.out.println("Which treasurecard do you want to use to buy? (-1 to stop playing cards)");
                printHand(currentPlayer);
                playChoice = scanner.nextInt();
                
                if (playChoice != -1) currentPlayer.getCardCollection().playCard(playChoice);
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
            }
        }
    }
    
    public void cleanUpPhase(Player currentPlayer, Turn turn)
    {
        currentPlayer.getCardCollection().discardAllCards();
        currentPlayer.getCardCollection().drawCard(5);
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
    
    public void printSupply() // deze laatste 3 klasses kunnen blijkbaar vervangen worden door 1 dek volgens wat ik begrepen heb van dirk
    {
        //Goes through all cards in shop and prints them
        System.out.println("Cards in Supply:");
        for (ArrayList<Card> supplyCards : game.getSupply().getSupply()) System.out.println(supplyCards.get(0).getName() + " Cost: " + supplyCards.get(0).getCost() + " (quantity:" + supplyCards.size() + ")");
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
