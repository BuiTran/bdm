package identity;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Cache {
	 private Set<Word> myCollection;
	 
	 public Cache(){
		 myCollection = new TreeSet<>(new WordComparator());
	 }
	  
	 public Set<Word> getMyCollection() {
		return myCollection;
	}

	public void setMyCollection(Set<Word> myCollection) {
		this.myCollection = myCollection;
	}
	
	public void addWord(Word word){
		this.myCollection.add(word);
	}
	
	public void removeWord(Word word){
		this.myCollection.remove(word);
	}
	
	public int getSize(){
		return this.myCollection.size();
	}
	
	public boolean containsWord(String text){
		Word w = new Word(text);
		return this.myCollection.contains(w);
	}
	
	/**
	 * This method will take in a list of Word objects and return a new list of the ones
	 * that are contained in the dictionary
	 * @author Bryce DeVaughn
	 *
	 */
	public Set<Word> findWords(Set<Word> newWords){
		Set<Word> rtnList = new TreeSet<>(new WordComparator());
		
		for(Word w: newWords){
			if(this.containsWord(w.getText())){
				rtnList.add(w);
			}
		}
		
		return rtnList;
	}
	
	private class WordComparator implements Comparator<Word> {
			@Override
			public int compare(Word word1, Word word2) {
				String t1 = word1.getText();
				String t2 = word2.getText();
				
				return t1.compareTo(t2);
			}
		}
	 
}
