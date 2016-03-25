package dominion;

import java.util.*;

public class Game 
{
	private ArrayList<Player> players;
	private Shop shop;
        
        public Game(Player player1, Player player2)
        {
            players = new ArrayList(9);
            players.add(player1);
            players.add(player2);
            
            shop = new Shop();
        }
        
        public ArrayList<Player> getPlayers()
        {
            return players;
        }
        
        public Player getPlayer(int index)
        {
            return players.get(index);
        }
        
        public Shop getShop()
        {
            return shop;
        }
}
