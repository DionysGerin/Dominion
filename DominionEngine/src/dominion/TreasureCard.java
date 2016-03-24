/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

/**
 *
 * @author Dionys
 */
public class TreasureCard extends Card 
{
    private int treasurePoints;
    
    public TreasureCard(String name, int cost, int value)
    {
        super(name, cost, 0);
        treasurePoints = value;
    }
    
    public int getTreasurePoints()
    {
        return treasurePoints;
    }
}
