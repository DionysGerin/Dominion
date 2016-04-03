package dominion;

import java.util.*;

public class Game 
{
	private ArrayList<Player> players;
	private Supply supply; //We zullen hier de 10 gekozen kaarten moeten meegeven
        
        public Game(Player player1, Player player2)
        {
            players = new ArrayList(9);
            players.add(player1);
            players.add(player2);
            
            supply = new Supply();
        }
        
        public ArrayList<Player> getPlayers()
        {
            return players;
        }
        
        public Player getPlayer(int index)
        {
            return players.get(index);
        }
        
        public Supply getSupply()
        {
            return supply;
        }
}
