package dominion;

public class Player
{
	private String playerName;
        private int score;
        private CardCollection playerCollection;
	
	public Player(String name)
	{
		playerName = name;
                score = 0;
                playerCollection = new CardCollection();
	}
	
	public String getPlayerName()
	{
            return playerName;
	}
        
        public int getPlayerScore()
        {
            return score;
        }
        
        public CardCollection getCardCollection()
        {
            return playerCollection;
        }
        
        public void setPlayerScore(int score)
        {
            this.score = score;
        }
}
