import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class Levels extends JFrame {

	private JPanel contentPane;
	private JButton btnLvl1;
	private JButton btnLvl2;
	private JButton btnLvl3;
	private JButton btnLvl4;
	private JButton btnLvl5;
	private JButton btnLvl6;
	private JButton btnLvl7;
	private JButton btnLvl8;
	private JButton btnLvl9;
	private JButton btnLvl10;
	private JButton btnLvl11;
	private JButton btnLvl12;
	private JButton btnLvl13;
	private JButton btnLvl14;
	private JButton btnLvl15;
	private JButton btnLvl16;
	public String name;
	public NameStats user;
	public ListOfStats account;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public Levels(String name, NameStats loggedIn, ListOfStats list) {
		account = list;
		user = loggedIn;
		saveStats();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setVerticalAlignment(SwingConstants.TOP);
		nameLabel.setBounds(0, 0, 55, 28);
		contentPane.add(nameLabel);
		nameLabel.setText(name);
		
		btnLvl1 = new JButton("Level 1");
		btnLvl1.setBackground(Color.YELLOW);
		btnLvl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(1, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl1.setBounds(0, 39, 89, 23);
		contentPane.add(btnLvl1);
		
		btnLvl2 = new JButton("Level 2");
		btnLvl2.setBackground(Color.YELLOW);
		btnLvl2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(2, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl2.setBounds(113, 39, 89, 23);
		contentPane.add(btnLvl2);
		btnLvl2.setVisible(false);
		
		btnLvl3 = new JButton("Level 3");
		btnLvl3.setBackground(Color.YELLOW);
		btnLvl3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(3, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl3.setBounds(229, 39, 89, 23);
		contentPane.add(btnLvl3);
		btnLvl3.setVisible(false);
		
		btnLvl4 = new JButton("Level 4");
		btnLvl4.setBackground(Color.YELLOW);
		btnLvl4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(4, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl4.setBounds(345, 39, 89, 23);
		contentPane.add(btnLvl4);
		btnLvl4.setVisible(false);
		
		btnLvl5 = new JButton("Level 5");
		btnLvl5.setBackground(Color.YELLOW);
		btnLvl5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(5, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl5.setBounds(0, 85, 89, 23);
		contentPane.add(btnLvl5);
		btnLvl5.setVisible(false);
		
		btnLvl6 = new JButton("Level 6");
		btnLvl6.setBackground(Color.YELLOW);
		btnLvl6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(6, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl6.setBounds(113, 85, 89, 23);
		contentPane.add(btnLvl6);
		btnLvl6.setVisible(false);
		
		btnLvl7 = new JButton("Level 7");
		btnLvl7.setBackground(Color.YELLOW);
		btnLvl7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(7, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl7.setBounds(229, 85, 89, 23);
		contentPane.add(btnLvl7);
		btnLvl7.setVisible(false);
		
		btnLvl8 = new JButton("Level 8");
		btnLvl8.setBackground(Color.YELLOW);
		btnLvl8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(8, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl8.setBounds(345, 85, 89, 23);
		contentPane.add(btnLvl8);
		btnLvl8.setVisible(false);
		
		btnLvl9 = new JButton("Level 9");
		btnLvl9.setBackground(Color.YELLOW);
		btnLvl9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(9, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl9.setBounds(0, 130, 89, 23);
		contentPane.add(btnLvl9);
		btnLvl9.setVisible(false);
		
		btnLvl10 = new JButton("Level 10");
		btnLvl10.setBackground(Color.YELLOW);
		btnLvl10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(10, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl10.setBounds(113, 130, 89, 23);
		contentPane.add(btnLvl10);
		btnLvl10.setVisible(false);
		
		btnLvl11 = new JButton("Level 11");
		btnLvl11.setBackground(Color.YELLOW);
		btnLvl11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(11, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl11.setBounds(229, 130, 89, 23);
		contentPane.add(btnLvl11);
		btnLvl11.setVisible(false);
		
		btnLvl12 = new JButton("Level 12");
		btnLvl12.setBackground(Color.YELLOW);
		btnLvl12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(12, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl12.setBounds(345, 130, 89, 23);
		contentPane.add(btnLvl12);
		btnLvl12.setVisible(false);
		
		btnLvl13 = new JButton("Level 13");
		btnLvl13.setBackground(Color.YELLOW);
		btnLvl13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(13, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl13.setBounds(0, 177, 89, 23);
		contentPane.add(btnLvl13);
		btnLvl13.setVisible(false);
		
		btnLvl14 = new JButton("Level 14");
		btnLvl14.setBackground(Color.YELLOW);
		btnLvl14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(14, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl14.setBounds(113, 177, 89, 23);
		contentPane.add(btnLvl14);
		btnLvl14.setVisible(false);
		
		btnLvl15 = new JButton("Level 15");
		btnLvl15.setBackground(Color.YELLOW);
		btnLvl15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(15, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl15.setBounds(229, 177, 89, 23);
		contentPane.add(btnLvl15);
		btnLvl15.setVisible(false);
		
		btnLvl16 = new JButton("Level 16");
		btnLvl16.setBackground(Color.YELLOW);
		btnLvl16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description scenario = new Description(16, user, account);
				scenario.setVisible(true);
			}
		});
		btnLvl16.setBounds(345, 177, 89, 23);
		contentPane.add(btnLvl16);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.MAGENTA);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.reset();
				dispose();
				Levels reset = new Levels(name, user, account);
				reset.setVisible(true);
			}
		});
		btnReset.setBounds(0, 227, 202, 23);
		contentPane.add(btnReset);
		
		JButton btnEnd = new JButton("Leave Game");
		btnEnd.setBackground(Color.PINK);
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HelpNeeded back = new HelpNeeded();
				back.frame.setVisible(true);
			}
		});
		btnEnd.setBounds(229, 227, 205, 23);
		contentPane.add(btnEnd);
		
		lblNewLabel = new JLabel("<html>You completed all the levels and helped your character(yourself) make it through the 1st year of high school!<html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(65, 0, 369, 38);
		contentPane.add(lblNewLabel);
		btnLvl16.setVisible(false);
		lblNewLabel.setVisible(false);
		initializeMap(user.complete());
	}
	
	public void initializeMap(int levelsCompleted)
	{
		switch(levelsCompleted)
		{
			case 16:
				lblNewLabel.setVisible(true);
			case 15:
				btnLvl16.setVisible(true);
			case 14:
				btnLvl15.setVisible(true);
			case 13:
				btnLvl14.setVisible(true);
			case 12:
				btnLvl13.setVisible(true);
			case 11:
				btnLvl12.setVisible(true);
			case 10:
				btnLvl11.setVisible(true);
			case 9:
				btnLvl10.setVisible(true);
			case 8:
				btnLvl9.setVisible(true);
			case 7:
				btnLvl8.setVisible(true);
			case 6:
				btnLvl7.setVisible(true);
			case 5:
				btnLvl6.setVisible(true);
			case 4:
				btnLvl5.setVisible(true);
			case 3:
				btnLvl4.setVisible(true);
			case 2:
				btnLvl3.setVisible(true);
			case 1:
				btnLvl2.setVisible(true);
			default:
				btnLvl1.setVisible(true);
		}
	}
	
	public void saveStats()
	{
		try
		{
			PrintWriter accounts = new PrintWriter(new File("accounts.txt"));
			accounts.print(account.saveToFile());
			accounts.close();
		} 
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

}
