package dominion;

import java.util.*;

public class CardCollection 
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Card> supply;
    
    public CardCollection()
    {
        deck = new ArrayList(100);
        discard = new ArrayList(100);
        supply = new ArrayList(20);
        
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
    
    public void takeCard(int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            if (deck.isEmpty()) discardPileToDeck();
            supply.add(deck.get(0));
            deck.remove(0);
        }
    }
    
    public void discardCard(int index)
    {
        supply.remove(index);
    }
    
    public void discardPileToDeck()
    {
        deck = (ArrayList) discard.clone();
        discard.clear();
        shuffleDeck();
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
    
    public void addNewCardToDiscard(Card card)
    {
        discard.add(card);
    }
}
