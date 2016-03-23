package dominion;

public class Player
{
	private String playername;
        private int score;
        private CardCollection playercollection;
	
	public Player(String name)
	{
		playername = name;
                score = 0;
                playercollection = new CardCollection();
	}
	
	public String getPlayerName()
	{
            return playername;
	}
        
        public int getPlayerScore()
        {
            return score;
        }
        
        public CardCollection getCardCollection()
        {
            return playercollection;
        }
}
