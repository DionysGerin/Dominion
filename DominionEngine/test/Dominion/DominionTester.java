/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominion;

import dominion.Player;
import dominion.ActionCard;
import dominion.Card;
import dominion.CardCollection;
import dominion.CardCreator;
import dominion.Game;
import dominion.Maintester;
import dominion.MySQLConnector;
import dominion.Shop;
import dominion.ShopCard;
import dominion.TreasureCard;
import dominion.Turn;
import dominion.VictoryCard;
// added by lars 
//import dominion.*; // is dit ok ??? need dat is niet ok zorgt enkel voor problemen

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Anas Hamaideh
 */
public class DominionTester {

    private String someplayer;
    private Player testplayer;

    @Before
    public void setUP() {
        someplayer = "rob";
        testplayer = new Player(someplayer);
    }

    @Test
    public void getplayer() {
        assertEquals(someplayer, testplayer.getPlayerName());
    }

}
