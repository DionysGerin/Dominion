package dominion;

public class TreasureCard 
{
	private String name;
	private int cost;
	private int value;
	
	public TreasureCard(String name, int cost, int value)
	{
		this.name = name;
		this.cost = cost;
                this.value = value;
	}
        
        public String getName()
        {
            return name;
        }
        
        public int getCost()
        {
            return cost;
        }
        
        public int getValue()
        {
            return value;
        }
}
