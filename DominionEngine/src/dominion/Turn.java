package dominion;

public class Turn 
{
	private int actions;
	private int buys;
        private int money;
	
	public Turn()
	{
            actions = 1;
            buys = 1;
            money = 0;
	}
	
	public int getActions()
	{
            return actions;
	}
	
	public int getBuys()
	{
            return buys;
	}
        
        public int getMoney()
        {
            return money;
        }
	
	public void reduceActions()
	{
            actions--;
	}
	
	public void reduceBuys()
	{
            buys--;
	}
        
        public void reduceMoney(int amount)
        {
            money -= amount;
        }
	
	public void addActions(int amount)
	{
            actions += amount;
	}
	
	public void addBuys(int amount)
	{
            buys += amount;
	}
        
        public void addMoney(int amount)
        {
            money += amount;
        }
}
