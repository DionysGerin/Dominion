/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominion;

import dominion.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anas Hamaideh
 */
public class DominionTester {
    
    @Test
    public void getplayer() {
        String someplayer = "rob";
        Player a;
        a = new Player(someplayer);

        assertEquals(someplayer, a.getPlayerName());
    }
}

