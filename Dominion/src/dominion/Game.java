package dominion;

public class Game 
{
	private Player[] players;
	private ActionCard[] shop;
        
        public Game(Player player1, Player player2)
        {
            players = new Player[2];
            players[0] = player1;
            players[1] = player2;
        }
        
        public String getPlayers()
        {
            return players[0].getPlayerName() + ' ' + players[1].getPlayerName();
        }
}
