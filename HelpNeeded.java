import java.awt.*;
import java.util.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class HelpNeeded {

	public JFrame frame;
	private JTextField textField;
	public static ListOfStats account = new ListOfStats();
	public static NameStats loggedInUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		createFile();
		loadStats();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpNeeded window = new HelpNeeded();
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
	public HelpNeeded() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1st Year in High School!!!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 0, 414, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>You are going to play as a freshman that will contain your name. You will need to guide your freshman through high school; "
				+ "help him or her make the right decisions.<html>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(90, 71, 250, 103);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(175, 196, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Your Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(113, 171, 208, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().isBlank())
					lblNewLabel_2.setText("Please Enter a Name.");
				else
				{
					String name = textField.getText();
					if(account.nameLocation(name) != -1)
					{
						loggedInUser = account.get(account.nameLocation(name));
					}
					else
					{
						account.add(new NameStats(name));
						loggedInUser = account.get(account.nameLocation(name));
					}
					
					frame.dispose();
					Levels levels = new Levels(name, loggedInUser, account);
					levels.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(175, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	public static void loadStats()
	{
		Scanner read;
		try
		{
			read = new Scanner(new File("accounts.txt"));
			while(read.hasNext())
			{
				String name = read.nextLine();
				read.nextInt();
				int complete = read.nextInt();
				read.nextLine();
				account.add(new NameStats(name, complete));
			}
			System.out.println(account);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static void createFile()
	{
		File file = new File("accounts.txt");
		try
		{
			if(file.createNewFile())
				System.out.println("Created");
			else
				System.out.println("Already exists");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
