package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import main.MainFrame;

import org.junit.Assert;
import org.junit.Test;

import identity.*;
public class CacheTest {
	
	@Test
	public void testFindWords(){
		ArrayList<Word> words = new ArrayList<Word>();
		words.add(new Word("high"));
		words.add(new Word("trust"));
		words.add(new Word("---blast"));
		words.add(new Word("blast"));
		Cache c = new Cache();
		
		Set<Word> newWords = c.findWords(words);
		
		assertFalse(newWords.contains("---blast"));
	}

	@Test
	public void testInsert() {
		System.out.println("Test Insert");
		Word w1 = new Word("qwer");
		Word w2 = new Word("asdf");
		Word w3 = new Word("zxcv");
		Word w4 = new Word("qwer");
		Cache c = new Cache();
		c.addWord(w1);
		c.addWord(w2);
		c.addWord(w3);
		for (Word word : c.getMyCollection()){
			System.out.println(word.getText());
		}
		System.out.println("******************");
	}
	@Test
	public void testRemove() {
		System.out.println("Test Remove");
		Word w1 = new Word("qwer");
		Word w2 = new Word("asdf");
		Word w3 = new Word("zxcv");
		Cache c = new Cache();
		c.addWord(w1);
		c.addWord(w2);
		c.addWord(w3);
		c.removeWord(w3);
		for (Word word : c.getMyCollection()){
			System.out.println(word.getText());
		}
		System.out.println("******************");
	}
	@Test
	public void testUnique() {
		System.out.println("Test Remove");
		Word w1 = new Word("qwer");
		Word w2 = new Word("asdf");
		//2 word with the same text
		Word w3 = new Word("zxcv");
		Word w4 = new Word("zxcv");
		Cache c = new Cache();
		c.addWord(w1);
		c.addWord(w2);
		c.addWord(w3);
		c.addWord(w4);
		for (Word word : c.getMyCollection()){
			System.out.println(word.getText());
		}
		System.out.println("******************");
	}
	@Test
	public void testContains() {
		System.out.println("Test Contain");
		Word w1 = new Word("qwer");
		Word w2 = new Word("asdf");
		Word w3 = new Word("zxcv");
		Cache c = new Cache();
		c.addWord(w1);
		c.addWord(w2);
		c.addWord(w3);
		Assert.assertTrue(c.containsWord(w1.getText()));
		Assert.assertTrue(c.containsWord(w2.getText()));
		Assert.assertTrue(c.containsWord(w3.getText()));
		System.out.println("******************");
	}
	
	
	
	

	
	
	
	
}
