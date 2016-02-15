package identity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reader {
	private Cache myCache;
	
	
	private void initCache(){
		//For macs
		File fileDirectory = new File("dict/");
		File cacheFile = new File("dict/cache.txt");
		//For windows
//		File fileDirectory = new File("dict\\");
//		File cacheFile = new File("dict\\cache.txt");
		boolean renewCache = false;
		if (!cacheFile.exists()){
			renewCache = true;
		} else{
			if (fileDirectory.lastModified() > cacheFile.lastModified()){
				renewCache = true;
			}
		}
		if (renewCache){
			for (File f: fileDirectory.listFiles()){
				BufferedReader br = null;
				try{
					FileReader fr = new FileReader(f);
					br = new BufferedReader(fr);
					String line = br.readLine();
					while(line!=null){
						//Split it into multiple words
						String[] listWord = line.split(" |-|_|\\.");
						//Work with each word in the listWord
						for (String word : listWord){
							boolean addWord = true;
							word= word.replaceAll("[^\\p{L}\\p{Nd}]+", "");
							//Check if it's a single character word
							if (word.length() == 1){
								addWord = false;
							}
							//Check if it contains number
							if(word.matches(".*\\d.*")){
								addWord = false;
							}
							word = word.toLowerCase();
							if (addWord){
								//Create a Word object
								Word w = new Word(word);
								myCache.addWord(w);
							}
						}
						line = br.readLine();

					}
				}
				catch (IOException ex){
					System.err.println("Trouble with file :"+ex.getMessage());
				}
				finally {
					try{
						if (br != null) {
							br.close();
						}
					}
					catch (Exception ex1) {
						ex1.printStackTrace(); // give up
						System.exit(-1);
					}
				}
			}
			System.out.println("Finished reading all text files");

			//Create a new cache file.
			File newCache = new File("dict\\cache.txt");
			try {
				newCache.createNewFile();
				FileWriter writer = new FileWriter(newCache); 
				System.out.println(myCache.getSize());
				writer.write(String.format("%d",myCache.getSize()));
				writer.write("\n");
				for (Word w: myCache.getMyCollection()){
					writer.write(w.getText());
					writer.write("\n");
				}
				writer.flush();
				writer.close();


			} catch (IOException e) {
				System.out.println("Trouble with writing file");
				e.printStackTrace();
			}

		}
		//If not, we don't have to recreate the cache file. Just read directly from the cache.txt

		BufferedReader br = null;
		try{
			FileReader fr = new FileReader(cacheFile);
			br = new BufferedReader(fr);
			String str = br.readLine();
			//May use later.
			int numberOfWord = Integer.parseInt(str);
			//Now we start reading the words
			str = br.readLine();
			while(str!=null){
				Word w = new Word(str);
				myCache.addWord(w);
				str = br.readLine();
			}
		}
		catch (IOException ex){
			System.err.println("Trouble with file :"+ex.getMessage());
		}
		finally {
			try{
				if (br != null) {
					br.close();
				}
			}
			catch (Exception ex1) {
				ex1.printStackTrace(); // give up
				System.exit(-1);
			}
		}

	}


	public Cache getMyCache() {
		return myCache;
	}

	public Reader(){
		myCache = new Cache();
		initCache();
	}


}
