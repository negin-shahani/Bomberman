package ir.ac.guilan.ce96.neginshahani.project7;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;

public class BomberManPage extends JFrame {

	static JPanel contentPane;
	private static ArrayList<ArrayList<JButton>> buttons = new ArrayList<>();
	static BomberManPage frame;
	static Integer seconds = 0;
	private static JTextField textField;
	private static Timer timer = new Timer();
	private static JTextField textField_2;
	static double heart = 10;
	private static JLabel label_1 = new JLabel("");
	private static File file;
	static int length = 1900 / profile.rows;
	static int Width = 800 / profile.columns;
	public static Random random = new Random();
	static boolean[][] check;
	static int aliennum = 0;
	static boolean[][] checkAlien;
	private static int bombermanX;
	private static int bombermanY;
	static int startBomb = 1000000000;
	private static int xOfBomb;
	private static int yOfBomb;
	static int radius = 1;
	static int startHeart = 1000000000;
	private static int randheart1;
	private static int randheart2;
	static int startStar = 1000000000;
	static int finishStar = 1000000000;
	private static int randStar1;
	private static int randStar2;
	public static int record;
	static int bombs = 0;
	private static JTextField textField_1;
	private static JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BomberManPage(); // make a new frame for this page
					frame.setVisible(true); // set the frame editable and focusable
					frame.setFocusable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BomberManPage() {
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37 && bombermanY - 1 > 0) { // to go to the left
					findHeart(bombermanX, bombermanY - 1);
					findStar(bombermanX, bombermanY - 1);
					if (buttons.get(bombermanX).get(bombermanY - 1).getBackground().equals(Color.GREEN)
							&& !checkAlien[bombermanX][bombermanY - 1]) {
						bombermanY = bombermanY - 1;
						buttons.get(bombermanX).get(bombermanY)
								.setIcon(buttons.get(bombermanX).get(bombermanY + 1).getIcon());
						buttons.get(bombermanX).get(bombermanY + 1).setIcon(null);
					} else if (checkAlien[bombermanX][bombermanY - 1]) { // if there are an alien then move it
						heart = heart - 1; // then low off the heart
						profile.alienNumber -= 1; // and low off the number of aliens
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkAlien[bombermanX][bombermanY - 1] = false;
						buttons.get(bombermanX).get(bombermanY - 1)
								.setIcon(buttons.get(bombermanX).get(bombermanY).getIcon());
						buttons.get(bombermanX).get(bombermanY).setIcon(null);
						bombermanY = bombermanY - 1;
						textField_2.setText(String.valueOf(heart));
						checkEnding();
					}
				}
				if (e.getKeyCode() == 38 && bombermanX - 1 > 0) { // to go to the up
					findHeart(bombermanX - 1, bombermanY);
					findStar(bombermanX - 1, bombermanY);
					if (buttons.get(bombermanX - 1).get(bombermanY).getBackground().equals(Color.GREEN)
							&& !checkAlien[bombermanX - 1][bombermanY]) {
						bombermanX = bombermanX - 1;
						buttons.get(bombermanX).get(bombermanY)
								.setIcon(buttons.get(bombermanX + 1).get(bombermanY).getIcon());
						buttons.get(bombermanX + 1).get(bombermanY).setIcon(null);
					} else if (checkAlien[bombermanX - 1][bombermanY]) { // if there are an alien then move it
						heart = heart - 1; // then low off the heart
						profile.alienNumber -= 1; // and low off the number of aliens
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkAlien[bombermanX - 1][bombermanY] = false;
						buttons.get(bombermanX - 1).get(bombermanY)
								.setIcon(buttons.get(bombermanX).get(bombermanY).getIcon());
						buttons.get(bombermanX).get(bombermanY).setIcon(null);
						bombermanX = bombermanX - 1;
						textField_2.setText(String.valueOf(heart));
						checkEnding();
					}
				}
				if (e.getKeyCode() == 39 && bombermanY + 1 < profile.columns) { // to go to the right
					findHeart(bombermanX, bombermanY + 1);
					findStar(bombermanX, bombermanY + 1);
					if (buttons.get(bombermanX).get(bombermanY + 1).getBackground().equals(Color.GREEN)
							&& !checkAlien[bombermanX][bombermanY + 1]) {
						bombermanY = bombermanY + 1;
						buttons.get(bombermanX).get(bombermanY)
								.setIcon(buttons.get(bombermanX).get(bombermanY - 1).getIcon());
						buttons.get(bombermanX).get(bombermanY - 1).setIcon(null);
					} else if (checkAlien[bombermanX][bombermanY + 1]) { // if there are an alien then move it
						heart = heart - 1; // then low off the heart
						profile.alienNumber -= 1; // and low off the number of aliens
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkAlien[bombermanX][bombermanY + 1] = false;
						buttons.get(bombermanX).get(bombermanY + 1)
								.setIcon(buttons.get(bombermanX).get(bombermanY).getIcon());
						buttons.get(bombermanX).get(bombermanY + 1).setIcon(null);
						bombermanY = bombermanY + 1;
						textField_2.setText(String.valueOf(heart));
						checkEnding();
					}
				}
				if (e.getKeyCode() == 40 && bombermanX + 1 < profile.rows) { // to go to the down
					findHeart(bombermanX + 1, bombermanY);
					findStar(bombermanX + 1, bombermanY);
					if (buttons.get(bombermanX + 1).get(bombermanY).getBackground().equals(Color.GREEN)
							&& !checkAlien[bombermanX + 1][bombermanY]) {
						bombermanX = bombermanX + 1;
						buttons.get(bombermanX).get(bombermanY)
								.setIcon(buttons.get(bombermanX - 1).get(bombermanY).getIcon());
						buttons.get(bombermanX - 1).get(bombermanY).setIcon(null);
					} else if (checkAlien[bombermanX + 1][bombermanY]) { // if there are an alien then move it
						heart = heart - 1; // then low off the heart
						profile.alienNumber -= 1; // and low off the number of aliens
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkAlien[bombermanX + 1][bombermanY] = false;
						buttons.get(bombermanX + 1).get(bombermanY)
								.setIcon(buttons.get(bombermanX).get(bombermanY).getIcon());
						buttons.get(bombermanX).get(bombermanY).setIcon(null);
						bombermanX = bombermanX + 1;
						textField_2.setText(String.valueOf(heart));
						checkEnding();
					}
				}
				if (e.getKeyCode() == 10) { // set the bomb
					if (seconds - startBomb > 3 || seconds - startBomb < 0) { // check the suitable time
						startBomb = seconds; // the time that the bomb sets
						xOfBomb = bombermanX; // the place where the bomb sets(x)
						yOfBomb = bombermanY; // the place where the bomb sets(y)
						bombs++;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 684);
		contentPane = new JPanel(); // make a new panel
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel(); // make a new frame and set the gridlayout
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(12, 175, 978, 449);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(profile.rows, profile.columns, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(12, 13, 978, 149);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(12, 13, 120, 123);
		panel_1.add(label);
		try { // set the default image to the new icon
			Image image1 = ImageIO.read(profile.file);
			image1 = image1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			label.setIcon(new ImageIcon(image1)); // add the image to the labletime

			textField = new JTextField();
			textField.setBackground(new Color(178, 34, 34));
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("Lucida Fax", Font.BOLD, 16));
			textField.setBounds(233, 7, 147, 35);
			panel_1.add(textField);
			textField.setColumns(10);
			textField.setText(WelcomePage.username);
			textField.setEditable(false);

			// this button is for the user to access to the profile page
			JButton btnShowTheProfile = new JButton("show the profile");
			btnShowTheProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					profile.main(null); // open the page of profile
				}
			}); // design the button
			btnShowTheProfile.setFont(new Font("Lucida Fax", Font.BOLD, 13));
			btnShowTheProfile.setForeground(new Color(139, 0, 0));
			btnShowTheProfile.setBackground(Color.WHITE);
			btnShowTheProfile.setBounds(766, 13, 160, 29);
			panel_1.add(btnShowTheProfile);

			// this buttton is for user to start a game
			JButton btnNewGame = new JButton("new game");
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BomberManPage.frame.setVisible(false); // close the BomberManPage for hours
					BomberManPage.contentPane.setVisible(false); // close the BomberManPage for hours
					profile.main(null); // open the safe relationship
				}
			}); // design the bottun
			btnNewGame.setBackground(Color.WHITE);
			btnNewGame.setForeground(new Color(139, 0, 0));
			btnNewGame.setFont(new Font("Lucida Fax", Font.BOLD, 16));
			btnNewGame.setBounds(766, 55, 160, 33);
			panel_1.add(btnNewGame);

			JLabel lblTime = new JLabel("Time :"); // make a new lable named time
			lblTime.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			lblTime.setForeground(Color.WHITE);
			lblTime.setBackground(Color.WHITE);
			lblTime.setBounds(144, 90, 77, 35);
			panel_1.add(lblTime);

			JLabel lblHearts = new JLabel("Heart :");// make a new lable named heart
			lblHearts.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			lblHearts.setForeground(Color.WHITE);
			lblHearts.setBounds(144, 61, 92, 16);
			panel_1.add(lblHearts);

			textField_2 = new JTextField();
			textField_2.setForeground(Color.WHITE);
			textField_2.setBackground(new Color(178, 34, 34));
			textField_2.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			textField_2.setBounds(233, 55, 147, 35);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			textField_2.setEditable(false);
			textField_2.setText(String.valueOf(heart));

			JLabel lblName = new JLabel("Name :");
			lblName.setForeground(Color.WHITE);
			lblName.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			lblName.setBounds(144, 17, 77, 16);
			panel_1.add(lblName);

			label_1.setBackground(Color.WHITE);// make a new lable named "name"
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			label_1.setBounds(233, 90, 378, 35);
			panel_1.add(label_1);

			JLabel lblDeadAliens = new JLabel("RemainAliens :");
			lblDeadAliens.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			lblDeadAliens.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeadAliens.setForeground(Color.WHITE);
			lblDeadAliens.setBounds(392, 13, 178, 29);
			panel_1.add(lblDeadAliens);

			textField_1 = new JTextField();
			textField_1.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			textField_1.setForeground(Color.WHITE);
			textField_1.setBackground(new Color(178, 34, 34));
			textField_1.setBounds(582, 13, 116, 29);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(String.valueOf(profile.alienNumber));

			JLabel lblNumberOfGem = new JLabel("Number of Gem:");// make a new lable named
			lblNumberOfGem.setFont(new Font("Lucida Fax", Font.BOLD, 20));
			lblNumberOfGem.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumberOfGem.setForeground(Color.WHITE);
			lblNumberOfGem.setBounds(392, 64, 182, 16);
			panel_1.add(lblNumberOfGem);

			textField_3 = new JTextField();
			textField_3.setBackground(new Color(178, 34, 34));
			textField_3.setBounds(582, 55, 116, 28);
			panel_1.add(textField_3);
			textField_3.setColumns(10);

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addComponentListener(new ComponentAdapter() { // to change the pae with the resize
			@Override
			public void componentResized(ComponentEvent arg0) {
				panel.setBounds(12, 175, 1900, 800);
				panel_1.setBounds(0, 0, 1995, 141);
			}
		});
		for (int i = 0; i < profile.rows; i++) {
			ArrayList<JButton> arrayList = new ArrayList<>();
			buttons.add(arrayList);
			for (int j = 0; j < profile.columns; j++) {
				JButton button = new JButton();
				buttons.get(i).add(button);
				buttons.get(i).get(j).setFocusable(false);
				buttons.get(i).get(j).setBackground(Color.GREEN);
				panel.add(buttons.get(i).get(j));
			}
		}
		check = new boolean[profile.rows][profile.columns];
		for (int k = 0; k < profile.rows; k++) {    //initialize the array of boolean check[][]
			for (int l = 0; l < profile.columns; l++) {
				check[k][l] = true;
			}
		}
		checkAlien = new boolean[profile.rows][profile.columns];
		for (int k = 0; k < profile.rows; k++) {        //initialize the array of boolean checkAlien[][]
			for (int l = 0; l < profile.columns; l++) {
				checkAlien[k][l] = false;
			}
		}
		for (int i = 0; i < profile.rows; i++) {
			for (int j = 0; j < profile.columns; j++) { // make the iron walls
				if (i == 0 || j == 0 || i == profile.rows - 1 || j == profile.columns - 1
						|| (i % 2 == 0 && j % 2 == 0)) {
					check[i][j] = false;
					try { // set the default image to the new icon
						file = new File("./resource/Items/40-40_BrickDarkGray.png");
						Image image1 = ImageIO.read(file);
						buttons.get(i).get(j).setBackground(Color.GRAY);
						buttons.get(i).get(j)
								.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add
																														// the
																														// image
																														// to
																														// the
																														// labletime
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					int rand = random.nextInt(2) + 0;			 // make the sangi walls
					if (rand == 1) {
						check[i][j] = false;
						try { 					// set the default image to the new icon
							file = new File("./resource/Items/40-40_BrickBrown.png");
							Image image1 = ImageIO.read(file);
							buttons.get(i).get(j).setBackground(Color.orange);
							buttons.get(i).get(j).setIcon(
									new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add
																													// the
																													// image
																													// to
																													// the
																													// labletime
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		while (true) { // set the enemies in the page
			int rand1 = random.nextInt(profile.rows) + 0;
			int rand2 = random.nextInt(profile.columns) + 0;
			if (check[rand1][rand2] == true) {
				checkAlien[rand1][rand2] = true;
				int pic = random.nextInt(5) + 1;
				aliennum++;
				check[rand1][rand2] = false;
				try { // set the default image to the new icon
					file = new File("./resource/Enemies/" + String.valueOf(pic) + ".png");
					Image image1 = ImageIO.read(file);
					buttons.get(rand1).get(rand2)
							.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add
																													// the
																													// image
																													// to
																													// the
																													// labletime
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (aliennum == profile.alienNumber) {
				break;
			}
		}
		while (true) { // set the bomberman by using random
			bombermanX = random.nextInt(profile.rows) + 0;
			bombermanY = random.nextInt(profile.columns) + 0;
			if (check[bombermanX][bombermanY]) {
				try { // set the default image to the new icon
					Image image1 = ImageIO.read(profile.file);
					buttons.get(bombermanX).get(bombermanY)
							.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add
																													// the
																													// image
																													// to
																													// the
																													// labletime
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		BomberManPage.MyTimer();
	}

	private static void MyTimer() {
		seconds = 0;
		TimerTask task;
		task = new TimerTask() {
			private final int MAX_SECONDS = 1000000000;

			@Override
			public void run() {
				if (seconds < MAX_SECONDS) {
					seconds++;
					label_1.setText(seconds.toString());
					moveRandomAlien(); // a method than is for moving aliens!!
					if (seconds - startBomb == 2) // after two seconds set the pic of bomb
						setTheBOMb();
					if (seconds - startBomb == 3) // after three seconds the bomb will explode
						explosion();
					if (seconds % 40 == 0)
						setTheHeart();
					if (seconds - startHeart == 20) { // to clear the heart from the page
						buttons.get(randheart1).get(randheart2).setBackground(Color.GREEN);
						buttons.get(randheart1).get(randheart2).setIcon(null);
					}
					if (seconds % 50 == 0)
						setTheStar();
					if (seconds - startStar == 40) { // to clear the star from the page
						buttons.get(randStar1).get(randStar2).setBackground(Color.GREEN);
						buttons.get(randStar1).get(randStar2).setIcon(null);
					}
					if (seconds - finishStar == 20)
						radius = radius / 2;
				} else { // stop the timer
					cancel();
				}
			}
		};
		BomberManPage.timer.schedule(task, 0, 1000);
	}

	private static void moveRandomAlien() { // the aliens would move randomly
		for (int i = 0; i < profile.rows; i++) {
			for (int j = 0; j < profile.columns; j++) {
				if (checkAlien[i][j]) {
					int randMove = random.nextInt(4) + 1;

					switch (randMove) {
					case 1: // move to up
						if (buttons.get(i - 1).get(j).getBackground().equals(Color.GREEN) && !checkAlien[i - 1][j]
								&& (i - 1 != bombermanX || j != bombermanY)) {
							buttons.get(i - 1).get(j).setIcon(buttons.get(i).get(j).getIcon());
							buttons.get(i).get(j).setIcon(null);
							checkAlien[i - 1][j] = true;
							checkAlien[i][j] = false;
						}
						break;
					case 2: // move to down
						if (buttons.get(i + 1).get(j).getBackground().equals(Color.GREEN) && !checkAlien[i + 1][j]
								&& (i + 1 != bombermanX || j != bombermanY)) {
							buttons.get(i + 1).get(j).setIcon(buttons.get(i).get(j).getIcon());
							buttons.get(i).get(j).setIcon(null);
							checkAlien[i + 1][j] = true;
							checkAlien[i][j] = false;
						}
						break;
					case 3: // move to right
						if (buttons.get(i).get(j + 1).getBackground().equals(Color.GREEN) && !checkAlien[i][j + 1]
								&& (i != bombermanX || j + 1 != bombermanY)) {
							buttons.get(i).get(j + 1).setIcon(buttons.get(i).get(j).getIcon());
							buttons.get(i).get(j).setIcon(null);
							checkAlien[i][j + 1] = true;
							checkAlien[i][j] = false;
						}
						break;
					case 4: // move to left
						if (buttons.get(i).get(j - 1).getBackground().equals(Color.GREEN) && !checkAlien[i][j - 1]
								&& (i != bombermanX || j - 1 != bombermanY)) {
							buttons.get(i).get(j - 1).setIcon(buttons.get(i).get(j).getIcon());
							buttons.get(i).get(j).setIcon(null);
							checkAlien[i][j - 1] = true;
							checkAlien[i][j] = false;
						}
						break;
					}
				}
			}
		}

	}

	private static void checkEnding() {
		int c = 2, i;
		for (i = 0; c < bombs; i++) {
			c *= 2;
		}
		int timeRecord = seconds;
		if (profile.alienNumber == 0) {   //if the number of aliens become zero, the game will end!!
			BomberManPage.contentPane.setVisible(false);  //close the page of the game 
			BomberManPage.frame.setVisible(false);       
			WinPage.main(null);                        //open the page of the winner
			record = (int) ((Math.pow(aliennum, 4)) / ((timeRecord / 60) + Math.log(bombs))); //calculate the record of user
			WelcomePage.score = record;
			writer();  //write the record of user in the text
		}
		if (heart <= 0) {     //if the heart of the user become under zero the user wil fail
			BomberManPage.contentPane.setVisible(false);  //close the page of game
			BomberManPage.frame.setVisible(false);
			LosePage.main(null);                 //open the page of the loser
			record = aliennum / ((timeRecord / 60) + i);   //calculate the record of the user
			WelcomePage.score = record;
			writer();
		}
	}
	//this methos will check the ability of explosion of each button
	private static void explosion() {
		int r = radius;
		heart = heart - 0.5;  //with each bomb the heart of user will become lower
		textField_2.setText(String.valueOf(heart));
		buttons.get(xOfBomb).get(yOfBomb).setBackground(Color.GREEN);  //set the color of bomb's place "green"
		buttons.get(xOfBomb).get(yOfBomb).setIcon(null);  //and set its icon null
		try { 		// set the default image to the new icon
			Image image1 = ImageIO.read(profile.file);
			buttons.get(bombermanX).get(bombermanY)
					.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add the image to the lable
																											
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (r != 0) {  //r is the radius of exploding bombs
			if (xOfBomb - r >= 0) {      //explode the butoons above the bomb
				if (checkAlien[xOfBomb - r][yOfBomb]
						|| buttons.get(xOfBomb - r).get(yOfBomb).getBackground().equals(Color.orange)) {
					buttons.get(xOfBomb - r).get(yOfBomb).setBackground(Color.GREEN);
					buttons.get(xOfBomb - r).get(yOfBomb).setIcon(null);
					if (checkAlien[xOfBomb - r][yOfBomb]) {
						profile.alienNumber--;   //one alien is died
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkEnding();   //check the condition of end of the game
					}
					checkAlien[xOfBomb - r][yOfBomb] = false;  //there isnt any alien in that button
				}
			}
			if (xOfBomb - r == bombermanX && yOfBomb == bombermanY) {
				heart = heart - 1;
				textField_2.setText(String.valueOf(heart));
				checkEnding();    //check the condition of end of the game
			}
			if (xOfBomb + r < profile.rows) {
				if (checkAlien[xOfBomb + r][yOfBomb]
						|| buttons.get(xOfBomb + r).get(yOfBomb).getBackground().equals(Color.orange)) {
					buttons.get(xOfBomb + r).get(yOfBomb).setBackground(Color.GREEN);
					buttons.get(xOfBomb + r).get(yOfBomb).setIcon(null);
					if (checkAlien[xOfBomb + r][yOfBomb]) {
						profile.alienNumber--;     //one alien is died
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkEnding();    //check the condition of end of the game
					}
					checkAlien[xOfBomb + r][yOfBomb] = false; //there isnt any alien in that button
				} else if (xOfBomb + r == bombermanX && yOfBomb == bombermanY) {
					heart = heart - 1;
					textField_2.setText(String.valueOf(heart));
					checkEnding();    //check the condition of end of the game
				}
			}
			if (yOfBomb + r < profile.columns) {
				if (checkAlien[xOfBomb][yOfBomb + r]
						|| buttons.get(xOfBomb).get(yOfBomb + r).getBackground().equals(Color.orange)) {
					buttons.get(xOfBomb).get(yOfBomb + r).setBackground(Color.GREEN);
					buttons.get(xOfBomb).get(yOfBomb + r).setIcon(null);
					if (checkAlien[xOfBomb][yOfBomb + r]) {
						profile.alienNumber--;     //one alien is died
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkEnding();   //check the condition of end of the game
					}
					checkAlien[xOfBomb][yOfBomb + r] = false;  //there isnt any alien in that button
				}

				else if (xOfBomb == bombermanX && yOfBomb + r == bombermanY) {
					heart = heart - 1;
					textField_2.setText(String.valueOf(heart));
					checkEnding();    //check the condition of end of the game
				}
			}
			if (yOfBomb - r >= 0) {
				if (checkAlien[xOfBomb][yOfBomb - r]
						|| buttons.get(xOfBomb).get(yOfBomb - r).getBackground().equals(Color.orange)) {
					buttons.get(xOfBomb).get(yOfBomb - r).setIcon(null);
					buttons.get(xOfBomb).get(yOfBomb - r).setBackground(Color.GREEN);
					if (checkAlien[xOfBomb][yOfBomb - r]) {
						profile.alienNumber--;     //one alien is died
						textField_1.setText(String.valueOf(profile.alienNumber));
						checkEnding();   //check the condition of end of the game
					}
					checkAlien[xOfBomb][yOfBomb - r] = false;    //there isnt any alien in that button
				} else if (xOfBomb == bombermanX && yOfBomb - r == bombermanY) {
					heart = heart - 1;
					textField_2.setText(String.valueOf(heart));
					checkEnding();    //check the condition of end of the game
				}
			}
			r--;  //Reduces the amount of radius
		}
	}
	//this method will set the bomb
	private static void setTheBOMb() {
		buttons.get(xOfBomb).get(yOfBomb).setBackground(Color.red);
		try { // set the default image to the new icon
			file = new File("./resource/5a357feb314172.5333863815134555952018.png");
			Image image1 = ImageIO.read(file);
			buttons.get(xOfBomb).get(yOfBomb)
					.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add the image to the lable
																											
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//this method will set the star in one button randomly
	private static void setTheHeart() {
		startHeart = seconds;		//the time of placing the heart in game
		while (true) {
			randheart1 = random.nextInt(profile.rows) + 0;
			randheart2 = random.nextInt(profile.columns) + 0;
			if (buttons.get(randheart1).get(randheart2).getBackground().equals(Color.GREEN)
					&& !checkAlien[randheart1][randheart2] && (randheart1 != bombermanX || randheart2 != bombermanY)) {
				buttons.get(randheart1).get(randheart2).setBackground(Color.BLACK);
				try { 						// set the default image to the new icon
					file = new File("./resource/Items/LifeHearth_Full.png");
					Image image1 = ImageIO.read(file);
					buttons.get(randheart1).get(randheart2)
							.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); // add theimage

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	// this method will check if the user get to the heart or not
	private static void findHeart(int x, int y) {
		if (x == randheart1 && y == randheart2) { // if it was
			heart = 10;
			textField_2.setText(String.valueOf(heart));
			buttons.get(x).get(y).setBackground(Color.GREEN);
			try { // set the default image to the new icon
				Image image1 = ImageIO.read(profile.file);
				buttons.get(bombermanX).get(bombermanY)
						.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); 
				//add the image	to the lable
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//this method will set the star in one button randomly
	private static void setTheStar() {
		startStar = seconds;  //the time of placing the star in game
		while (true) {
			randStar1 = random.nextInt(profile.rows) + 0;   //random for the place of the star
			randStar2 = random.nextInt(profile.columns) + 0;
			if (buttons.get(randStar1).get(randStar2).getBackground().equals(Color.GREEN)
					&& !checkAlien[randStar1][randStar2] && (randStar1 != bombermanX || randStar2 != bombermanY)) {
				buttons.get(randStar1).get(randStar2).setBackground(Color.BLUE);
				try { // set the default image to the new icon
					file = new File("./resource/Items/star.png");
					Image image1 = ImageIO.read(file); //make an object of image and set the image to button
					buttons.get(randStar1).get(randStar2)
							.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); //add the image 
																													
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	// this method will check if the user get to the star or not
	private static void findStar(int x, int y) {
		if (x == randStar1 && y == randStar2) { // if it was
			finishStar = seconds;
			radius = radius * 2; // the radius will become double
			buttons.get(x).get(y).setBackground(Color.GREEN); // set the color of the button Green
			try { // set the default image to the new icon
				Image image1 = ImageIO.read(profile.file);
				buttons.get(bombermanX).get(bombermanY)
						.setIcon(new ImageIcon(image1.getScaledInstance(length, Width, Image.SCALE_SMOOTH))); 
				//add the image to the lable
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void writer() {
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter("Record.txt", true)); // write in to the text
			output.write(WelcomePage.username + " " + WelcomePage.password + " " + file.getPath() + " "
					+ String.valueOf(WelcomePage.score));
			output.write("\r\n"); // go to the next line
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.flush();
					output.close(); // close the writer
				} catch (Exception e) {
				}
		}
	}
}
