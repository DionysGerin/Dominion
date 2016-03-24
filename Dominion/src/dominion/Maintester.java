package dominion;

import java.util.ArrayList;


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
            ArrayList<Card> deck = game.getPlayers().get(i).getCardCollection().getDeck();
            
            for (int j = 0; j < deck.size();j++)
            {
                Card cardFromDeck = deck.get(j);
                
                System.out.println("Name: " + cardFromDeck.getName());
                System.out.println("Cost: " + cardFromDeck.getCost());
                System.out.println("Value: " + cardFromDeck.getValue());
                System.out.println("Type: " + cardFromDeck.getType());
                System.out.println();
            }
        }
    }
}
