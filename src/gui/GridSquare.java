package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GridSquare {
	private int x,y,sideLength;
	private String displayLetter;
	private boolean isClicked;
	private final Color clickedColor = new Color(245,186,197);
	private final int FONTSIZE = 60;
	
	public GridSquare(int x, int y, int sideLength, String displayLetter){
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
		this.displayLetter = displayLetter;
		this.isClicked = false;
	}
	
	public void drawOn(Graphics g){
		/*
		 * This is checking if the user has clicked on the gird square they want to edit
		 */
		if(isClicked){
			g.setColor(clickedColor);
		}else {
			g.setColor(Color.white);
		}
		
		g.fillRect(x, y, sideLength, sideLength);
		
		//Border for the grid square 
		g.setColor(Color.black);
		g.drawRect(x, y, sideLength, sideLength);
		
		//Draws out the character of the square
		g.setColor(Color.darkGray);
		g.setFont(new Font("Consolas",Font.BOLD,FONTSIZE));
		g.drawString(displayLetter.toUpperCase(), x+(sideLength/2-(FONTSIZE/2)), y+(sideLength/2+(FONTSIZE/3)));
//		g.drawString(displayLetter, x+(sideLength/2), y+(sideLength/2));

	}
	
	/**
	 * This method will return true if the x and y inputed is inside the square
	 * @return
	 */
	public boolean contains(int x, int y){
		return x >= this.x && x <= (this.x + this.sideLength) && y >= this.y && y <= (this.y + this.sideLength);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public String getDisplayLetter() {
		return displayLetter;
	}

	public void setDisplayLetter(String displayLetter) {
		this.displayLetter = displayLetter;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	
	
}
