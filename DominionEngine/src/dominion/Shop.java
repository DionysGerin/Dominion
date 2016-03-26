package dominion;

import java.util.*;

public class Shop 
{
    private ArrayList<ShopCard> shopCollection; //first card (curse card, index 0) CANT BE SOLD
    private boolean gameOver;
    
    
    public Shop() //default constructor met standaard actionkaarten
    {
        
        shopCollection = new ArrayList(17);
       
        //Curse Card in shop CANT BE SOLD (index 0)
        shopCollection.add(new ShopCard("Curse",10));
        
        //Treasure Cards in Shop
        shopCollection.add(new ShopCard("Copper", 60));
        shopCollection.add(new ShopCard("Silver", 40));
        shopCollection.add(new ShopCard("Gold", 30));
        
        //Victory Cards in Shop
        shopCollection.add(new ShopCard("Estate", 8));
        shopCollection.add(new ShopCard("Duchy", 8));
        shopCollection.add(new ShopCard("Province", 8));
        
        //Action Cards in Shop
        shopCollection.add(new ShopCard("Cellar", 10));
        shopCollection.add(new ShopCard("Market", 10));
        shopCollection.add(new ShopCard("Militia", 10));
        shopCollection.add(new ShopCard("Mine", 10));
        shopCollection.add(new ShopCard("Moat", 10));
        shopCollection.add(new ShopCard("Remodel", 10));
        shopCollection.add(new ShopCard("Smithy", 10));
        shopCollection.add(new ShopCard("Village", 10));
        shopCollection.add(new ShopCard("Woodcutter", 10));
        shopCollection.add(new ShopCard("Workshop", 10));     
    }
    
    public void cardPurchase(int index)
    {
        shopCollection.get(index).reduceAmount(); //Indexes start from 1 because 0 is NOT for sale (curse card) 
            
    }
    
    public ShopCard getShopCard(int index)
    {
        return shopCollection.get(index);
    }
    
    public ArrayList<ShopCard> getShopCollection()
    {
        return shopCollection;
    }
    
    public boolean isGameOver()
    {
        int totaal = 0;
        for (int i = 0; i < 16; i++) if(shopCollection.get(i).getAmount() == 0) totaal ++;
        
        if (shopCollection.get(6).getAmount() == 0 || totaal == 3) return true;
        else return false;
    }
}
