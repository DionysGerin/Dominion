package dominion;

public class ActionCard extends Card
{
    private String ability;
    
    public ActionCard(String name, int cost, String ability)
    {
        super(name, cost, 2);
        this.ability = ability;        
    }
            
}