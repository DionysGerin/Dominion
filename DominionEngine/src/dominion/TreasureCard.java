package dominion;

public class TreasureCard extends Card 
{
    private int treasurePoints;
    
    public TreasureCard(String name, int cost, int value)
    {
        super(name, cost, 0);
        treasurePoints = value;
    }
    
    public int getTreasurePoints()
    {
        return treasurePoints;
    }
}
