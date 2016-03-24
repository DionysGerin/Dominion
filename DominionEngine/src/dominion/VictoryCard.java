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
public class VictoryCard extends Card
{
    private int victoryPoints;
    
    public VictoryCard(String name, int cost, int value)
    {
        super(name, cost, 1);
        victoryPoints = value;
    }
    
    public int getVictoryPoints()
    {
        return victoryPoints;
    }
}
