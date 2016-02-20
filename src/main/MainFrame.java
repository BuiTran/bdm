package main;
import identity.Reader;
import identity.Word;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Software Engineering Lab 1; Word Dictionary Cache
 * 
 * This project will maintain a cache built from dictionary files, parsed and sorted for our needs. 
 * The user will be able to input a word in the GUI, and the program will check the cache to confirm the 
 * validity of the word. It keeps track of how many valid words have been entered.
 * 
 * @Team "Fantastic Five" : 
 * Megan Mayfield (GUI, main driver)
 * Riley Kippes (reading in dictionary files)
 * Michael Grado (sorting of the dictionaries/cache)
 * Tran Bui (merging code, general cache stuff)
 * Davis Gregory-Allen (general cache stuff)
 *
 */

public class MainFrame extends JFrame {
	private JLabel titleLabel;
	private JLabel promptLabel;
	private JLabel countLabel;
	private JButton enterButton;
	private JButton clearButton;
	private JTextField inputField;
	private int score;
	//Reader implementation for creating and reading a cache.
	private Reader reader;

	public static void main(String[] args) {
		JFrame frame = new MainFrame();
		frame.setVisible(true);
	}
	
	/**
	 * This constructor sets up all the elements of the GUI as well as the listeners that will perform 
	 * actions with the cache when buttons are pressed.
	 * 
	 */
	public MainFrame() {
		//Create the Reader File
		reader = new Reader();
		/*******************************************************************************
		 * GUI implementation
		 */
		score = 0;
		setResizable(false);
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane();
		
		/*
		 * The top panel will just hold the title.
		 */
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255,255,255));
		getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout());
		
		titleLabel = new JLabel("ENTER SOME WORDS!");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		topPanel.add(titleLabel);
		
		/*
		 * The center panel needs subpanels that contain the text field and prompt for the user.
		 */
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255,255,255));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		//subpanel for the prompt
		JPanel promptSubPanel = new JPanel();
		promptSubPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		centerPanel.add(promptSubPanel);
		
		promptLabel = new JLabel("Your Submission:");
		promptSubPanel.add(promptLabel);
		
		//subpanel for the input
		JPanel inputSubPanel = new JPanel();
		inputSubPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPanel.add(inputSubPanel);
		
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(250,45));
		inputSubPanel.add(inputField);
		
		/*
		 * The bottom panel will have the option buttons and display how many words have been submitted.
		 */
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255,255,255));
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout());
		
		/*
		 * The enter button tells the program to check the word against the cache.
		 */
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = inputField.getText();
				
				//if empty, don't bother doing anything
				if(word.equals("")) {
					countLabel.setText("WORDS: " + score);
				} else {
					//determine if it's an allowed word
					if(verifyWord(word)) {
						score++;
						countLabel.setText("WORDS: " + score);
					} else {
						countLabel.setText("WORDS: " + score);
					}
				}
				
				inputField.setText(""); 
			}
		});
		bottomPanel.add(enterButton);
		
		/*
		 * The clear button just empties the text field.
		 */
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText("");
			}
		});
		bottomPanel.add(clearButton);
		
		/*
		 * The final item is just a label that displays how many words have been valid.
		 */
		countLabel = new JLabel("WORDS: " + score);
		bottomPanel.add(countLabel);
	}
	/*
	 * Check if the word is in the cache.
	 */
	public boolean verifyWord(String word) {
		return reader.getMyCache().containsWord(word);
	}
	
	
}
