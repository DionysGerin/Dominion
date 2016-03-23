/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Anas Hamaideh
 */
public class main extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new main().setVisible(true);
    }

    private main() {
        setSize(1280, 960);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton StartButton = new JButton("Start Game");
        JButton SavedGamesButton = new JButton("Saved Games");
        JButton QuitButton = new JButton("Quit Game");
        JButton SettingButton = new JButton("Game Settings");
        add(StartButton);
        add(SavedGamesButton);
        add(QuitButton);
        add(SettingButton);
    }

}
