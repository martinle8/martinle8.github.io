//Martin Le
//Section AJ
//TA: James Hu
//This program finds anagrams of a given words
//from a dictionary
import java.util.*;
public class AnagramSolver {
	private List<String> list;
	private Map<String, List<String>> letters;
	
   //constructs a table for words and their letter 
   //counts from the dictionary chosen
   //takes a List<String> list of words
	public AnagramSolver(List<String> list) {
		for (String word : list) {
			List<String> value = new ArrayList<String>();
			LetterInventory key = new LetterInventory(word);
			value.add(word);
			letters.put(key.toString(), value);
		}
	}
	
   //throws IllegalArgumentException if given a max less than 0
   //takes String s of chosen word, and int max for max words
   //constructs LetterInventory of String s
   //and a new empty List of matches
   //compares each word in dictionary and sends it to printer
   //method
	public void print(String s, int max) {
		if (max < 0) {
			throw new IllegalArgumentException();
		}
		LetterInventory word = new LetterInventory(s);
		List<String> matches = new ArrayList<String>();
		for (String e : list) {
			LetterInventory current = new LetterInventory(e);
			LetterInventory difference = word.subtract(current);
			if (difference != null && !matches.contains(current.toString())) {
				matches.add(current.toString());
			}
		}
		printer(word, matches, max);
	}
	
   //takes LetterInventory word which is the search word, 
   //list of matches, and the int max, uses recursive backtracing 
   //to compare words in dictionary to search word
   //subtracts the letters and checks for more matches
	private void printer(LetterInventory word, List<String> matches, int max) {
		Stack<String> matchFinals = new Stack<String>();
		if ((matchFinals.size() <= max || max == 0) && word != null) {
			if (word.isEmpty() && (matchFinals.size() == max || max == 0)) {
				if (matchFinals != null) {
					System.out.println(matchFinals.toString());
				}
			} else {
				for (String s : matches) {
					LetterInventory temp = new LetterInventory(s);
					LetterInventory difference = word.subtract(temp);
					List<String> words = letters.get(s);
					for (String term : words) {
						matchFinals.push(term);
						printer(difference, matches, max);
						matchFinals.pop();
					}
					
				}
			}
		}
	}
}
