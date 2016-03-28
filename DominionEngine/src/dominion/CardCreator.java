package dominion;

public class CardCreator {
    
    public TreasureCard makeTreasureCard(String name,int cost, int value)
    {
        // connector aanspreken      
        
        return new TreasureCard(name, cost, value);
    }
                
    public ActionCard makeActionCard(String name,int cost)
    {
        //connector aanspreken
        
        
        return new ActionCard(name, cost);
    }
            
    public VictoryCard makeVictoryCard(String name,int cost, int value)
    {
        //connector aanspreken
        
        return new VictoryCard(name, cost, value);
        
        
    }
}
