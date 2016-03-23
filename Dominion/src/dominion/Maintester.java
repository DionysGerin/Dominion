package dominion;

import java.util.*;

public class Maintester 
{
    public static void main(String[] args)
    {
        Player player1 = new Player("Dio");
        Player player2 = new Player("Lars");
        Game game = new Game(player1, player2);      
        
        for (int i = 0; i < game.getPlayers().size(); i++)
        {
            System.out.println("Player " + (i + 1) + ": " + game.getPlayers().get(i).getPlayerName());
            System.out.println(); 
            for (int j = 0; j < game.getPlayers().get(i).getCardCollection().getDeck().size();j++)
            {
                System.out.println("Name: " + game.getPlayers().get(i).getCardCollection().getDeck().get(i).getName());
                System.out.println("Cost: " + game.getPlayers().get(i).getCardCollection().getDeck().get(i).getCost());
                System.out.println("Value: " + game.getPlayers().get(i).getCardCollection().getDeck().get(i).getValue());
                System.out.println("Type: " + game.getPlayers().get(i).getCardCollection().getDeck().get(i).getType());
                System.out.println();
            }
        }
    }
}
