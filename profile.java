package ir.ac.guilan.ce96.neginshahani.project7;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class profile extends JFrame {

	private JPanel contentPane;
	private JTextField txtYouCanEdit;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtYouCanSee;
	private JTextField txtYouCanSee_1;
	static Image image1;
	public static File file;
	private static BufferedWriter output;
	public static int userCount = 1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtFillInThe;
	public static int alienNumber;
	public static int rows;
	public static int columns;
	public static profile frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new profile(); // make a new frame for this page
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public profile() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 653);
		contentPane = new JPanel(); // make a new panel for the page
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel(); // make another panel with different design
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(12, 13, 595, 236);
		contentPane.add(panel);
		panel.setLayout(null);

		txtYouCanEdit = new JTextField(); // make a new textfield
		txtYouCanEdit.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		txtYouCanEdit.setForeground(Color.WHITE);
		txtYouCanEdit.setText("You can edit your profile here!!!");
		txtYouCanEdit.setBackground(new Color(178, 34, 34));
		txtYouCanEdit.setBounds(12, 13, 279, 29);
		panel.add(txtYouCanEdit);
		txtYouCanEdit.setColumns(10);
		txtYouCanEdit.setEditable(false);

		JLabel lblUserName = new JLabel("User name :"); // make a new lable named "User name :"
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblUserName.setBounds(12, 75, 110, 20);
		panel.add(lblUserName);

		textField = new JTextField(); // make a new textfield for user to write the name
		textField.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		textField.setBounds(142, 75, 133, 22);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(WelcomePage.username);

		JLabel lblPassword = new JLabel("Password :");// make a new lable named "Password :"
		lblPassword.setFont(new Font("Lucida Fax", Font.BOLD, 17));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(12, 115, 110, 20);
		panel.add(lblPassword);

		textField_1 = new JTextField(); // make a new textfield for user t write the password
		textField_1.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		textField_1.setBounds(142, 116, 133, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(WelcomePage.password);

		JLabel label = new JLabel(""); // make a new lable for image
		label.setBounds(434, 41, 150, 124);
		panel.add(label);

		try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) {
			String line;
			while ((line = br.readLine()) != null) { // read from the lines of the text
				userCount++;
				String[] parts = line.split(" "); // split each line to space
				if (parts[0].equals(WelcomePage.username)) {
					try { // set the default image to the new icon
						file = new File(parts[2]);
						Image image1 = ImageIO.read(file);
						image1 = image1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
						label.setIcon(new ImageIcon(image1)); // add the image to the labletime
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			br.close(); // close the bufferedReader
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnNewPic = new JButton("New pic"); // make a new button for user to choose a new pic
		btnNewPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser(); // using filechooser to choose the picture
				int flag = chooser.showOpenDialog(null);
				if (flag == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile(); // get the file from filechooser
					try {
						Image image; // make a new object of image
						image = ImageIO.read(file); // read the file
						image1 = image.getScaledInstance(120, 120, Image.SCALE_DEFAULT);
						label.setIcon(new ImageIcon(image1)); // set the image in a lable
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnNewPic.setFont(new Font("Lucida Fax", Font.BOLD, 13)); // design the button
		btnNewPic.setBackground(Color.WHITE);
		btnNewPic.setForeground(new Color(139, 0, 0));
		btnNewPic.setBounds(325, 74, 97, 25);
		panel.add(btnNewPic);

		JButton btnSaveTheChanges = new JButton("Save the changes"); // ma;e a new button for saving the changes that
																		// user made
		btnSaveTheChanges.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String newPro = textField.getText() + " " + textField_1.getText() + " " + file.getPath() +" "+ "0"; // the new information
				String news[] = new String[10];
				int x = 0;
				try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) {
					String line;
					while ((line = br.readLine()) != null) { // read from the text
						String[] parts = line.split(" "); // split the line into the space
						if (parts[0].equals(WelcomePage.username)) { // if we found the user so we replace the new information with old one
							news[x] = newPro;
							x++;
						} else { // if the user was not so just pack up the old information
							news[x] = line;
							x++;
						}
					}
					br.close(); // close the bufferedReader
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					output = new BufferedWriter(new FileWriter("Record.txt", false)); // write in to the text
					String answer ="";
					for (int i = 0; i < x; i++) {
						answer += news[i];
						answer +="\r\n";     //go to hte next line
						System.out.println(answer);
						output.write(answer); // write one line of the text
					}
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
				WelcomePage.username = textField.getText(); // get the new information of user
				WelcomePage.password = textField_1.getText();
			}
		});
		btnSaveTheChanges.setBackground(Color.WHITE); // design the button
		btnSaveTheChanges.setForeground(new Color(139, 0, 0));
		btnSaveTheChanges.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		btnSaveTheChanges.setBounds(12, 178, 162, 25);
		panel.add(btnSaveTheChanges);

		JPanel panel_1 = new JPanel(); // make a new panel
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(12, 262, 302, 194);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtYouCanSee = new JTextField(); // make a new textfield to show the message
		txtYouCanSee.setBackground(new Color(178, 34, 34));
		txtYouCanSee.setForeground(Color.WHITE);
		txtYouCanSee.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		txtYouCanSee.setText("You can see your records here!!");
		txtYouCanSee.setBounds(12, 13, 273, 34);
		panel_1.add(txtYouCanSee);
		txtYouCanSee.setColumns(10);
		txtYouCanSee.setEditable(false); // and set it uneditable

		JTextArea textArea = new JTextArea(); // make a new textarea for showing the scores of the user
		textArea.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(139, 0, 0));
		textArea.setBounds(12, 60, 273, 122);
		panel_1.add(textArea);
		try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) { // read the text
			String line, show = "";
			while ((line = br.readLine()) != null) { // read each line from the text
				userCount++;
				String[] parts = line.split(" "); // split the line into the space
				if (parts[0].equals(WelcomePage.username)) {
					show += parts[3]; // set the scores to the textarea
					show += "\n";
					textArea.setText(show);
				}
			}
			br.close(); // close the BufferedReader
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panel_2 = new JPanel(); // make another panel
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(326, 262, 281, 194);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtYouCanSee_1 = new JTextField(); // make a new textfield for showing the massage
		txtYouCanSee_1.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		txtYouCanSee_1.setForeground(Color.WHITE);
		txtYouCanSee_1.setText("You can see the best records here!!");
		txtYouCanSee_1.setBackground(new Color(178, 34, 34));
		txtYouCanSee_1.setBounds(12, 13, 257, 33);
		panel_2.add(txtYouCanSee_1);
		txtYouCanSee_1.setColumns(10);

		JTextArea textArea_1 = new JTextArea(); // make a new textarea for showing the best scores
		textArea_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBackground(new Color(139, 0, 0));
		textArea_1.setBounds(12, 59, 257, 118);
		panel_2.add(textArea_1);
		try (BufferedReader br = new BufferedReader(new FileReader("Record.txt"))) { // read the text
			String line;
			int y = 0;
			String userRecords[] = new String[userCount]; // an array for the reconds of the users
			int records[] = new int[userCount]; // an array for the names of the users
			while ((line = br.readLine()) != null) { // read each line from the text
				String[] parts = line.split(" "); // split it to the space
					records[y] = Integer.valueOf(parts[3]);
				userRecords[y] = parts[0];
				y++;
			}
			br.close();
			int max = records[0];
			int i, j = 0;
			for (i = 1; i < userCount; i++) { // then find the maximum of the scores
				if (max < records[i]) {
					max = records[i];
					j = i;
				}
			} // set the best user and the records in the textarea
			textArea_1.setText(userRecords[j] + "  >>>>  " + String.valueOf(records[j]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panel_3 = new JPanel(); // make another panel
		panel_3.setBackground(new Color(178, 34, 34));
		panel_3.setBounds(12, 469, 595, 122);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNumberOfAlien = new JLabel("Alien num :"); // make a new lable named "Alien num :"
		lblNumberOfAlien.setForeground(Color.WHITE);
		lblNumberOfAlien.setBackground(Color.WHITE);
		lblNumberOfAlien.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblNumberOfAlien.setBounds(12, 23, 102, 16);
		panel_3.add(lblNumberOfAlien);

		textField_2 = new JTextField(); // make a new textfield for getting the number of the aliens
		textField_2.setBounds(147, 21, 116, 22);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblRowsNum = new JLabel("Rows num :"); // make a new lable named "Rows num :"
		lblRowsNum.setForeground(Color.WHITE);
		lblRowsNum.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblRowsNum.setBounds(12, 52, 102, 16);
		panel_3.add(lblRowsNum);

		textField_3 = new JTextField(); // make a new textfield for getting the number of rows
		textField_3.setBounds(147, 50, 116, 22);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblColumnNum = new JLabel("Column num:");// make a new lable named "Column num:"
		lblColumnNum.setForeground(Color.WHITE);
		lblColumnNum.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblColumnNum.setBounds(12, 81, 116, 16);
		panel_3.add(lblColumnNum);

		textField_4 = new JTextField(); // make a new textfield for getting the number of columns
		textField_4.setBounds(147, 79, 116, 22);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		txtFillInThe = new JTextField(); // make a new textfield for showing the massage
		txtFillInThe.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		txtFillInThe.setText("Fill in the boxes and start the game :)");
		txtFillInThe.setForeground(Color.WHITE);
		txtFillInThe.setBackground(new Color(178, 34, 34));
		txtFillInThe.setBounds(314, 17, 269, 22);
		panel_3.add(txtFillInThe);
		txtFillInThe.setColumns(10);
		txtFillInThe.setEditable(false); // set the textfield uneditable

		// this button is for user to start the game
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alienNumber = Integer.valueOf(textField_2.getText()); // get the number of aliens
				rows = Integer.valueOf(textField_3.getText()); // get the num of rows
				columns = Integer.valueOf(textField_4.getText()); // get the num of columns

				BomberManPage.seconds = 0; // initializing
				BomberManPage.heart = 10;
				BomberManPage.length = 1900 / rows;
				BomberManPage.Width = 800 / columns;
				BomberManPage.aliennum = 0;
				BomberManPage.radius = 1;
				BomberManPage.startBomb = 1000000000;
				BomberManPage.startHeart = 1000000000;
				BomberManPage.startStar = 1000000000;
				BomberManPage.finishStar = 1000000000;
				BomberManPage.bombs = 0;
				BomberManPage.seconds = 0;
				BomberManPage.main(null); // open the page of the game
				contentPane.setVisible(false); // close the page of profile
				frame.setVisible(false); // close the page of profile
			}
		}); // design the button
		btnPlay.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnPlay.setForeground(new Color(178, 34, 34));
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(486, 72, 97, 25);
		panel_3.add(btnPlay);
	}
}
