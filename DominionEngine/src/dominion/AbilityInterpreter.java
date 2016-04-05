package dominion;

import java.util.*;

public class AbilityInterpreter
{
    private Turn turn;
    private Supply supply;
    private Player currentPlayer;
    private ArrayList<Player> allPlayers;
    private ArrayList<Integer> abilities;
    private Scanner scanner;
    
    public AbilityInterpreter(Turn turn, Supply supply, Player currentPlayer, ArrayList<Player> allPlayers, ArrayList<Integer> abilities)
    {
        this.turn = turn;
        this.supply = supply;
        this.currentPlayer = currentPlayer;
        this.allPlayers = allPlayers;
        this.abilities = abilities;
        Scanner scanner = new Scanner(System.in);
        
        for (Integer action : abilities) interpreter(action/100, action%100);
    }
    
    public void interpreter(int action, int amount)
    {
        switch (action) // DONT FORGET TO ADD FUNCTIONALITY FOR MOAT AND GARDENS
        {
            case 1: //Add action(s)
                turn.addActions(amount);
                break;
            case 2: //Draw card(s)
                currentPlayer.getCardCollection().drawCard(amount);
                break;
            case 3: //Add money
                turn.addMoney(amount);
                break;
            case 4: //Add buy(s)
                turn.addBuys(amount);
                break;
            case 5: //Discard cards and draw as many new cards
                discardXForXDraw();
                break;
            case 6: //Trash up to X cards
                trashX(amount);
                break;
            case 7: //Gain a free card with max cost of x
                gainFreeCard(amount);
                break;
            case 8: //Put deck pile on your discard pile
                discardDeck();
                break;
            case 9: //Trash the card you just played
                trashPlayedCard();
                break;
            case 10: //Other players trash down to x cards in hand
                otherPlayersDiscardDownToX(amount);
                break;
            case 11: //trash copper card and gain 3 money
                trashCopperGain3Money();
                break;
            case 12: //Trash a card and gain a card costing up to 2 more
                trashCardGainCardUpTo2More();
                break;
            case 13: //Bureaucrat ability
                gainSilverAddToDeck();
                otherPlayersRevealVictoryCard();
                break;
            case 14: //Spy ability
                break;
            case 15: //Thief ability
                break;
            case 16: //Throne room ability
                break;
            case 17: //Council room ability
                break;
            case 18: //Library ability
                break;
            case 19: //Mine ability
                break;
            case 20: //Witch ability
                break;
            case 21: //Adventurer ability
                break;
        }
    }
    
    public void discardXForXDraw()
    {
        System.out.println("Discard card? (yes = 1, no = 0");
        int choice = scanner.nextInt();
        int amount = 0;
        while (choice == 1 && !currentPlayer.getCardCollection().getHand().isEmpty())
        {
            System.out.println("Which card do you want to discard?");
            int discardChoice = scanner.nextInt();
            currentPlayer.getCardCollection().discardCardFromHand(discardChoice);
            amount++;
            
            System.out.println("Discard another card? (yes = 1, no = 0");
            choice = scanner.nextInt();
        }
        currentPlayer.getCardCollection().drawCard(amount);
    }
    
    public void trashX(int amount)
    {
        System.out.println("Trash a card? (yes = 1, no = 0");
        int trashChoice = scanner.nextInt();
        while (trashChoice == 1 && amount > 0)
        {
            System.out.println("What card should be trashed?");
            int trashCardChoice = scanner.nextInt();
            currentPlayer.getCardCollection().trashCardFromHand(trashCardChoice);
            amount--;
            
            System.out.println("Trash a card? (yes = 1, no = 0");
            trashChoice = scanner.nextInt();
        }
    }
    
    public void gainFreeCard(int amount)
    {
        System.out.println("What card do you want to gain?");
        int buyChoice = scanner.nextInt();
        if (!supply.getSupplyCard(buyChoice).isEmpty() && supply.getSupplyCard(buyChoice).get(0).getCost() < amount++) currentPlayer.getCardCollection().addNewCardToDiscard(supply.cardPurchase(buyChoice));
    }
    
    public void discardDeck()
    {
        System.out.println("Discard your deck? (yes = 1, no = 0");
        int discardChoice = scanner.nextInt();
        if (discardChoice == 1) currentPlayer.getCardCollection().deckPileToDiscard();
    }
    
    public void trashPlayedCard()
    {
        currentPlayer.getCardCollection().trashCardFromTable(currentPlayer.getCardCollection().getTable().size()-1);
    }
    
    public void otherPlayersDiscardDownToX(int amount)
    {
        for (Player player : allPlayers)
        {
            if (player != currentPlayer)
            {
                while (player.getCardCollection().getHand().size() > amount)
                {
                    System.out.println(player.getPlayerName() + ", what card do you want to discard?");
                    printHand(player);
                    int discardChoice = scanner.nextInt();
                    player.getCardCollection().discardCardFromHand(discardChoice);
                }
            }
        }
    }
    
    public void trashCopperGain3Money()
    {
        System.out.println("What card do you want to trash? (Must be a copper card)");
        int trashChoice = scanner.nextInt();
        if (currentPlayer.getCardCollection().getHand().get(trashChoice).getName().equals("Copper"))
        {
            currentPlayer.getCardCollection().trashCardFromHand(trashChoice);
            turn.addMoney(3);
        }
    }
    
    public void trashCardGainCardUpTo2More()
    {
        System.out.println("What card do you want to trash?");
        int trashChoice = scanner.nextInt();
        int cost = currentPlayer.getCardCollection().getHand().get(trashChoice).getCost();
        currentPlayer.getCardCollection().trashCardFromHand(trashChoice);
        gainFreeCard(cost);
    }
    
    public void gainSilverAddToDeck()
    {
        if (!supply.getSupplyCard(2).isEmpty()) currentPlayer.getCardCollection().addCardToTopOfDeck(supply.cardPurchase(2));
    }
    
    public void otherPlayersRevealVictoryCard()
    {
        for (Player player : allPlayers)
        {
            if (player != currentPlayer)
            {
                System.out.println(player.getPlayerName() + "Reveal victory card to top of deck (If no victory card, whole hand will be revealed");
                printHand(player);
                int revealChoice = scanner.nextInt();
                if (player.getCardCollection().getHand().get(revealChoice).getType() == 1)
                {
                    System.out.println(player.getCardCollection().getHand().get(revealChoice).getName());
                    player.getCardCollection().addCardToTopOfDeck(player.getCardCollection().getHand().get(revealChoice));
                    player.getCardCollection().trashCardFromHand(revealChoice);
                } 
                else printHand(player);
            }
        }
    }
    
    
    
    public void printHand(Player player)
    {
        //Goes through all cards in hand from current player and prints them
        System.out.println("Cards in hand:");
        for (Card cards : player.getCardCollection().getHand()) System.out.println(cards.getName());
        System.out.println();
    }
}
