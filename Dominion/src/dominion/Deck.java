package dominion;

public class Deck 
{
    private Card[] deck;
    private Card vc1 = new Card("Estate", 2, 1, "Victory");
    private Card tc1 = new Card("Copper", 0, 1, "Treasure");
    
    public Deck()
    {
        
        deck = new Card[10];
        
        for(int i = 0; i <= 2; i++)
        {
            deck[i] = vc1;
        }
        
        for (int i = 3; i <= 9; i++)
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
            res += deck[i].getName(); 
            res += ", Value: ";
            res += deck[i].getValue(); 
            res += ", Cost: ";
            res += deck[i].getCost();
            res += ". ";
        }
        return res;
    }
}
