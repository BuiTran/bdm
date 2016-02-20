package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controller;

public class NewMainFrame extends JFrame{
	
	public static final String CONFIG_BTN = "Config Grid", USE_GRID_BTN = "Save Grid";
	private GridPanel gPanel;
	
	public NewMainFrame(Controller c){
		this.setTitle("Word Finder");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(600,600));
		this.setMinimumSize(new Dimension(600,600));
		this.setMaximumSize(new Dimension(600,600));
		
		
		JPanel mainPanel = new JPanel();//Setting up the mainPanel that will contain all of the panels
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		
		JPanel centerPnl = new JPanel();//This panel will contain the grid and have a config panel to change the grid
		centerPnl.setLayout(new BorderLayout());
		
		gPanel = new GridPanel();
		centerPnl.add(gPanel, BorderLayout.CENTER);
		
		JPanel centerNorthPnl = new JPanel();//This panel will hold the button that will be used to configure the grid of squares
		centerNorthPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton configGridBtn = new JButton(CONFIG_BTN);
		configGridBtn.addActionListener(c);
		
		centerNorthPnl.add(configGridBtn);
		
		centerPnl.add(centerNorthPnl,BorderLayout.NORTH);
		
		JPanel centerSouthPnl = new JPanel();//This panel will hold some info and allow the grid to be saved and used
		centerSouthPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel infoLbl = new JLabel("Press this button to use the grid you made");
		centerSouthPnl.add(infoLbl);
		
		JButton useGridBtn = new JButton(USE_GRID_BTN);
		centerSouthPnl.add(useGridBtn);
		
		centerPnl.add(centerSouthPnl, BorderLayout.SOUTH);
		
		mainPanel.add(centerPnl, BorderLayout.CENTER);
		
		this.pack();
		
	}
	
	public String[][] getGridVals(){
		return gPanel.getGridVals();
	}
}
