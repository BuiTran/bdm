package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class will be used to have the user create the grid that the word find algorithm 
 * will go through. It will contain a special Square class that is clickable.
 * @author Bryce DeVaughn.
 *
 */
public class GridPanel extends JPanel implements MouseListener{
	private GridSquare[][] displayGrid;//Contains the GridSquares that the user will be able to click on
	private String[][] gridVals;//Contains the display characters that are in each grid square
	private final int WIDTH = 492;
	private int N;

	private int GRIDSQSIDELENGTH;

	
	public GridPanel(int N){
		this.N = N;
		System.out.println("GRID N: "+N);
		displayGrid = new GridSquare[N][N];
		gridVals = new String[N][N];
		this.GRIDSQSIDELENGTH= WIDTH/N;
		this.fillLists();
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.setSize(new Dimension(WIDTH, WIDTH));
		this.addMouseListener(this);
		
	}
	

	/**
	 * This will fill the lists gridVals and displayGrid
	 */
	public void fillLists(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				GridSquare sq = new GridSquare(j * GRIDSQSIDELENGTH, i * GRIDSQSIDELENGTH, GRIDSQSIDELENGTH, "");
				displayGrid[i][j] = sq;
				gridVals[i][j] = sq.getDisplayLetter();
			}
		}
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(0, 0, WIDTH, WIDTH);
		for(int i = 0; i < displayGrid.length; i++){
			for(int j = 0; j < displayGrid[i].length; j++){
				displayGrid[i][j].drawOn(g);
			}
		}
	}
	
	/**
	 * This method will check every grid square to see if it has been clicked
	 * @return
	 */
	public void checkClickLoc(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		for(int i = 0; i < displayGrid.length; i++){
			for(int j = 0; j < displayGrid[i].length; j++){
				GridSquare sq = displayGrid[i][j];
				if(sq.contains(mx,my)){
					sq.setClicked(true);
					this.repaint();
					String str = JOptionPane.showInputDialog("Enter a letter.", null);
					gridVals[i][j] = str;
					sq.setDisplayLetter(str);
					sq.setClicked(false);
					this.repaint();
					
				}
			}
		}
		
	}

	public GridSquare[][] getDisplayGrid() {
		return displayGrid;
	}

	public String[][] getGridVals() {
		return gridVals;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.checkClickLoc(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
	
	
}
