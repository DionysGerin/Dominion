package dominion;

public class Player
{
	private String playerName;
        private int score;
	
	public Player(String name)
	{
		playerName = name;
                score = 0;
	}
	
	public String getName()
	{
            return playerName;
	}
        
        public int getScore()
        {
            return score;
        }
}
