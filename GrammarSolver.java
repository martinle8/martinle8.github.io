//Martin Le
//Section AJ
//TA:James Hu
//This program generates and manages a grammar using BNF
import java.util.*;
public class GrammarSolver{
	private Map<String, String[]> grammarChest = new TreeMap<String, String[]>();
	
	//constructs a GrammarSolver inventory like
	//storage
	//parameter: List grammar of words in BNF
	//goes through string by string and puts it through getRules
	//Throws IllegalArgumentException if List is empty
	public GrammarSolver(List<String> grammar) {
		if(grammar.isEmpty()) {
			throw new IllegalArgumentException();
		}else{
			for(String s : grammar) {
				getRules(s);
			}
		}
	}
	
	//takes a String rule parameter and splits the
	//terminals from non terminals
	//puts the data into a map using terminals as keys
	//Throws IllegalArgumentException if the key
	//already exists
	private void getRules(String rule) {
		String[] nonTerm = rule.split("::=");
		String key = editNonTerm(nonTerm[0]);
		String [] value = nonTerm[1].replaceFirst("^\\|", "").trim().split(" \t+");
		if(grammarContains(key)) {
			throw new IllegalArgumentException();
		}else{
			grammarChest.put(key, value);
		}
	}
	
	//removes the < and > from the terminals and
	//returns the new String
	private String editNonTerm(String nonTerm) {
		nonTerm.replaceAll("(<|>)+", "").trim();
		return nonTerm;
	}
	
	//returns whether the key from parameter String
	//symbol is apart of the map
	//Throws IllegalArgumentException if given an empty
	//string
	public boolean grammarContains(String symbol) {
		if(symbol.isEmpty()){
			throw new IllegalArgumentException();
		}else{
			return(getSymbols().contains(editNonTerm(symbol)));
		}
	}
	
	//returns the key's values in String
	public String getSymbols() {
		String now = "[";
		for(String s : grammarChest.keySet()) {
			now += s + ", ";
		}
		return now;
	}
	
	//returns a String array of the generated desired
	//String symbols and puts int times number of examples
	//into the String array gen
	//Throws IllegalArgumentException if the key
	//doesn't exist or if the number asked is below 0
	public String[] generate(String symbol, int times) {
		String [] gen = new String [times];
		if(!grammarContains(editNonTerm(symbol)) || times < 0){
			throw new IllegalArgumentException();
		}
		String[] test = grammarChest.get(editNonTerm(symbol));
		for(int i = 0; i < times; i++){
			gen[i] = generate2(test);
		}
		return gen;
	}
	
	//returns the different combinations given a key and
	//whether it is a terminal or not
	public String generate2(String[] test) {
		for(String s : test) {
			if(!grammarContains(editNonTerm(s))){
				return test[randomNum(test.length)];
			}else{
				generate2(grammarChest.get(editNonTerm(s)));
			}
		}
		return null;
	}
	
	//generates a random number given a max int
	//returns int
	private int randomNum(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}
	
}
