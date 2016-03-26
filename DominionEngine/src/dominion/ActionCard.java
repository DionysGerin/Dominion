package dominion;

import java.util.*;

public class ActionCard extends Card
{
    private int[] ability;
    
    public ActionCard(String name, int cost)
    {
        super(name, cost, 2);      
    }           
}