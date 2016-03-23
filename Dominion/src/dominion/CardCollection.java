package dominion;

import java.util.*;

public class CardCollection 
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private Card vc1 = new Card("Estate", 2, 1, "Victory");
    private Card tc1 = new Card("Copper", 0, 1, "Treasure");
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
