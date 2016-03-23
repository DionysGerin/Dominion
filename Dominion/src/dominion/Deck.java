package dominion;

public class Deck 
{
    private Object[] deck;
    private VictoryCard vc1 = new VictoryCard("Estate", 2, 1);
    private TreasureCard tc1 = new TreasureCard("Copper", 0, 1);
    
    public Deck()
    {
        
        Object[] deck = new Object[10];
        
        //for(int i = 0; i <= 2; i++)
        //{
        //    deck[i] = vc1;
        //}
        
        for (int i = 0; i <= 9; i++)
        {
            deck[i] = tc1;
        }
    }
    
    public String getDeck()
    {
        String res = "";
        for (int i = 0; i <= 9; i++)
        {
            res += "Name: ";
            res = deck[i].getName(); 
            res += " Value: ";
            res += deck[i].getValue(); 
            res += "Cost: ";
            res += deck[i].getCost();
        }
    }
}
