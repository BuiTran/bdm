package test;
import org.junit.Assert;
import main.MainFrame;
import org.junit.Test;

/**
 * 
 * These are the tests for the search algorithm; it goes through the cache with various possible words
 * as criteria and ensures the code handles the cases correctly. 
 * 
 */

public class MainFrameTest {

	/*
	 * The first test just looks for a word that we know is valid in the cache.
	 */
	@Test
	public void testValid() {
		MainFrame frame = new MainFrame();
		Assert.assertTrue(frame.verifyWord("fish"));
	}
	
	/*
	 * The second test looks for a word that is invalid, not in the cache.
	 */
	@Test
	public void testInvalid() {
		MainFrame frame = new MainFrame();
		Assert.assertFalse(frame.verifyWord("orange"));
	}
	
	/*
	 * The third test includes a word with a number, that is supposed to be invalid.
	 */
	@Test
	public void testNumber() {
		MainFrame frame = new MainFrame();
		Assert.assertFalse(frame.verifyWord("f1sh"));
	}
	
	/*
	 * The fourth test just has a single letter as the target word, which will be invalid.
	 */
	@Test
	public void testSingleLetter() {
		MainFrame frame = new MainFrame();
		Assert.assertFalse(frame.verifyWord("f"));
	}
	
	/*
	 * The final test is with an empty String, such as if the user did not input anything and just pressed "enter". 
	 */
	@Test 
	public void testEmpty() {
		MainFrame frame = new MainFrame();
		Assert.assertFalse(frame.verifyWord(""));
	}

}
