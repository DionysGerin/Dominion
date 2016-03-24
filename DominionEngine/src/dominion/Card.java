package dominion;

public class Card 
{
    private String name;
    private int cost;
    private int value;
    private String type;

    public Card(String name, int cost, int value, String type)
    {
            this.name = name;
            this.cost = cost;
            this.value = value;
            this.type = type;
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
    
    public String getType()
    {
        return type;
    }
}
