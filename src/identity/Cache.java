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
	
	private class WordComparator implements Comparator<Word> {
			@Override
			public int compare(Word word1, Word word2) {
				String t1 = word1.getText();
				String t2 = word2.getText();
				
				return t1.compareTo(t2);
			}
		}
	 
}
