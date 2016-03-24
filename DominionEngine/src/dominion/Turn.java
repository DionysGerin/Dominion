package dominion;

public class Turn 
{
	private int actions;
	private int buys;
        private boolean isOver;
	
	public Turn()
	{
		actions = 1;
		buys = 1;
                isOver = false;
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
