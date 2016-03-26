/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

/**
 *
 * @author LDK
 */
public class CardCreator {
    
    public TreasureCard makeTreasureCard(String name,int cost, int value)
    {
        // connector aanspreken      
        
        return new TreasureCard(name, cost, value);
    }
                
    public ActionCard makeActionCard(String name,int cost)
    {
        //connector aanspreken
        
        
        return new ActionCard(name, cost);
    }
            
    public VictoryCard makeVictoryCard(String name,int cost, int value)
    {
        //connector aanspreken
        
        return new VictoryCard(name, cost, value);
        
        
    }
}
