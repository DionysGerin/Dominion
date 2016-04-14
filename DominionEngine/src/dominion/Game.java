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
        
        public void calculateScore()
        {
            for (Player player : players)
            {
                //Add all cards to the deck pile so we can check for victory points
                player.getCardCollection().discardAllCards();
                player.getCardCollection().discardPileToDeck();
                
                //Calculate the score
                int score = 0;
                for (Card card : player.getCardCollection().getDeck())
                {
                    if (card.getName().equals("Estate")) score ++;
                    if (card.getName().equals("Duchy")) score += 3;
                    if (card.getName().equals("Province")) score += 6;
                    if (card.getName().equals("Gardens")) score += player.getCardCollection().getDeck().size()/10;
                }
                
                //Set playerscore
                player.setPlayerScore(score);
            }
        }
        
        public void getWinner()
        {
            calculateScore();
            for (Player player : players) System.out.println(player.getPlayerName() + " :" + player.getPlayerScore());
        }
}
