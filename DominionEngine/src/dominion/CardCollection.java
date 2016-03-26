package dominion;

import java.util.*;

public class CardCollection 
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Card> supply;
    private ArrayList<Card> table;
    
    public CardCollection()
    {
        deck = new ArrayList(100);
        discard = new ArrayList(100);
        supply = new ArrayList(20);
        table = new ArrayList(20);
        
        for (int i = 0; i < 7; i++) deck.add(new TreasureCard("Copper", 0, 1));
        
        for (int i = 7; i < 10; i++) deck.add(new VictoryCard("Estate", 2, 1));
        
        shuffleDeck();
    }
    
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }
    
    public ArrayList<Card> getSupply()
    {
        return supply;
    }
    
    public void drawCard(int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            if (deck.isEmpty()) discardPileToDeck();
            supply.add(deck.get(0));
            deck.remove(0);
        }
    }
    
    public void discardCardFromHand(int index)
    {
        supply.remove(index);
    }
    
    public void discardAllCards()
    {
        int size = supply.size();
        for(int i = 0; i < size; i++)
        {
            discard.add(supply.get(0));
            supply.remove(0);
        }
        tablePileToDiscard();
    }
    
    public void discardPileToDeck()
    {
        deck = (ArrayList) discard.clone();
        discard.clear();
        shuffleDeck();
    }
    
    public void tablePileToDiscard()
    {
        int size = table.size();
        for (int i = 0; i < size; i++) 
        {
            discard.add(table.get(0));
            table.remove(0);
        }
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
    
    public void addNewCardToDiscard(Card card)
    {
        discard.add(card);
    }
    
    public void playCard(int supplyIndex)
    {
        table.add(supply.get(supplyIndex));
        supply.remove(supplyIndex);
    }
    
    public void trashCard(int index)
    {
        supply.remove(index);
    }
    
    public void deckPileToDiscard()
    {
        int size = deck.size();
        for (int i = 0; i < size; i++)
        {
            discard.add(deck.get(0));
            deck.remove(0);
        }
    }
}
