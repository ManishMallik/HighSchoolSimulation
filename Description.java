import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Description extends JFrame {

	private JLabel lblDescription;
	private JPanel contentPane;
	private JButton btnChoice1;
	private JButton btnChoice2;
	private JButton btnChoice3;
	private JButton btnChoice4;
	private JButton btnNextOrTryAgain;
	private JButton btnGoBack;
	private JButton btnBackButton;
	private JLabel lblFail;
	private JLabel lblSuccess;
	private String scenario;
	private int levelNum;
	private ListOfStats account;
	private boolean successful;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Description frame = new Description();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public Description(int level, NameStats user, ListOfStats list) {
		account = list;
		levelNum = level;
		scenario = nextLevels(levelNum);
		successful = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDescription = new JLabel(scenario);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setBounds(0, 11, 374, 98);
		contentPane.add(lblDescription);
		
		btnChoice1 = new JButton("<dynamic>");
		btnChoice1.setBackground(Color.CYAN);
		btnChoice1.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswerChoice1(levelNum);
				setFailOrSuccess();
				if(successful)
					if(levelNum == user.complete() + 1 && user.complete() < 16)
						user.levelSuccess();
				saveStats();
			}
		});
		btnChoice1.setBounds(10, 111, 217, 67);
		contentPane.add(btnChoice1);
		
		btnChoice2 = new JButton("<dynamic>");
		btnChoice2.setBackground(Color.CYAN);
		btnChoice2.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswerChoice2(levelNum);
				setFailOrSuccess();
				if(successful)
					if(levelNum == user.complete() + 1 && user.complete() < 16)
						user.levelSuccess();
				saveStats();
			}
		});
		btnChoice2.setBounds(226, 111, 198, 67);
		contentPane.add(btnChoice2);
		
		btnChoice3 = new JButton("<dynamic>");
		btnChoice3.setBackground(Color.CYAN);
		btnChoice3.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnChoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswerChoice3(levelNum);
				setFailOrSuccess();
				if(successful)
					if(levelNum == user.complete() + 1 && user.complete() < 16)
						user.levelSuccess();
				saveStats();
			}
		});
		btnChoice3.setBounds(10, 178, 217, 72);
		contentPane.add(btnChoice3);
		
		btnChoice4 = new JButton("<dynamic>");
		btnChoice4.setBackground(Color.CYAN);
		btnChoice4.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnChoice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswerChoice4(levelNum);
				setFailOrSuccess();
				if(successful)
					if(levelNum == user.complete() + 1 && user.complete() < 16)
						user.levelSuccess();
				saveStats();
			}
		});
		btnChoice4.setBounds(226, 178, 198, 72);
		contentPane.add(btnChoice4);
		
		btnNextOrTryAgain = new JButton("<dynamic>");
		btnNextOrTryAgain.setBackground(Color.GREEN);
		btnNextOrTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Description screen;
				if(successful)
						levelNum++;
				screen = new Description(levelNum, user, account);
				screen.setVisible(true);
			}
		});
		btnNextOrTryAgain.setBounds(72, 133, 89, 23);
		contentPane.add(btnNextOrTryAgain);
		
		btnGoBack = new JButton("Menu");
		btnGoBack.setBackground(Color.RED);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Levels levelScreen = new Levels(user.name(), user, account);
				levelScreen.setVisible(true);
			}
		});
		btnGoBack.setBounds(285, 133, 89, 23);
		contentPane.add(btnGoBack);
		
		btnBackButton = new JButton("<html>Main Menu<html>");
		btnBackButton.setBackground(Color.CYAN);
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveStats();
				dispose();
				Levels levelScreen = new Levels(user.name(), user, account);
				levelScreen.setVisible(true);
			}
		});
		btnBackButton.setBounds(378, 0, 56, 51);
		contentPane.add(btnBackButton);
		
		lblSuccess = new JLabel("SUCCESS!!!");
		lblSuccess.setForeground(Color.BLUE);
		lblSuccess.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setBounds(10, 113, 414, 137);
		contentPane.add(lblSuccess);
		
		lblFail = new JLabel("FAIL!!!");
		lblFail.setHorizontalAlignment(SwingConstants.CENTER);
		lblFail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFail.setForeground(Color.RED);
		lblFail.setBounds(10, 112, 414, 138);
		lblSuccess.setVisible(false);
		lblFail.setVisible(false);
		contentPane.add(lblFail);
		btnNextOrTryAgain.setVisible(false);
		btnGoBack.setVisible(false);
		levelChoices(levelNum);
	}
	
	public void setFailOrSuccess()
	{
		if(successful)
			lblSuccess.setVisible(true);
		else
			lblFail.setVisible(true);
	}
	
	public void levelChoices(int level)
	{
		switch(level)
		{
			case 1:
				btnChoice1.setText("<html>Play videogames throughout the night<html>");
				btnChoice2.setText("Go to bed early");
				btnChoice3.setText("<html>Pack up your backpack and binder with notebooks, pencils, gluesticks, papers, etc.<html>");
				btnChoice4.setText("<html>Study some material in advance.<html>");
				break;
			case 2:
				btnChoice1.setText("<html>Attend the club and listen attentively. Do the homework at home.<html>");
				btnChoice2.setText("<html>Choose not to go and do not tell.<html>");
				btnChoice3.setText("<html>Tell the president of your club to delay it.<html>");
				btnChoice4.setText("<html>Attend the club meeting but do your homework during the meeting.<html>");
				break;
			case 3:
				btnChoice1.setText("<html>I got homework, so I cannot come.<html>");
				btnChoice2.setText("<html>Sure, I want to party. I'll come.<html>");
				btnChoice3.setText("<html>I would rather not come. I am not in the mood.<html>");
				btnChoice4.setText("<html>I would love to come, but I have a family emergency.<html>");
				break;
			case 4:
				btnChoice1.setText("<html>Continue doing your work. Work all the way through.<html>");
				btnChoice2.setText("<html>Take a 30 minute power nap, then continue your homework.<html>");
				btnChoice3.setText("<html>Play or watch for 30 minutes, then continue your homework.<html>");
				btnChoice4.setText("<html>Go to bed and plan on doing the remaining homework by missing tennis practice.<html>");
				break;
			case 5:
				btnChoice1.setText("<html>Do your other homework, then come back to the problem and call a friend if you can't "
						+ "solve it.<html>");
				btnChoice2.setText("<html>Keep on trying to solve it, and if you cannot figure it out, call a friend.<html>");
				btnChoice3.setText("<html>Rage for not being able to solve it and do not leave your chair until you solve the "
						+ "problem by yourself<html>.");
				btnChoice4.setText("<html>Choose not to do the problem until tomorrow to get help from a classmate before"
						+ " turning in the homework.<html>");
				break;
			case 6:
				btnChoice1.setText("Wednesday");
				btnChoice2.setText("Saturday");
				btnChoice3.setText("Friday");
				btnChoice4.setText("Sunday");
				break;
			case 7:
				btnChoice1.setText("<html>Grind hard. Do all of your homework and study for the tests hard before going to bed."
						+ "<html>");
				btnChoice2.setText("<html>Do your homework first, then study for the test that is before your lunchtime. "
						+ "Study for the other test in less than 1 hour and go to bed no later than 12 am. Study the rest in"
						+ " lunch.<html>");
				btnChoice3.setText("<html>Do the homework for classes before school lunch first and half of the other homework, and study 2-3 hours"
						+ " for tests. Next day, finish the rest of the homework and study for your test(if time permits) during lunch.<html>");
				btnChoice4.setText("<html>Study for both the tests first for two hours and then do your homework and study for "
						+ "the tests more based on if time permits.<html>");
				break;
			case 8:
				btnChoice1.setText("<html>Start studying from Sunday on the week of your finals.<html>");
				btnChoice2.setText("<html>Study your material with one friend or yourself "
						+ "for a week before the week of the final exams. Also study during the finals week whenever you are at home.<html>");
				btnChoice3.setText("<html>Just chill and do not worry much about it.<html>");
				btnChoice4.setText("<html>Study with a group of friends on the week before finals.<html>");
				break;
			case 9:
				btnChoice1.setText("<html>Do nothing about it.<html>");
				btnChoice2.setText("<html>Report to the principal about this.<html>");
				btnChoice3.setText("<html>Fight against the bullies with your might.<html>");
				btnChoice4.setText("<html>Take some hits from the bullies. Only fight them back to defend yourself.<html>");
				break;
			case 10:
				btnChoice1.setText("<html>Do all of their work by yourself.<html>");
				btnChoice2.setText("<html>Consult with them. Tell them that you all should call or meet up and get the project "
						+ "done. You can help a little bit with their parts, but make sure they are doing the work.<html>");
				btnChoice3.setText("<html>Do not tell them about this. Expect them to do their work.<html>");
				btnChoice4.setText("<html>Report to your teacher about them doing nothing contributive.<html>");
				break;
			case 11:
				btnChoice1.setText("<html>Do all of your work and test preparations on Friday, Saturday, and Sunday until"
						+ " the Super Bowl starts. Host a Super Bowl party and invite your friends for the Super Bowl.<html>");
				btnChoice2.setText("<html>Party over the weekends as you usually do. Also host a Super Bowl party. Do the "
						+ "work only when you feel like it.<html>");
				btnChoice3.setText("<html>Just work on your assignments and study for school tests. You will not have time "
						+ "to watch the Super Bowl, but you can play some videogames in your breaks.<html>");
				btnChoice4.setText("<html>Alternate between schoolwork and taking breaks. Watch the Super Bowl as well"
						+ ", during your own time. Do not host a party<html>");
				break;
			case 12:
				btnChoice1.setText("<html>Teach your friend the math concepts that he has trouble with. Also correctly guide him "
						+ "through the questions, but do not explicitly state the answer.<html>");
				btnChoice2.setText("<html>Send him all of the answers right away so that you can do your other homework fast.<html>");
				btnChoice3.setText("<html>Refuse to help him. Do not give away any of the answers.<html>");
				btnChoice4.setText("<html>Since you have tennis tomorrow morning , place the answer sheet in front of the door "
						+ "of the locker room and have him pick it up.<html>");
				break;
			case 13:
				btnChoice1.setText("<html>Text one of your friends to get the assignments of every class that you have " 
						+ "and give it to you after school ends.<html>");
				btnChoice2.setText("<html>Go to school tomorrow so that you can get the assignments and understand the "
						+ "material needed to complete the assignments.<html>");
				btnChoice3.setText("<html>Get the assignments tomorrow or the day when you feel much better.<html>");
				btnChoice4.setText("<html>Email your teachers. Ask them to send the material and assignments to you so that "
						+ "you can understand and work on assignments.<html>");
				break;
			case 14:
				btnChoice1.setText("<html>Continue hanging out with your friends every weekend. Continue your daily school life:"
						+ " working and finishing your assignments. Study for AP exams on a week before their dates.<html>");
				btnChoice2.setText("<html>Hang out with your friends, but try to study for AP exams with them to be more "
						+ "prepared and confident. On every weekday, study for the AP exams 1st and do the assignments later.<html>");
				btnChoice3.setText("<html>Do not hang out with friends. Every weekend, study hard for "
						+ "the AP exams. Every school day, finish your assignments and study for AP exams. On the final week, "
						+ "study more on AP exams during school days.<html>");
				btnChoice4.setText("<html>Do not hang out with friends. You can take your own breaks and limit your time on "
						+ "them. Study for your AP exams every day after school, and do your assignments less. Work on your "
						+ "assignments before school and during lunch.<html>");
				break;
			case 15:
				btnChoice1.setText("<html>Play videogames with your friends.<html>");
				btnChoice2.setText("<html>Play some sports, such as football, tennis, or frisbee,"
						+ " with your friends outside.<html>");
				btnChoice3.setText("<html>Go to a party that one of your friends has invited you to.<html>");
				btnChoice4.setText("<html>Go to a party that your parents want you to go to.<html>");
				break;
			case 16:
				btnChoice1.setText("<html>Cram hard, day and night, for your final exams. Take notes, watch videos on certain"
						+ " topics, and memorize a lot of information.<html>");
				btnChoice2.setText("<html>Continue your daily life. Just chill, and study for final exams every day but not too "
						+ "hard. Take some breaks whenever needed. The classes give you reviews anyways, so just look at the "
						+ "content and know as much as you can.<html>");
				btnChoice3.setText("<html>Search up for online reviews or practice questions for your classes to help "
						+ "you prepare for finals. Ask a friend to give you online reviews if needed. If you cannot find some "
						+ "reviews, review your notes or use your school reviews.<html>");
				btnChoice4.setText("<html>Study for the final exams by reviewing or taking notes. Study for your earlier exams "
						+ "more. Also, for tomorrow, study during the 1st period exam since you do not have to do anything for "
						+ "tennis. Every day after school, review for finals with one friend.<html>");
				break;
		}
	}
	
	public void checkAnswerChoice1(int level)
	{
		setButtons();
		switch(level)
		{
			case 2:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>The president of the robotics club was pleased to see you attend the first meeting. "
						+ "He has decided to make you a leader of the software team since you have experience and "
						+ "were dedicated and attentive.<html>");
				break;
			case 5:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>You finished all of your other homework. Once you got back to the question on the English homework, you decide to call a friend"
						+ " after still not figuring it out, and she helps you figure out what the answer is.<html>");
				break;
			case 11:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>Finishing all of your homework and assignments was sure stressful, but it was worth it. You get the time to watch the Super "
						+ "Bowl, and you invited your friends over for a Super Bowl party. All of you had so much fun watching the Super Bowl.<html>");
				break;
			case 12:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>Teaching and guiding your friend in the math homework led to your friend getting a 100 on the homework without being suspected "
						+ "by your math teacher of you two having the same answers. Teaching also helped your friend know the concepts better, so you do not get asked much "
						+ "from him about math.<html>");
				break;
			default:
				btnNextOrTryAgain.setText("Try Again");
				successful = false;
				wrongAnswer1(level);
		}
	}
	
	public void checkAnswerChoice2(int level)
	{
		setButtons();
		switch(level)
		{
			case 4:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>The 30 minute power nap made you feel refreshing. Your brain got powered, allowing you to finish your homework with no problem.<html>");
				break;
			case 8:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>If you studied alone, you were able to take and review your notes clearly, which prepared you well and helped you exceed your"
						+ " final exams. If you did it with a friend, you and your friend helped out each other in certain subjects and stayed on task.<html>");
				break;
			case 10:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>It is annoying that your group members did no work whatsoever. Since you were able to convince them to do work by saying that "
						+ "you would help them or tell the teacher, they were able to get their parts done over 2 days, making your project finally complete and ready on time.<html>");
				break;
			case 15:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>A few of your friends did not come to play sports with you and other friends, but it was worth it. You felt fresh and got "
						+ "healthier. All of you had fun together. All of you also felt less stressed.<html>");
				break;
			default:
				btnNextOrTryAgain.setText("Try Again");
				successful = false;
				wrongAnswer2(level);
		}
	}
	
	public void checkAnswerChoice3(int level)
	{
		setButtons();
		switch(level)
		{
			case 1:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>Usually the first day of school is mainly getting to know your teachers "
						+ "and what your classes will be about. However, your biology teacher decided to give your class"
						+ " lessons and homework on the 1st day. Luckily you were prepared.<html>");
				break;
			case 6:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>Friday works out well because all of your friends want to party since the school week ends. Hosting a party on Friday allows you"
						+ " to have fun with your friends.<html>");
				break;
			case 7:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>You were able to take your 1st test without any trouble, and you got your homework turned in to before-lunch classes on time. "
						+ "During lunch, you were able to finish your other homework with help from friends and quickly reviewed your 2nd test. You finished your 2nd test "
						+ "without much stress.<html>");
				break;
			case 14:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>AP exams arrive, and you take the exams on certain topics that you have taken as AP in school. It was so stressful to study "
						+ "for them and not hang out with your friends, but it paid off: you were able to answer a lot of questions without any doubt.<html>");
				break;
			default:
				btnNextOrTryAgain.setText("Try Again");
				successful = false;
				wrongAnswer3(level);
		}
	}
	
	public void checkAnswerChoice4(int level)
	{
		setButtons();
		switch(level)
		{
			case 3:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>You just told a lie about you having a family emergency since you know that your family is fine. However, that person does "
						+ "not know that you do not have a family emergency. He let's you go ahead and take care of your \"family problems\". Good thing he did so, otherwise "
						+ "you would have ended up drinking or smoking.<html>");
				break;
			case 9:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>Even though you are good enough to fight back, you chose to do so a little. You took hard hits from the bullies, which "
						+ "compelled other people around you to fight by your side. Eventually the principal and school officers came to handle the situation and suspended "
						+ "the bullies. You are now well known to your love interest and other people, and they all make sure you do not get into trouble.<html>");
				break;
			case 13:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>All of your teachers emailed you back. They gave notes and assignments for you to work on. All of them gave you "
						+ "extensions on all of your assignments by 1-2 days by the time you come back.<html>");
				break;
			case 16:
				btnNextOrTryAgain.setText("Next");
				successful = true;
				lblDescription.setText("<html>It is stressful to study for finals in less than one week. By replacing your free time activities with preparation, "
						+ "studying for the earlier exams 1st, and studying for the later exams on the later days hard enough with your friend, you were able to take "
						+ "your exams without having much trouble on them. You got many A's and few B's.<html>");
				break;
			default:
				btnNextOrTryAgain.setText("Try Again");
				successful = false;
				wrongAnswer4(level);
		}
	}
	
	//choice1 answers: 2, 5, 11, 12
	public void wrongAnswer1(int level)
	{
		switch(level)
		{
			case 1:
				lblDescription.setText("<html>You like playing videogames, but you hate losing. You keep on playing, trying to win more games than you have lost. This "
						+ "makes you overlook the time, and you end up sleeping late. You end up waking up late and getting late for your first class. What a start.<html>");
				break;
			case 3:
				lblDescription.setText("<html>That person makes fun of you and calls you lame since you cannot go to a party due to homework. This compels you "
						+ "to go to the party, where you figure out that there is a lot of smoking and drinking. You try to leave but everyone else traps you, and you end "
						+ "up getting drunk. Your parents were worried, and once you returned home, they figured out you smoked and drank; they get mad.<html>");
				break;
			case 4:
				lblDescription.setText("<html>You continue working as hard as you can, trying to power your way through despite being tired. This causes you to get a "
						+ "really bad headache, making you unable to concentrate and complete your homework.<html>");
				break;
			case 6:
				lblDescription.setText("<html>Some of your friends come over to celebrate your birthday, which is fine since you got to have some fun with them. "
						+ "However, after the party, knowing that you had homework but never did that during your party, you had little time to work on your homework. You "
						+ "either have to sacrifice your sleep time or completing your homework, which are both bad cases.<html>");
				break;
			case 7:
				lblDescription.setText("<html>You complete your homework and study for your tests for a long time to remember a lot of information. You end up sleeping for "
						+ "3 to 4 hours. Even though you turned your homework in time, you did horrible on the final test since you ended up getting a severe headache "
						+ "and could not figure out the answers to most of the questions.<html>");
				break;
			case 8:
				lblDescription.setText("<html>You studied from Sunday throughout the week of the final exams, but that was not enough time. For the exams on the later days, "
						+ "you were not well prepared with those.<html>");
				break;
			case 9:
				lblDescription.setText("<html>You end up walking by the fight so that you do not get hurt. Your love interest, however, noticed that you walked by, and "
						+ "got mad at you and decided not to talk to you ever again.<html>");
				break;
			case 10:
				lblDescription.setText("<html>It is so unfair that you did all of your partners' work on the project. You managed to finish the project and get a good grade "
						+ "for your group, but you suffered sleep-deprivation due to the endless work on the project you did for nights. You felt really sick.<html>");
				break;
			case 13:
				lblDescription.setText("<html>You asked your friend to get you the assignments from every class. She got the assignments, except for 2 classes. There is a "
						+ "bigger problem: she only got the assignments for your classes, not the notes or lessons that your teachers have made. You end up struggling in "
						+ "your homework since you do not have the lessons or notes needed to help you.<html>");
				break;
			case 14:
				lblDescription.setText("<html>AP exam preparation was much harder than you think. There's a lot of content that you need to know. However, you spent time "
						+ "with your friends. You did not have enough exam preparation: one week was not enough. You ended up struggling through your AP exams, big time.<html>");
				break;
			case 15:
				lblDescription.setText("<html>You enjoyed playing videogames with your friends. So much fun. You played with them for a long time. But videogames are really "
						+ "addicting. You end up being addicted to them, playing for the rest of the weekend. You became a lazy and spoilt person. Be better AND healthier. <html>");
				break;
			case 16:
				lblDescription.setText("<html>Seriously. You think cramming would do you any good. Of course you have procrastinated, but that does not mean you cram hard "
						+ "and sleep less. You do not want a headache or feel sick during the exam, do you? So please, TRY AGAIN!!!<html>");
				btnNextOrTryAgain.setVisible(true);
				break;
		}
	}
	
	//choice2 answers: 4, 8, 10, 15
	public void wrongAnswer2(int level)
	{
		switch(level)
		{
			case 1:
				lblDescription.setText("<html>Good choice of choosing to have enough sleep. Unfortunately, when you went to school, you did not have your necessary materials "
						+ "for schoolwork, which does not usually come up on the 1st day. Your biology teacher was cruel by giving lessons. You did not have your notebook,"
						+ " so your teacher got mad at you for not being prepared.<html>");
				break;
			case 2:
				lblDescription.setText("<html>You chose not to go to the robotics club. This gave you enough time to finish your work. You tried to go to the next club "
						+ "meeting; however, the president of the club does not allow you since you did not attend the mandatory meeting, which showed to them  that you were not "
						+ "dedicated, even if the real reason was because you had a lot of work.<html>");
				break;
			case 3:
				lblDescription.setText("<html>You chose to go to the party. Big mistake. There was a lot of smoking and drinking, and you ended up being pressured to do so. "
						+ "Your parents found this out and got mad at you for doing such things and not even telling them.<html>");
				break;
			case 5:
				lblDescription.setText("<html>You finally called a friend after not being able to solve it by yourself for a long time. You got the answer. But... you "
						+ "didn't realize you have other homework to do. Good job wasting all that time you used trying to solve that one problem. The result: you will sleep "
						+ "late.<html>");
				break;
			case 6:
				lblDescription.setText("<html>Not many friends came to your birthday on Saturday. They either went to movies, entertainment places such as Main Event, "
						+ "or other parties. Your party ended up being dull since you did not have enough friends.<html>");
				break;
			case 7:
				lblDescription.setText("<html>You finished your homework, so that's a relief. You also studied for your earlier test 1st and with sufficient time. Therefore, "
						+ "you managed to complete your 1st test the next day without any problem. However, you struggled with the 2nd test since you did not study for at least "
						+ "an hour, which made you paranoid, trying to cram for the 2nd test during lunchtime. That was not enough time, so you do not remember a lot of "
						+ "information for that test. You actually passed, but barely. There was a better way to do this.<html>");
				break;
			case 9:
				lblDescription.setText("<html>You reported the principal about what the bullies have been doing to your love interest, and the principal handled them. "
						+ "However, one day after school, the same bullies attacked you when there was no one around, breaking your bones and making you bleed a lot. "
						+ "You bled to your death.<html>");
				break;
			case 11:
				lblDescription.setText("<html>You need to know that if you want to enjoy your time, you need to finish your work first. But oh well, you chose to work only "
						+ "when you felt like it. You did not do much work though over the weekend since you have been relaxing or playing games. After the Super Bowl party, "
						+ "you still have a lot of work to complete for the next day of school. Good job, you are so irresponsible.<html>");
				break;
			case 12:
				lblDescription.setText("<html>You sent to your friend all of the answers for the math homework. The next day, you were given a zero for cheating. How did "
						+ "the teacher know? Well, your friend had all the answers but showed no work, so the teacher asked him who it was, and he mentioned you. Both you "
						+ "and him got zeroes.<html>");
				break;
			case 13:
				lblDescription.setText("<html>You are sick, yet you chose to go to school. You end up feeling worse and could not make it through the school day. You got "
						+ "sent back home, but you did not get your assignments or the lessons. It will be tough to do your assignments in the future.<html>");
				break;
			case 14:
				lblDescription.setText("<html>This caused two problems. Your friends did not concentrate a lot on preparing for AP exams since they talked a lot. That "
						+ "caused you to have some distractions. Also, you sacrificed your homework and school assignments for AP exam studying. You end up getting bad "
						+ "grades. Terrible management of your school work and responsibilities.<html>");
				break;
			case 16:
				lblDescription.setText("<html>Come on. You procrastinated a lot until you realized that you had final exams, yet you choose to chill. Well then, because of "
						+ "your choice, you end up failing your final exams.<html>");
				btnNextOrTryAgain.setVisible(true);
				break;
		}
	}
	//choice3 answers: 1, 6, 7, 14
	public void wrongAnswer3(int level)
	{
		switch(level)
		{
			case 2:
				lblDescription.setText("<html>The president of the club did not really appreciate what you asked for because this meeting is really mandatory. I know, the "
						+ "president should be nicer, but he is not, so what can you do about it? You either have to attend it or not. You cannot ask for a delay.<html>");
				break;
			case 3:
				lblDescription.setText("<html>You tell him that you are not in the mood, so he ends up pleading to you to go to the party with him. You finally agree, and "
						+ "you end up partying. Over there is a lot of smoking and drinking, in which you full under pressure and commit. Your parents end up figuring this "
						+ "out and get mad at you. Your health is ruined.<html>");
				break;
			case 4:
				lblDescription.setText("<html>You chose to play some games for 30 minutes, but you end up getting carried away and play for longer than how much you "
						+ "expected to play for.<html>");
				break;
			case 5:
				lblDescription.setText("<html>Raging is not the best option. You ended up losing yourself and destroying your work, your phone, your computer, your desk, "
						+ "your notebooks, and your books. Your health took a huge suffering. You also ended up struggling throughout your school year since you destroyed "
						+ "a lot of your school resources.<html>");
				break;
			case 8:
				lblDescription.setText("<html>You chose to chill during the final exams of your first semester. You end up failing them since you barely did any studying "
						+ "for the exams.<html>");
				break;
			case 9:
				lblDescription.setText("<html>You fight the bullies to protect your love interest, and you are winning. Unfortunately, the principal and school officers "
						+ "broke up the fight. Not only did the principal suspend the bullies, he suspended you from school for 2 weeks.<html>");
				break;
			case 10:
				lblDescription.setText("<html>You expected your group members to do the work. However, they did not do their work on the parts of the project that they "
						+ "agreed to work on. As a result, your group ended up getting a failing grade for your project. What an impact to your grades.<html>");
				break;
			case 11:
				lblDescription.setText("<html>You finished all your homework assignments while playing videogames in your breaks. You chose not to watch the Super Bowl. "
						+ "Good choice, but there is a better way that can allow you to watch the Super Bowl with your friends. Hanging out with friends would make you "
						+ "more interactive and social than playing some lame videogames with random people. You also felt lonely over the weekend.<html>");
				break;
			case 12:
				lblDescription.setText("<html>You refused to help him. Good way to protect your grades, but your friend decided not to talk to you anymore because you "
						+ "did not help him, which made him get a failing grade after not being able to receive any other help. He also tells your other friends about this, "
						+ "which makes some of your friends turn against you.<html>");
				break;
			case 13:
				lblDescription.setText("<html>When you felt better, you went back to school and got all the assignments you missed plus the assignments for that day. "
						+ "However, many of them were expected to be due the next day. Only a few of your teachers allowed you to have them complete in 3-5 days, while "
						+ "the rest made you work hard on all of the assignments to turn in the next day or 2.<html>");
				break;
			case 15:
				lblDescription.setText("<html>You went to a party that one of your friends has invited you to. However, you do not know many of your friend's friends. "
						+ "What's worse, her friends end up abusing and insulting you despite your friend telling them not to do so. What a mean party!!!<html>");
				break;
			case 16:
				lblDescription.setText("<html>You try to find some online reviews for the finals exams. You even got some from your friend. Along with that, you use "
						+ "your notes to review for your exams. However, the online reviews did not contain every information that you needed to know. Some information "
						+ "was missing or incorrect, and you faced it the hard way in your exams. You pass all of your exams, but some of your exams have low grades. Is "
						+ "there a better way to do it?<html>");
				btnNextOrTryAgain.setVisible(true);
				break;
		}
	}
	//choice4 answers: 3, 9, 13, 16
	public void wrongAnswer4(int level)
	{
		switch(level)
		{
			case 1:
				lblDescription.setText("<html>You studied some stuff in advance, which cost you some sleep time. However, it was mainly useless since some of the stuff "
						+ "that you learnt were not going to be studied in school after getting information on what you would be learning in your classes.<html>");
				break;
			case 2:
				lblDescription.setText("<html>You went to the meeting but did your homework during the meeting. That was a sign of disrespect since you did not pay "
						+ "attention to what the president of the club was saying. The president did not notice you were doing your homework, but your sponsor did and told "
						+ "you how disrespectful you were.<html>");
				break;
			case 4:
				lblDescription.setText("<html>You went to bed since you felt tired. The next day, you skipped tennis practice to go ahead and complete your assignments. "
						+ "Not a good choice because your coach gets mad at you for skipping tennis practice for something that you should have finished on the previous day.<html>");
				break;
			case 5:
				lblDescription.setText("<html>On the next day of school, one of your classmates in your English class gives you the answer. However, the teacher catches "
						+ "both you and the classmate exchanging answers; therefore, both of you get zeroes.<html>");
				break;
			case 6:
				lblDescription.setText("<html>You celebrated your birthday with your friends on Sunday, and it was fun. You partied all night. However, because this was a "
						+ "Sunday, you had school the next day. You end up sleeping late after the party ends. Luckily, you wake up in time to leave for school, but "
						+ "once you arrived to school, you forgot to pack your homework that you worked over the weekend. That's sad.<html>");
				break;
			case 7:
				lblDescription.setText("<html>Studying a test for two hours is enough, but 2 tests in 2 hours is not enough. After you studied for your tests in 2 hours, "
						+ "you worked on and finished your homework with some trouble. Afterwards, you studied for another 30 minutes before going to sleep. You should "
						+ "have prepared for more though, since you struggled on both of your tests when taking them.<html>");
				break;
			case 8:
				lblDescription.setText("<html>Studying with a group of friends is not really a good idea. You and your friends ended up getting distracted when studying, "
						+ "which hinders your preparation for the exams. You need to try something different.<html>");
				break;
			case 10:
				lblDescription.setText("<html>You reported to your teacher about your project members not doing any work. Your teacher understood and made your "
						+ "group members do a completely separate assignment since they did no work whatsoever. She also gives you an extension to complete your project. "
						+ "However, your group members end up torturing you for reporting them to the teacher.<html>");
				break;
			case 11:
				lblDescription.setText("<html>You decide to alternate between school work and taking breaks. You also watched the Super Bowl, but not the whole thing. Plus "
						+ "you did not host a party. You finished your work and got to watch the game, but the weekend was boring. You could've had some fun with your "
						+ "friends.<html>");
				break;
			case 12:
				lblDescription.setText("<html>You placed the answer sheet(which was your homework) in front of the door to your locker room before going out for tennis "
						+ "practice. After practice, you saw a text from your friend saying that he could not find your homework. You realize that someone stole it. It's "
						+ "gone for good. You have nothing to turn in to your teacher.<html>");
				break;
			case 14:
				lblDescription.setText("<html>You gave yourself a lot of time to prepare for the AP exams, but you sacrificed your school assignments in order to do so. "
						+ "Your grades are dropping due to you not keeping up with your assignments efficiently.<html>");
				break;
			case 15:
				lblDescription.setText("<html>You went to a random party that your parents wanted to go to since they have friends over there. You, however, do not have "
						+ "friends in this party. Boring weekend.<html>");
				break;
		}
	}
	
	public void setButtons()
	{
		btnGoBack.setVisible(true);
		if(levelNum != 16)
			btnNextOrTryAgain.setVisible(true);
		btnChoice1.setVisible(false);
		btnChoice2.setVisible(false);
		btnChoice3.setVisible(false);
		btnChoice4.setVisible(false);
		btnBackButton.setVisible(false);
	}
	
	public String nextLevels(int level)
	{
		switch(level)
		{
			case 1:
				return "<html>Your first year of high school is about to start tomorrow. What "
						+ "are you going to do to be prepared for tomorrow?<html>";
			case 2:
				return "<html>You are given a lot of homework that is due "
						+ "tomorrow but you have a mandatory after school robotics club to attend. What will you do?<html>";
			case 3:
				return "<html>After a day of school on Thursday, you stay after school for some club since you do not have much "
						+ "homework. After the club, one of the club members asks you to go to a late night party with him."
						+ " What will your response be?<html>";
			case 4:
				return "<html>You are doing your homework on a daily basis. One day, you are starting to feel tired, but you"
						+ " are not done with your homework. Are you going to continue working hard or take some form of"
						+ " rest?<html>";
			case 5:
				return "<html>Something stressful is happening. In your English homework, there is one problem that you just"
						+ " cannot solve, and it bothers you. How will you react?<html>";
			case 6:
				return "<html>Today(Wednesday) is your birthday, and you turn 15. Your friends want to celebrate your birthday. "
						+ "When do you plan to celebrate your birthday?<html>";
			case 7:
				return "<html>You are now in a pickle. Tomorrow you have homework for 4 classes due and 2 tests tomorrow"
						+ " for different classes. Out of your 4 classes that have homework due, 2 of them are after your"
						+ " lunch in school. Out of your 2 tests, one of them will be after school lunch. What is your plan to"
						+ " do for the day before you go to school tomorrow?<html>";
			case 8:
				return "<html>The final week of the 1st semester is arriving. Out of 7 classes, you have 6 exams since one"
						+ " of your classes is tennis. How will you study for your final exams, starting from the week before the exams?<html>";
			case 9:
				return "<html>Spring semester starts, and so does loads of work from school. Isn't that fun? Well, the 1st day"
						+ " of the spring semester does not start off good. During lunch, you see one of your friends, who is"
						+ " your love interest, being mistreated by some bullies. What action will you take?<html>";
			case 10:
				return "<html>You are assigned a project in AP human geography with random teammates. All of you have divided"
						+ " the work up among yourselves. However, 3 days prior to the due date, you realize that your"
						+ " teammates have done nothing. How will you handle this situation?<html>";
			case 11:
				return "<html>The Super Bowl is coming up on Sunday, and imagine that you desire to watch it. Your "
						+ "friends are also asking if they can watch the Super Bowl with you. However, as usual, you get a "
						+ "stack of homework due on Monday. What would you plan on doing?<html>";
			case 12:
				return "<html>Your best friend needs your help on math homework. He has no idea how to solve any of the "
						+ "given problems. However, your teachers have mentioned about academic integrity: if you are"
						+ " cheating by getting answers or giving away answers, you and the other person involved can get"
						+ " a zero for that homework, and your parents will receive emails. What will you do?<html>";
			case 13:
				return "<html>You are having serious allergies due to the spring season because you are allergic to pollen."
						+ " You start to become very sick. However, there are assignments that you must get. How will you "
						+ "get them?<html>";
			case 14:
				return "<html>It is a Saturday. Usually you would hang out with your friends, but AP exams are coming up"
						+ " in 3 weeks. When do you plan on preparing for your AP exams?<html>";
			case 15:
				return "<html>You finished your AP exams, and two weeks of school are left(the final week is the final exams. "
						+ "It is a Saturday now. You are really bored. What activity will you do?<html>";
			default:
				return "<html>The final week of high school just came. It is Monday, and final exams start tomorrow. "
						+ "However, you have yet to prepare for them. Luckily, the only exam you have tomorrow is tennis, "
						+ "so you will not have an exam for tomorrow. You still need more time to prepare for the other "
						+ "exams. With the limited time you have, how will you prepare for your exams?<html>";
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
