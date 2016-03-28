
package dominion;

public class VictoryCard extends Card
{
    private int victoryPoints;
    
    public VictoryCard(String name, int cost, int value)
    {
        super(name, cost, 1);
        victoryPoints = value;
    }
    
    public int getVictoryPoints()
    {
        return victoryPoints;
    }
}
