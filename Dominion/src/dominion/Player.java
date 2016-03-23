package dominion;

public class Player
{
	private String playername;
        private int score;
        private Deck playerdeck;
	
	public Player(String name)
	{
		playername = name;
                score = 0;
                playerdeck = new Deck();
	}
	
	public String getPlayerName()
	{
            return playername;
	}
        
        public int getPlayerScore()
        {
            return score;
        }
}
