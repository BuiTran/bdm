package main;

import gui.NewMainFrame;
import identity.Reader;
import gui.InitialFrame;
import identity.Cache;
import identity.Word;
import identity.WordFinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;

public class Controller implements ActionListener {
	private Reader reader;
	private NewMainFrame frame;
	private Word[][] letterGrid;
	private WordFinder wFinder;
	private InitialFrame iFrame;
	private int wordLength;
	private int n;
	
	public Controller(){
		this.n = 0;
		this.wordLength = 0;
		this.reader = new Reader();
		//frame = new NewMainFrame(this);
		this.iFrame = new InitialFrame(this);
		this.iFrame.setVisible(true);
		this.letterGrid = new Word[1][1];
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton j = (JButton) arg0.getSource();
		
		if(j.getText().equals(NewMainFrame.USE_GRID_BTN)){
			letterGrid = frame.getGridVals();
			wFinder = new WordFinder(wordLength,n,letterGrid);
			Set<Word> list = reader.getMyCache().findWords(wFinder.getAllWords());
			ArrayList<Word> words = new ArrayList<Word>();
			words.addAll(list);
			frame.setWords(words);
			frame.repaint();
			frame.update();
		}
		
		if(j.getText().equals(InitialFrame.OK_BTN)){

			String nStr = iFrame.getTextN().getText();
			String wordLengthStr = iFrame.getTextLimit().getText();
			n = Integer.parseInt(nStr);
			wordLength = Integer.parseInt(wordLengthStr);
					
			System.out.println("N: "+n+"    WordLength: "+wordLength);
			frame = new NewMainFrame(this, n);
			iFrame.setVisible(false);
		}
	}
	
	

	public Word[][] getLetterGrid() {
		return letterGrid;
	}

	public static void main(String[] args){
		Controller c = new Controller();
	}

}
