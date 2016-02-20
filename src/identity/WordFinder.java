package identity;

import java.util.ArrayList;

//
public class WordFinder {
	private int[][][] positionArray;
	private int m;
	private int n;
	private Word[][] wordPuzzle;
	private ArrayList<Word> result;
	public WordFinder(int m, int n, Word[][] wordPuzzle){
		this.m = m;
		this.n = n;
		this.wordPuzzle = wordPuzzle;
		this.result = new ArrayList<Word>();
		positionArray = new int[3][3][2];
		for (int i = 0; i<3;i++){
			for (int j = 0; j <3;j++){
				positionArray[i][j][0] = i-1;
				positionArray[i][j][1] = j-1;
			}
		}
	}
	
	
	public ArrayList<Word> findWord(int m,int r,int c, ArrayList<Integer> usedSet){
		//Terminate condition for m < 0. Return empty list
		if (m<=0){
			return null;
		}
		//For invalid position. Return empty list
		if (r<0 || c <0 || r>=n || c>=n){
			return null;
		}
		//For visited position. Return empty list
		int position = r * n + c;
		Integer pos = Integer.valueOf(position);
		if (usedSet.contains(pos)){
			return null;
		}
		
		//Accepted state when m = 1. Return the list containing the current letter.
		if (m==1){
			ArrayList<Word> li = new ArrayList<Word>();
			li.add(wordPuzzle[r][c]);
			return li;
		}
		//Add the current letter to the usedSet
		usedSet.add(pos);
		
		ArrayList<Word> result = new ArrayList<Word>();
		for (int i = 0; i<3;i++){
			for (int j = 0; j <3;j++){
				int nr = r + positionArray[i][j][0];
				int nc = c + positionArray[i][j][1];
				int npos = nr * n + nc;
				//Make a copy of the usedSet
				ArrayList<Integer> copyUsedSet= new ArrayList<Integer>();
				for (Integer k: usedSet){
					copyUsedSet.add(k);
				}
				ArrayList<Word> subWords = findWord(m-1, nr, nc, copyUsedSet);
				if (subWords != null){
					for (Word w: subWords){
						//Create the new word with letter, making the m-letter word.
						Word concatWord = new Word(wordPuzzle[r][c].getText().concat(w.getText()));
						result.add(concatWord);
					}
				}
				
			}
		}
		return result;
	}
	public ArrayList<Word> getAllWords(){
		ArrayList<Word> total = new ArrayList<Word>();
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				ArrayList<Word> subset = findWord(m, i, j, new ArrayList<Integer>());
				for (Word w: subset){
					total.add(w);
				}
				
			}
		}
		return total;
	}
	
}
