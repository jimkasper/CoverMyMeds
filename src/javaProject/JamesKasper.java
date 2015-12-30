package javaProject;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class JamesKasper {
	public static void main(String[] args) {
	
	HashMap<String,Integer> wordMap = new HashMap <String, Integer>();	
	String filePath = "/Users/james/workspaces/jamesKasper/text.txt";
	StringBuffer buffer = new StringBuffer();
	char c = ' ';
	String word= "";

		try {
			@SuppressWarnings("resource")
			FileReader reader = new FileReader(filePath);
			int text = reader.read();
			
			while(text != -1) {
				text = reader.read();
				c = (char)text;
				if (c != '"' && c != ' ' && c != '.' && c != '?'&& c != '!' && c != ','){
					buffer.append(c);
				}else{
					word= buffer.toString();
					Integer i = wordMap.get(word);
					if (i == null){
						wordMap.put(word, 1);
					}else{
						wordMap.put(word, i + 1);
					}
					buffer.setLength(0);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<String> keySetIterator = wordMap.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			System.out.println("WORD: " + key + " INSTANCES: " + wordMap.get(key)); 
		}
	}
}
