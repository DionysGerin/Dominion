package dominion;

import java.util.ArrayList;

// Waarom gebruiken we eigenlijk inheritants ? is er daar een reden voor dionys?? kunnen we niet beter gewoon 3 klassen maken voor de soorten kaarten ?
//ander los als de f*** shit op da nie werkt door inheritance 
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
                if (cardFromDeck.getType() == 0) System.out.println("Value: " + cardFromDeck.getTreasurePoints());
                System.out.println("Type: " + cardFromDeck.getType());
                System.out.println();
            }
        }
        
        TreasureCard tcard = new TreasureCard("Diamant",100, 90);
        System.out.println(tcard.getTreasurePoints());
        
        /*while (!winconditie)
        {
            turn.p1;
            game.player.collection.deck.takeCards
            turn.p2;
        }*/        
    }
}
