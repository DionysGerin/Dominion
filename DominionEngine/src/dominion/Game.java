package dominion;

import java.util.*;

public class Game 
{
	private ArrayList<Player> players;
	private ActionCard[] shop;
        
        public Game(Player player1, Player player2)
        {
            players = new ArrayList(9);
            players.add(player1);
            players.add(player2);
        }
        
        public ArrayList<Player> getPlayers()
        {
            return players;
        }
}
