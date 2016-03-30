
//Mohammed Faris 

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.DropMode;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class Mulitpage {

	private JFrame frame;
	private JPanel main;
	private JPanel playername;
	private JPanel loadGame;
	private JPanel settingsPage;
	private JPanel startGamePage;
	private JTextField txtKjhgf;
	private JTextField txtPlayer;
	private JPanel agreement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mulitpage window = new Mulitpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mulitpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Dominion");
		frame.setBounds(100, 100, 1280, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		main = new JPanel();
		frame.getContentPane().add(main, "name_1459331437161496000");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new CompoundBorder());
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(485, 311, 309, 74);
		btnNewButton.setSelectedIcon(new ImageIcon("media/newgame"));
		btnNewButton.setIcon(new ImageIcon("media/newgame"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playername.setVisible(true);
				main.setVisible(false);
			}
		});
		main.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(new CompoundBorder());
		btnNewButton_3.setIcon(new ImageIcon("media/agreement.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agreement.setVisible(true);
				main.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(6, 514, 183, 162);
		main.add(btnNewButton_3);
		main.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setBorder(new CompoundBorder());
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setBounds(485, 387, 309, 74);
		button.setIcon(new ImageIcon("media/Load game.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGame.setVisible(true);
				main.setVisible(false);
			}
		});
		main.add(button);
		
		JButton btnExit = new JButton("");
		btnExit.setBorder(new CompoundBorder());
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setBounds(485, 463, 309, 74);
		btnExit.setIcon(new ImageIcon("media/Quit.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		main.add(btnExit);
		
		JButton btnNewButton_1 = new JButton("Settings");
		btnNewButton_1.setBorder(new CompoundBorder());
		btnNewButton_1.setDisabledSelectedIcon(new ImageIcon("/Users/Matt/Desktop/network-icon copy.png"));
		btnNewButton_1.setDisabledIcon(new ImageIcon("/Users/Matt/Desktop/network-icon copy.png"));
		btnNewButton_1.setBounds(1068, 514, 212, 162);
		btnNewButton_1.setIcon(new ImageIcon("media/stting.png"));
		btnNewButton_1.setSelectedIcon(new ImageIcon("/Users/Matt/Desktop/ISync_icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPage.setVisible(true);
				main.setVisible(false);
			}
		});
		main.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1280, 687);
		lblNewLabel_1.setIcon(new ImageIcon("media/mainPage.jpg"));
		main.add(lblNewLabel_1);
		
		playername = new JPanel();
		frame.getContentPane().add(playername, "name_1458821108095997000");
		
		JButton btnName = new JButton("");
		btnName.setBorder(new CompoundBorder());
		btnName.setHorizontalTextPosition(SwingConstants.CENTER);
		btnName.setIcon(new ImageIcon("media/Back copy.png"));
		btnName.setBounds(41, 590, 196, 73);
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				playername.setVisible(false);
			}
		});
		playername.setLayout(null);
		
		JLabel lblSecondPlayer = new JLabel("Second Player");
		lblSecondPlayer.setBounds(445, 378, 196, 73);
		lblSecondPlayer.setForeground(new Color(51, 51, 0));
		lblSecondPlayer.setFont(new Font("Beyond Wonderland", Font.BOLD, 31));
		playername.add(lblSecondPlayer);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(407, 386, 45, 65);
		lblNewLabel_5.setIcon(new ImageIcon("media/2.png"));
		playername.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(407, 315, 45, 59);
		lblNewLabel_4.setIcon(new ImageIcon("media/1.png"));
		playername.add(lblNewLabel_4);
		
		JLabel lblFirstPlayer = new JLabel("First Player");
		lblFirstPlayer.setBounds(451, 307, 169, 73);
		lblFirstPlayer.setFont(new Font("Beyond Wonderland", Font.BOLD, 31));
		lblFirstPlayer.setForeground(new Color(51, 51, 0));
		playername.add(lblFirstPlayer);
		playername.add(btnName);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new CompoundBorder());
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setBounds(455, 467, 363, 81);
		btnNewButton_2.setIcon(new ImageIcon("media/startgame.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGamePage.setVisible(true);
				playername.setVisible(false);
			}
		});
		playername.add(btnNewButton_2);
		
		txtKjhgf = new JTextField();
		txtKjhgf.setBounds(619, 321, 235, 45);
		txtKjhgf.setForeground(Color.WHITE);
		txtKjhgf.setText("Player1");
		txtKjhgf.setBackground(new Color(102, 51, 0));
		playername.add(txtKjhgf);
		txtKjhgf.setColumns(10);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(619, 398, 235, 45);
		txtPlayer.setForeground(Color.WHITE);
		txtPlayer.setText("player2");
		txtPlayer.setColumns(10);
		txtPlayer.setBackground(new Color(102, 51, 0));
		playername.add(txtPlayer);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(398, 243, 479, 325);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("media/subpage.jpg"));
		playername.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 1280, 687);
		lblNewLabel_3.setIcon(new ImageIcon("media/2dPage.jpg"));
		playername.add(lblNewLabel_3);
		
		loadGame = new JPanel();
		frame.getContentPane().add(loadGame, "name_1458821078988138000");
		
		JButton btnBack = new JButton("");
		btnBack.setBorder(new CompoundBorder());
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setIcon(new ImageIcon("media/Back copy.png"));
		btnBack.setBounds(33, 577, 196, 77);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				loadGame.setVisible(false);
			}
		});
		loadGame.setLayout(null);
		loadGame.add(btnBack);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("media/2dPage.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1280, 687);
		loadGame.add(lblNewLabel_6);
		
		settingsPage  = new JPanel();
		frame.getContentPane().add(settingsPage, "name_1459331780689081000");
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.setBounds(63, 560, 199, 77);
		btnBack_1.setBorder(new CompoundBorder());
		btnBack_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack_1.setIcon(new ImageIcon("media/Back copy.png"));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				settingsPage.setVisible(false);
			}
		});
		settingsPage.setLayout(null);
		
		JToggleButton rdbtnNewRadioButton = new JToggleButton("");
		rdbtnNewRadioButton.setBorder(new CompoundBorder());
		rdbtnNewRadioButton.setIcon(new ImageIcon("media/music.png"));
		rdbtnNewRadioButton.setBounds(589, 358, 101, 93);
		settingsPage.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setDisplayedMnemonic(KeyEvent.VK_SHIFT);
		lblNewLabel_9.setIcon(new ImageIcon("media/subpage.jpg"));
		lblNewLabel_9.setBounds(383, 227, 513, 367);
		settingsPage.add(lblNewLabel_9);
		settingsPage.add(btnBack_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setDisplayedMnemonic(KeyEvent.VK_CONVERT);
		lblNewLabel_2.setBounds(0, 0, 1280, 688);
		lblNewLabel_2.setIcon(new ImageIcon("media/agrement2.jpg"));
		settingsPage.add(lblNewLabel_2);
		
		startGamePage = new JPanel();
		frame.getContentPane().add(startGamePage, "name_1459331481612426000");
		startGamePage.setBackground(new Color(0, 100, 0));
		startGamePage.setLayout(null);
		
		agreement = new JPanel();
		frame.getContentPane().add(agreement, "name_1459334069775870000");
		agreement.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				agreement.setVisible(false);
			}
		});
		btnNewButton_4.setBorder(new CompoundBorder());
		btnNewButton_4.setIcon(new ImageIcon("/Users/Matt/Desktop/Untitled Export/ex.png"));
		btnNewButton_4.setBounds(834, 110, 49, 39);
		agreement.add(btnNewButton_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBorder(new CompoundBorder());
		lblNewLabel_8.setIcon(new ImageIcon("media/testagrement.png"));
		lblNewLabel_8.setBounds(266, 16, 747, 660);
		agreement.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("media/agrement2.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1280, 687);
		agreement.add(lblNewLabel_7);
	}
}
