package dominion;

import java.util.*;

public class Game 
{
	private ArrayList<Player> players;
	private ArrayList<ActionCard> choosenShop;
        
        public Game(Player player1, Player player2/*, ActionCard card1, ActionCard card2, ActionCard card3, ActionCard card4, ActionCard card5, ActionCard card6, ActionCard card7, ActionCard card8, ActionCard card9, ActionCard card10*/)
        {
            players = new ArrayList(9);
            players.add(player1);
            players.add(player2);
            
            choosenShop = new ArrayList(10);
            /*choosenShop.add(card1);
            choosenShop.add(card2);
            choosenShop.add(card3);
            choosenShop.add(card4);
            choosenShop.add(card5);
            choosenShop.add(card6);
            choosenShop.add(card7);
            choosenShop.add(card8);
            choosenShop.add(card9);
            choosenShop.add(card10);*/
            
        }
        
        public ArrayList<Player> getPlayers()
        {
            return players;
        }
}
