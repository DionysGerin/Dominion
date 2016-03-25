package dominion;

public class ShopCard 
{
    private String name;
    private int amount;
    
    public ShopCard(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void reduceAmount()
    {
        amount--;
    }
}
