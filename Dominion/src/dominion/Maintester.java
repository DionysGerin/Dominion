package dominion;


public class Maintester 
{
    public static void main(String[] args)
    {
        Player player1 = new Player("Dio");
        Player player2 = new Player("Lars");
        Game game = new Game(player1, player2);
        System.out.println(game.getPlayers());
        System.out.println();
        
        //TreasureCard tc1 = new TreasureCard("Copper", 0, 1);
        //TreasureCards tc2 = new TreasureCards("Silver", 3, 2);
        //TreasureCards tc3 = new TreasureCards("Gold", 6, 3);
        //VictoryCard vc1 = new VictoryCard("Estate", 2, 1);
        //VictoryCard vc2 = new VictoryCard("Duchy", 5, 3);
        //VictoryCard vc3 = new VictoryCard("Province", 8, 6);
        
        
        Deck deck = new Deck();
        System.out.println(deck.getDeck());
    }
}
