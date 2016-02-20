package main;

import gui.NewMainFrame;
import identity.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
	private Reader reader;
	private NewMainFrame frame;
	private String[][] letterGrid;
	
	public Controller(){
		reader = new Reader();
		frame = new NewMainFrame(this);
		letterGrid = new String[1][1];
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton j = (JButton) arg0.getSource();
		if(j.getText().equals(NewMainFrame.CONFIG_BTN) ){
			
		}
		
		if(j.getText().equals(NewMainFrame.USE_GRID_BTN)){
			letterGrid = frame.getGridVals();
		}
	}
	
	
	public String[][] getLetterGrid() {
		return letterGrid;
	}

	public static void main(String[] args){
		Controller c = new Controller();
	}

}
