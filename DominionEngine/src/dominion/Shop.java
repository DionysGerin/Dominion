package dominion;

import java.util.*;

public class Shop 
{
    private ArrayList<ShopCard> Collection; //first card (curse card, index 0) CANT BE SOLD
    private boolean gameOver;
    
    public Shop() //default constructor met standaard actionkaarten
    {
        
        Collection = new ArrayList(17);
        
        //Curse Card in shop CANT BE SOLD (index 0)
        Collection.add(new ShopCard("Curse",10));
        
        //Treasure Cards in Shop
        Collection.add(new ShopCard("Copper", 60));
        Collection.add(new ShopCard("Silver", 40));
        Collection.add(new ShopCard("Gold", 30));
        
        //Victory Cards in Shop
        Collection.add(new ShopCard("Estate", 8));
        Collection.add(new ShopCard("Duchy", 8));
        Collection.add(new ShopCard("Province", 8));
        
        //Action Cards in Shop
        Collection.add(new ShopCard("Cellar", 10));
        Collection.add(new ShopCard("Market", 10));
        Collection.add(new ShopCard("Militia", 10));
        Collection.add(new ShopCard("Mine", 10));
        Collection.add(new ShopCard("Moat", 10));
        Collection.add(new ShopCard("Remodel", 10));
        Collection.add(new ShopCard("Smithy", 10));
        Collection.add(new ShopCard("Village", 10));
        Collection.add(new ShopCard("Woodcutter", 10));
        Collection.add(new ShopCard("Workshop", 10));     
    }
    
    public void cardPurchase(int index)
    {
        Collection.get(index).reduceAmount(); //Indexes start from 1 because 0 is NOT for sale (curse card)
    }
    
    public ShopCard getShopCard(int index)
    {
        return Collection.get(index);
    }
    
    public Collection getCollection()
    {
        return Collection;
    }
    
    public boolean isGameOver()
    {
        int totaal = 0;
        for (int i = 0; i < 16; i++) if(Collection.get(i).getAmount() == 0) totaal ++;
        
        if (Collection.get(6).getAmount() == 0 || totaal == 3) return true;
        else return false;
    }
}
