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
        
        interpreter(abilities);
    }
    
    public void interpreter(ArrayList<Integer> abilities)
    {
        for (Integer action : abilities)
        {
            int ability = action/100;
            int amount = action%100;
            
            switch (ability)
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
                case 13: //add silver to top of deck and others reveal victory card and add to top of deck, otherwise show all cards in hand
                    gainSilverAddToDeck();
                    otherPlayersRevealVictoryCard();
                    break;
                case 14: //Everybody reveals top card of deck and either draws it or discards it
                    drawOrDiscardCardTopDeck();
                    break;
                case 15: //Other players show the 2 cards on their deck and if they are treasurecards, you can gain them, otherwise they are trashed
                    othersReveal2CardsGainOrTrashThem();
                    break;
                case 16: //Play an action card twice
                    playActionCardTwice();
                    break;
                case 17: //Other players draw x
                    othersDrawX(amount);
                    break;
                case 18: //Draw till X in hand, if action you can discard
                    drawTillXInHand(amount);
                    break;
                case 19: //Trash copper or silver and gain treasurecard better
                    gainBetterTreasureCard();
                    break;
                case 20: //Others take curse card
                    othersTakeCurse();
                    break;
                case 21: //Draw cards till X treasure drawn, if you have to shuffle do so
                    drawTillXTreasureCards(amount);
                    break;
            }
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
            if (player != currentPlayer && !player.getCardCollection().hasReactionInHand())
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
            if (player != currentPlayer && !player.getCardCollection().hasReactionInHand())
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
    
    public void drawOrDiscardCardTopDeck()
    {
        for (Player player: allPlayers)
        {
            System.out.println(player.getCardCollection().getDeck().get(0).getName());
            System.out.println("Draw or discard? (draw = 1, discard = 0)");
            int choice = scanner.nextInt();
            player.getCardCollection().drawCard(1);
            if (choice == 0) player.getCardCollection().discardCardFromHand(player.getCardCollection().getHand().size()-1);
        }
    }
    
    public void othersReveal2CardsGainOrTrashThem()
    {
        for (Player player : allPlayers)
        {
            if(player != currentPlayer && !player.getCardCollection().hasReactionInHand())
            {
                System.out.println(player.getCardCollection().getDeck().get(0).getName());
                System.out.println(player.getCardCollection().getDeck().get(1).getName());
                
                if (player.getCardCollection().getDeck().get(0).getType() == 0 && player.getCardCollection().getDeck().get(1).getType() != 0)
                {
                    System.out.println("Add first card to discard? (yes = 1, no = 0");
                    int choice = scanner.nextInt();
                    if (choice == 1) currentPlayer.getCardCollection().addNewCardToDiscard(player.getCardCollection().getDeck().get(0));
                    player.getCardCollection().getDeck().remove(0);
                }
                if (player.getCardCollection().getDeck().get(1).getType() == 0 && player.getCardCollection().getDeck().get(0).getType() != 0)
                {
                    System.out.println("Add second card to discard? (yes = 1, no = 0");
                    int choice = scanner.nextInt();
                    if (choice == 1) currentPlayer.getCardCollection().addNewCardToDiscard(player.getCardCollection().getDeck().get(1));
                    player.getCardCollection().getDeck().remove(1);
                }
                if (player.getCardCollection().getDeck().get(0).getType() == 0 && player.getCardCollection().getDeck().get(1).getType() == 0)
                {
                    System.out.println("Which card do you want to trash? (first = 0, second = 1");
                    int choice = scanner.nextInt();
                    System.out.println("Add card to discard? (yes = 1, no = 0");
                    int keepChoice = scanner.nextInt();
                    if (keepChoice == 1) currentPlayer.getCardCollection().addNewCardToDiscard(player.getCardCollection().getDeck().get(choice));
                    player.getCardCollection().getDeck().remove(choice);
                }
            }
        }
    }
    
    public void playActionCardTwice() //Zal dit werken?
    {
        System.out.println("What action card do you want to play twice?");
        int choice = scanner.nextInt();
        currentPlayer.getCardCollection().playCard(choice);
        ArrayList<Integer> cardAbilties = ((KingdomCard) currentPlayer.getCardCollection().getTable().get(currentPlayer.getCardCollection().getTable().size()-1)).getAbilities();
        interpreter(cardAbilties);
        interpreter(cardAbilties);
    }
    
    public void othersDrawX(int amount)
    {
        for (Player player : allPlayers) player.getCardCollection().drawCard(amount);
    }
    
    public void drawTillXInHand(int amount)
    {
        while (currentPlayer.getCardCollection().getHand().size() < amount)
        {
            currentPlayer.getCardCollection().drawCard(1);
            System.out.println("Drawn: " + currentPlayer.getCardCollection().getHand().get(currentPlayer.getCardCollection().getHand().size()-1).getName());
            if (currentPlayer.getCardCollection().getHand().get(currentPlayer.getCardCollection().getHand().size()-1).getType() == 2) 
            {
                System.out.println("Keep the drawn action card? (yes = 1, no = 0");
                int choice = scanner.nextInt();
                if (choice == 0) currentPlayer.getCardCollection().getHand().remove(currentPlayer.getCardCollection().getHand().size()-1);
            }
        }
    }
    
    public void gainBetterTreasureCard()
    {
        System.out.println("Which treasure card do you want to trash?");
        int trashChoice = scanner.nextInt();
        if (currentPlayer.getCardCollection().getHand().get(trashChoice).getName().equals("Copper")) currentPlayer.getCardCollection().addCardToHand(supply.cardPurchase(2));
        if (currentPlayer.getCardCollection().getHand().get(trashChoice).getName().equals("Silver")) currentPlayer.getCardCollection().addCardToHand(supply.cardPurchase(3));
        currentPlayer.getCardCollection().trashCardFromHand(trashChoice);
    }
    
    public void othersTakeCurse()
    {
        for (Player player : allPlayers) if (player != currentPlayer && !player.getCardCollection().hasReactionInHand()) player.getCardCollection().addNewCardToDiscard(supply.cardPurchase(0));
    }
    
    public void drawTillXTreasureCards(int amount)
    {
        int sizeTableBefore = currentPlayer.getCardCollection().getTable().size();
        while (amount > 0 && (!currentPlayer.getCardCollection().getDeck().isEmpty() && !currentPlayer.getCardCollection().getDiscard().isEmpty()))
        {
            System.out.println(currentPlayer.getCardCollection().getDeck().get(0).getName());
            currentPlayer.getCardCollection().drawCard(1);
            if (currentPlayer.getCardCollection().getHand().get(currentPlayer.getCardCollection().getHand().size()-1).getType() == 0) amount --;
            else currentPlayer.getCardCollection().playCard(currentPlayer.getCardCollection().getHand().size()-1);
        }
        
        while(currentPlayer.getCardCollection().getTable().get(sizeTableBefore) != null)
        {
            currentPlayer.getCardCollection().discardCardFromTable(sizeTableBefore);
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
