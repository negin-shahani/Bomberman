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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;

public class LosePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LosePage frame = new LosePage(); //make a new frame for the page
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
	public LosePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over!!!");		//make a new lable named "Game Over!!!"
		lblGameOver.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setBounds(147, 13, 199, 40);
		contentPane.add(lblGameOver);
		
		JLabel lblYourScoreIs = new JLabel("Your score is :");  //make a new lable named "Your score is :"
		lblYourScoreIs.setForeground(Color.WHITE);
		lblYourScoreIs.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblYourScoreIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourScoreIs.setBounds(77, 66, 174, 40);
		contentPane.add(lblYourScoreIs);
		
		textField = new JTextField();		//make a new lable for setting the score
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		textField.setBounds(263, 73, 126, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(BomberManPage.record));
		textField.setEditable(false);
		
		label =  new JLabel("");						//make a new lable for seting the pic
		label.setBounds(113, 119, 276, 203);
		contentPane.add(label);
		File file1 = new File("./resource/33-1.png");            //read the image from file and show it in lable
		try {
			BufferedImage image = ImageIO.read(file1);
			Image image1 = image.getScaledInstance(250,250, Image.SCALE_DEFAULT);
			label.setIcon(new ImageIcon(image1));    //set the pic
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
