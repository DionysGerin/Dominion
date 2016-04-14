package dominion;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Supply 
{
    private ArrayList[] supplyCollection; //De 10 gekozen kaarten zullen gekozne moeten worden uit alle mogelijke kaarten, deze worden aan de spelers via de databank weergegeven
    private boolean gameOver;   
    
    public Supply(String[] chosenKingdomCards)//String[] of the 10 chosen cards EN hoeveelheid van de kaarten doen afhangen van de spelers van de eerste 7 (non kingdom cards)
    {
        
        try {
            supplyCollection = new ArrayList[17];
            SupplyCardCreatorFromDB cardCreator = new SupplyCardCreatorFromDB();
            
            //Curse Card in supply
            supplyCollection[0] = cardCreator.returnVictoryCardSupply("Curse", 10);
            
            //Treasure Cards in Supply
            supplyCollection[1] = cardCreator.returnTreasureCardSupply("Copper", 60);
            supplyCollection[2] = cardCreator.returnTreasureCardSupply("Silver", 40);
            supplyCollection[3] = cardCreator.returnTreasureCardSupply("Gold", 30);
            
            //Victory Cards in Supply
            supplyCollection[4] = cardCreator.returnVictoryCardSupply("Estate", 8);
            supplyCollection[5] = cardCreator.returnVictoryCardSupply("Duchy", 8);
            supplyCollection[6] = cardCreator.returnVictoryCardSupply("Province", 8);
            
            //Action Cards in Supply
            int i = 7;
            for (String supplyCardName : chosenKingdomCards)
            {
                supplyCollection[i] = cardCreator.returnKingdomCardSupply(supplyCardName, 10);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Supply()//Default constructor gebruikt de standaard 10 kingdom cards
    {
        this(new String[]{"Cellar", "Market", "Militia", "Mine", "Moat", "Remodel", "Smithy", "Village", "Woodcutter", "Workshop"});
    }
    
    public Card cardPurchase(int index)
    {
        Card tmp = (Card) supplyCollection[index].get(0); 
        supplyCollection[index].remove(0);
        
        return tmp;
    }
    
    public ArrayList<Card> getSupplyCard(int index)
    {
        return supplyCollection[index];
    }
    
    public ArrayList[] getSupply()
    {
        return supplyCollection;
    }
    
    public boolean isGameOver(int amountPlayers) // nieuwe naam winCondition
    {
        int total = 0;
        for (int i = 0; i < 17; i++) if(supplyCollection[i].isEmpty()) total ++;
        
        if (supplyCollection[6].isEmpty() || total >= 3) return true;
        else return false;
    }
}
