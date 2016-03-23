package dominion;

public class Player
{
	private String playername;
        private int score;
	
	public Player(String name)
	{
		playername = name;
                score = 0;
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
