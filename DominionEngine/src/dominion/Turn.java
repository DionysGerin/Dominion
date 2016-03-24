package dominion;

public class Turn 
{
	private int actions;
	private int buys;
        private boolean isOver;
        private int money;
	
	public Turn()
	{
            actions = 1;
            buys = 1;
            isOver = false;
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
	
	public void reduceActions()
	{
            actions--;
	}
	
	public void reduceBuys()
	{
            buys--;
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
        
        public void reduceMoney(int amount)
        {
            money -= amount;
        }
	
	public void endTurn()
	{
            actions = 0;
            buys = 0;
            isOver = true;
	}
        
        public boolean isOver()
        {
            return isOver;
        }
}
