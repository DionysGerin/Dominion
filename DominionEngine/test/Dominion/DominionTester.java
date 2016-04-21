/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominion;

import dominion.Player;
import dominion.Card;
import dominion.CardCollection;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Anas Hamaideh
 */
public class DominionTester {

    private String someplayer;
    private Player testplayer;
    private int playerscore;
    private Card someCard;
    private String cardName;
    private int cardType;
    private int cardCost;
    private CardCollection playerCards;

    @Before
    public void setUP() {
        someplayer = "rob";
        testplayer = new Player(someplayer);
        playerscore = 0;
        cardName = "Village";
        cardType = 1;
        cardCost = 5;
        someCard = new Card(cardName, cardCost, cardType);
        playerCards = new CardCollection();
    }

    @Test
    public void getPlayerName() {
        assertEquals(someplayer, testplayer.getPlayerName());
    }

    @Test
    public void getPlayerScore() {
        assertEquals(playerscore, testplayer.getPlayerScore());
    }

    @Test
    public void getCardName() {
        assertEquals(cardName, someCard.getName());
    }

    @Test
    public void getCardType() {
        String a = "";
        switch (cardType) {
            case 0:
                a = "Treasure Card";
                break;
            case 1:
                a = "Victory Card";
                break;
            case 2:
                a = "Action Card";
                break;
        }
        assertEquals(a, someCard.getType());
    }

    @Test
    public void getCardCost() {
        assertEquals(cardCost, someCard.getCost());
    }

    @Test
    public void deckGrooteBijStart() {
        assertEquals(10, playerCards.getDeck().size());
    }

    @Test
    public void discardGrooteBijStart() {
        assertEquals(0, playerCards.getDiscard().size());
    }

    @Test
    public void supplyGrooteBijStart() {
        assertEquals(0, playerCards.getHand().size());
    }

    @Test
    public void tableGrooteBijStart() {
        assertEquals(0, playerCards.getTable().size());
    }

    @Test
    public void deckPileToDiscard() {
        playerCards.deckPileToDiscard();
        assertEquals(0, playerCards.getDeck().size());
    }

    @Test
    public void discardAllCardsFromHandAndTable() {
        playerCards.discardAllCards();
        assertEquals(0, playerCards.getTable().size());
        assertEquals(0, playerCards.getHand().size());
    }

    @Test
    public void discardOneCardFromHand() {
        playerCards.drawCard(5);
        playerCards.discardCardFromHand(0);

        assertEquals(4, playerCards.getHand().size());
    }
    
    @Test
    public void discardPileToDeck() {
    playerCards.discardAllCards();
    playerCards.deckPileToDiscard();
    playerCards.discardPileToDeck();
    assertEquals(10, playerCards.getDeck().size());
    }
    
    
        
}
