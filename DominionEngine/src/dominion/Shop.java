package dominion;

import java.util.*;

public class Shop 
{
    private ArrayList<ShopCard> Collection;
    
    public Shop() //default constructor met standaard actionkaarten
    {
        
        Collection = new ArrayList(16);
        
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
        Collection.get(index).reduceAmount();
    }
    
    public boolean isEmpty(int index)
    {
        return Collection.get(index).getAmount() == 0;
    }
    
}
