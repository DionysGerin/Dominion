package dominion;

public class Card 
{
    private String name;
    private int cost;
    private int type; // 0 = treasure, 1 = victory, 2 = action

    public Card(String name, int cost, int type)
    {
            this.name = name;
            this.cost = cost;
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
    
    public String getType()
    {
        // hier beter switch dan 3 if's  in elkaar 
        switch (type) {
            case 0:
                return "Treasure Card";
            case 1:
                return  "Victory Card";
            default:
                return "Action Card";
        }
    }
}
