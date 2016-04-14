package dominion;

import java.util.*;

public class KingdomCard extends Card
{
    private ArrayList<Integer> abilities;
    
    public KingdomCard(String name, int cost, ArrayList<Integer> abilities)
    {
        super(name, cost, 2);
        this.abilities = abilities;
    }
    
    public ArrayList<Integer> getAbilities()
    {
        return abilities;
    }
}