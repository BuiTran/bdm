package main;

import gui.NewMainFrame;
import identity.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
	private Reader reader;
	private NewMainFrame frame;
	
	public Controller(){
		reader = new Reader();
		frame = new NewMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton j = (JButton) arg0.getSource();
		if(j.getText().equals(frame.CONFIG_BTN) ){
			
		}
	}
	
	public static void main(String[] args){
		Controller c = new Controller();
	}

}
