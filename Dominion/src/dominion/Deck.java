package dominion;

import java.util.*;

public class Deck 
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private Card vc1 = new Card("Estate", 2, 1, "Victory");
    private Card tc1 = new Card("Copper", 0, 1, "Treasure");
    
    public Deck()
    {
        
        deck = new ArrayList(100);
        discard = new ArrayList(100);
        
        for(int i = 0; i <= 2; i++)
        {
            deck.add(vc1);
        }
        
        for (int i = 3; i <= 9; i++)
        {
            deck.add(tc1);
        }
    }
    
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }
}
