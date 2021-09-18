package ir.ac.guilan.ce96.neginshahani.project7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;

public class WinPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinPage frame = new WinPage();     //make a new frame for this page
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
	public WinPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 512);
		contentPane = new JPanel();          //make a new panel
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCongra = DefaultComponentFactory.getInstance().createTitle("congratulation!!!");
		lblCongra.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblCongra.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongra.setForeground(Color.WHITE);
		lblCongra.setBounds(122, 13, 250, 42);
		contentPane.add(lblCongra);
		
		JLabel lblYouWonThe = new JLabel("You won the game!!!!");  //make a new lable named "You won the game!!!!"
		lblYouWonThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWonThe.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblYouWonThe.setForeground(Color.WHITE);
		lblYouWonThe.setBounds(110, 68, 278, 42);
		contentPane.add(lblYouWonThe);
		
		JLabel lblScore = new JLabel("your score is :");  //make a new lable named "your score is :"
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(80, 138, 197, 27);
		contentPane.add(lblScore);
		
		textField = new JTextField();     //make a new textfield for seting the score of the user
		textField.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(268, 137, 158, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(BomberManPage.record));
		textField.setEditable(false);
		
		JLabel label = new JLabel("");            //make a new lable for seting the pic
		label.setBounds(131, 195, 295, 220);
		contentPane.add(label);
		File file1 = new File("./resource/30-1.png");            //read the image from file and show it in lable
		try {
			BufferedImage image = ImageIO.read(file1);
			Image image1 = image.getScaledInstance(250,250, Image.SCALE_DEFAULT);
			label.setIcon(new ImageIcon(image1));   //set the image
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
