package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controller;

import javax.swing.JScrollPane;

import identity.Word;
import identity.WordFinder;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JSlider;

public class NewMainFrame extends JFrame{
	
	public static final String USE_GRID_BTN = "Use Grid";
	private GridPanel gPanel;
	private JList myList;
	public ArrayList<String> words;
	
	public NewMainFrame(Controller c, int N){
		this.setTitle("Word Finder");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(800,600));
		this.setMinimumSize(new Dimension(600,600));
		this.setMaximumSize(new Dimension(800,900));
		this.words = new ArrayList<String>();

		JPanel mainPanel = new JPanel();//Setting up the mainPanel that will contain all of the panels
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		
		JPanel centerPnl = new JPanel();//This panel will contain the grid and have a config panel to change the grid
		centerPnl.setLayout(new BorderLayout());
		
		gPanel = new GridPanel(N);
		centerPnl.add(gPanel, BorderLayout.CENTER);

		JPanel centerSouthPnl = new JPanel();//This panel will hold some info and allow the grid to be saved and used
		centerSouthPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel infoLbl = new JLabel("Press this button to use the grid you made");
		centerSouthPnl.add(infoLbl);
		
		JButton useGridBtn = new JButton(USE_GRID_BTN);
		centerSouthPnl.add(useGridBtn);
		
		centerPnl.add(centerSouthPnl, BorderLayout.SOUTH);
		
		mainPanel.add(centerPnl, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		mainPanel.add(scrollPane, BorderLayout.WEST);
		
		myList = new JList (words.toArray());
		scrollPane.setViewportView(myList);
		
		scrollPane.getViewport().setView(myList);
	
		this.pack();
		
	}
	
	public void setWords(ArrayList<Word> newWords){
		ArrayList<String> rtnList = new ArrayList<String>();
		
		for(Word w: newWords){
			rtnList.add(w.getText());
		}
		
		words = rtnList;
	}
	
	public Word[][] getGridVals(){
		String[][] tempVals = gPanel.getGridVals();
		Word[][] rtnList = new Word[tempVals.length][tempVals[0].length];
		
		for(int i = 0; i < tempVals.length; i++){
			for(int j = 0; j < tempVals[i].length;j++){
				rtnList[i][j] = new Word(tempVals[i][j]);
			}
		}
		
		return rtnList;
	}

}
