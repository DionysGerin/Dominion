package dominion;

import java.util.ArrayList;


public class Maintester 
{
    public static void main(String[] args)
    {
        Player player1 = new Player("Dio");
        Player player2 = new Player("Lars");
        Game game = new Game(player1, player2);      
        
        for (int i = 1; i < game.getPlayers().size(); i++)
        {
            System.out.println("Player " + (i + 1) + ": " + game.getPlayers().get(i).getPlayerName());
            System.out.println(); 
            ArrayList<Card> deck = game.getPlayers().get(i).getCardCollection().getDeck();
            for (int j = 0; j < deck.size();j++)
            {
                System.out.println("Name: " + game.getPlayers().get(i).getCardCollection().getDeck().get(j).getName());
                System.out.println("Cost: " + game.getPlayers().get(i).getCardCollection().getDeck().get(j).getCost());
                System.out.println("Value: " + game.getPlayers().get(i).getCardCollection().getDeck().get(j).getValue());
                System.out.println("Type: " + game.getPlayers().get(i).getCardCollection().getDeck().get(j).getType());
                System.out.println();
            }
        }
    }
}
