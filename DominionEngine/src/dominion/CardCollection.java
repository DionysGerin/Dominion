package dominion;

import java.util.*;

public class CardCollection 
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Card> supply;
    
    //TreasureCard tc1 = new TreasureCard("Copper", 0, 1);
    //TreasureCards tc2 = new TreasureCards("Silver", 3, 2);
    //TreasureCards tc3 = new TreasureCards("Gold", 6, 3);
    //VictoryCard vc1 = new VictoryCard("Estate", 2, 1);
    //VictoryCard vc2 = new VictoryCard("Duchy", 5, 3);
    //VictoryCard vc3 = new VictoryCard("Province", 8, 6);
    
    public CardCollection()
    {
        deck = new ArrayList(100);
        discard = new ArrayList(100);
        supply = new ArrayList(20);
        
        for (int i = 0; i < 7; i++) deck.add(new Card("Copper", 0, 1, "Treasure"));
        
        for (int i = 7; i < 10; i++) deck.add(new Card("Estate", 2, 1, "Victory"));
        
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
            if (deck.isEmpty()) discardToDeck();
            supply.add(deck.get(0));
            deck.remove(0);
        }
    }
    
    public void discardCard(int index)
    {
        supply.remove(index);
    }
    
    public void discardToDeck()
    {
        deck = (ArrayList) discard.clone();
        discard.clear();
        shuffleDeck();
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
}
