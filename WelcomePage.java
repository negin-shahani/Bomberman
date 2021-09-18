package ir.ac.guilan.ce96.neginshahani.project7;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private static JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static Image image1;
	public static BufferedWriter output;
	public static int lines = 0;
	private static File file;
	public static String username;
	public static String password;
	private static int count = 1;
	public static WelcomePage frame;
	public static int score = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new WelcomePage(); // make a new frame for the welcome page
					frame.setVisible(true); // make it visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setType(Type.POPUP);
		setTitle("BomerMan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 418);
		contentPane = new JPanel(); // make a new panel and design it
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToThe = new JLabel("Welcome to the BomberMan !!!"); // make a new lable for title of page
		lblWelcomeToThe.setForeground(new Color(255, 255, 255));
		lblWelcomeToThe.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblWelcomeToThe.setBounds(222, 13, 347, 36);
		contentPane.add(lblWelcomeToThe); // add the lable to the panel

		JLabel label = new JLabel(""); // make a new lable for the image of the user
		label.setBackground(new Color(178, 34, 34));
		label.setForeground(new Color(178, 34, 34));
		label.setBounds(538, 62, 149, 172);
		contentPane.add(label); // add the lanble to the panel
		try { // set the default image to the new icon
			file = new File("./resource/Characters/Red_Front1.png");
			Image image1 = ImageIO.read(file);
			label.setIcon(new ImageIcon(image1)); // add the image to the labletime
		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton btnBrowseAPic = new JButton("Browse a pic"); // make a new button for choosing a new image
		btnBrowseAPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser(); // using filechooser to choose the picture
				int flag = chooser.showOpenDialog(null);
				if (flag == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile(); // get the file from filechooser
					try {
						Image image; // make an object of image
						image = ImageIO.read(file); // read the file
						image1 = image.getScaledInstance(180, 180, Image.SCALE_DEFAULT);
						label.setIcon(new ImageIcon(image1)); // set the image on a lable

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});
		btnBrowseAPic.setFont(new Font("Lucida Fax", Font.BOLD, 13)); // design the button
		btnBrowseAPic.setBackground(new Color(255, 255, 255));
		btnBrowseAPic.setForeground(new Color(128, 0, 0));
		btnBrowseAPic.setBounds(380, 93, 121, 25);
		contentPane.add(btnBrowseAPic);

		JRadioButton rdbtnOffline = new JRadioButton("Offline"); // make a new radiobuttonnamed offline
		rdbtnOffline.setForeground(new Color(128, 0, 0));
		rdbtnOffline.setBackground(new Color(255, 255, 255));
		rdbtnOffline.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		rdbtnOffline.setBounds(42, 280, 84, 25);
		contentPane.add(rdbtnOffline);
		rdbtnOffline.addActionListener(new ActionListener() { // if the user choose the offline part
			public void actionPerformed(ActionEvent arg0) {
				count = 1;
			}
		});

		JRadioButton rdbtnOnline = new JRadioButton("Online");// make a new radibutton named online
		rdbtnOnline.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		rdbtnOnline.setForeground(new Color(128, 0, 0));
		rdbtnOnline.setBackground(new Color(255, 255, 255));
		rdbtnOnline.setBounds(42, 317, 84, 25);
		contentPane.add(rdbtnOnline);
		rdbtnOnline.addActionListener(new ActionListener() { // if the user choose the online part
			public void actionPerformed(ActionEvent arg0) {
				count = 2;
			}
		});
		ButtonGroup bg = new ButtonGroup(); // make a buttongroup of online and offline button
		bg.add(rdbtnOffline); // in order to let the user to choose
		bg.add(rdbtnOnline);

		JButton btnNext = new JButton("next"); // make a new button in order to go to the next page(profile)
		btnNext.setBackground(Color.WHITE);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (count == 1) { // if the user choosed offline part
					profile.main(null); // open the page of the profile
					contentPane.setVisible(false);
					frame.setVisible(false); // close this page
				}
			}
		}); // design the button
		btnNext.setFont(new Font("Lucida Fax", Font.BOLD, 15));
		btnNext.setBounds(633, 333, 97, 25);
		contentPane.add(btnNext);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(23, 66, 311, 181);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Sign up"); // make a new button for signing up
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText("if it is your first time so press the sign up!");
				boolean flag1 = true;
				username = usernameGetter(); // get the name of the new user
				password = PasswordGetter(); // get the password of the new user
				try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) {
					String line;
					while ((line = br.readLine()) != null) { // read from the text
						String[] parts = line.split(" ");
						if (parts[0].equals(username)) {
							textField_2.setText("the username is Repetitious!");
							flag1 = false;
							break;
						}
					}
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (flag1) {
					try {
						output = new BufferedWriter(new FileWriter("Record.txt", true)); // write in to the text
						output.write(username + " " + password + " " + file.getPath() + " " + String.valueOf(score));
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
				textField_2.setText("your signed up Successfully");
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setToolTipText("if this is your first time so sign up plz!");
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(43, 128, 87, 25);
		panel.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(166, 49, 116, 22);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(166, 84, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblName = new JLabel("User Name :");
		lblName.setBounds(34, 56, 108, 16);
		panel.add(lblName);
		lblName.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblName.setForeground(Color.WHITE);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(34, 85, 96, 16);
		panel.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 17));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(178, 34, 34));
		textField_2.setBounds(12, 14, 287, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText("if it is your first time so press the sign up!");
		textField_2.setEditable(false); // set the ability of the textfield false
		JButton btnSignIn = new JButton("Sign in"); // make a new button for signing in
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = textField.getText(); // get the name of the old user
				password = textField_1.getText();// get the password of the old user
				boolean flag = false;
				try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) {
					String line;
					while ((line = br.readLine()) != null) { // read from the text
						String[] parts = line.split(" "); // split the line by space
						if (parts[0].equals(username) && parts[1].equals(password)) { // if the user enter the right
																						// information
							flag = true;
							textField_2.setText("the user exists!");
							break;
						}
					}
					if (!flag) // if there wasnt any user with this information
						textField_2.setText("there isnt! plz choose the sign up button!");
					br.close(); // close the BufferedReader
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSignIn.setBackground(Color.WHITE); // design the button
		btnSignIn.setForeground(new Color(128, 0, 0));
		btnSignIn.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		btnSignIn.setBounds(153, 128, 97, 25);
		panel.add(btnSignIn);

	}

	private String usernameGetter() { // get the user name of the user
		return JOptionPane.showInputDialog(this, "enter your name plz !:", "user name Selection",
				JOptionPane.PLAIN_MESSAGE);
	}

	private String PasswordGetter() { // get the password of the user
		return JOptionPane.showInputDialog(this, "enter your password plz !:", "password Selection",
				JOptionPane.PLAIN_MESSAGE);
	}
}
