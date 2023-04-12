//Martin Le
//Section AJ
//TA:James Hu
//This program manages and creates a hangman game
import java.util.*;
public class HangmanManager {
   private Set<String> words;
   private int guessesLeft;
   private Set<Character> guesses;
   
   
   //constructs a HangmanManager object
   //takes parameter of a Collection of a dictionary
   //an int length for desired word length and a
   //int max which is the max number of guesses
   //will throw IllegalArgumentExcpetion if given a zero or negative length
   //or a negative max guesses
   public HangmanManager(Collection<String> dictionary, int length, int max){
      if (length < 1 || max < 0) {
         throw new IllegalArgumentException();
      }
      guessesLeft = max;
      words = new TreeSet<String>();
      guesses = new TreeSet<Character>();
      Iterator<String> itr = dictionary.iterator();
      for(String s : dictionary) {
         if (s.length() == length) {
            words.add(s);
         }
      }
   }
   
   //returns the word list set for words left in the
   //words set that contains all possible words for the game
   public Set<String> words() {
      return words;
   }
   
   //returns an int of the number of wrong guesses left
   public int guessesLeft() {
      return guessesLeft;
   }
   
   //returns a list of user's guesses
   public Set<Character> guesses() {
      return guesses;
   }
   
   //throws an IllegalArgumentException is the
   //words guesses set is empty
   //will return the string after it
   //goes through the other pattern
   public String pattern() {
      if(words.isEmpty()) {
         throw new IllegalStateException();
      }
      return pattern(words.iterator().next());
   }
   
   //returns a string of the pattern
   //of letters based on the guesses made by user
   //returns the string product
   private String pattern(String word) {
      String product = "";
      for(int i = 0; i < word.length(); i++) {
         if(guesses.contains(word.charAt(i))) {
            product += word.substring(i, i + 1);
         }else{
            product += "-";
         }
      }
      return product;
   }
   
   //records the next guess made by user
   //uses the paramter char guess from the user
   //throws an IllegalStateException if the
   //words guessed set are empty
   //or if the user has no guesses left
   //returns number of times char appears in patern
   public int record(char guess) {
      if(words.isEmpty() || guessesLeft < 1) {
         throw new IllegalStateException();
      }else if(guesses.contains(guess)){
         throw new IllegalArgumentException();
      }
      Map<String, Set<String>> links = new TreeMap<String, Set<String>>();
      String patternOne = this.pattern();
      guesses.add(guess);
      update(links);
      if(this.pattern().equals(patternOne)) {
         guessesLeft--;
      }
      return matches(this.pattern(), guess);
   }
   
   //creates the new map refreshed that takes a parameter
   //map links in order to test each word for if its
   //new or not and creates the object
   private void update(Map<String, Set <String>> links) {
      for(String s : words) {
         String pattern = pattern(s);
         if(!links.containsKey(pattern)) {
            links.put(pattern, new TreeSet<String>());
         }
         links.get(pattern).add(s);
      }
      words = links.get(getMax(links));
   }
   
   //gets the maximum key by using parameter map links
   //find the key with the max value
   //returns key with max value
   private String getMax(Map<String, Set<String>> links) {
      int maxLength = 0;
      String maxKey = "";
      for(String s : links.keySet()) {
         if(links.get(s).size() > maxLength) {
            maxLength = links.get(s).size();
            maxKey = s;
         }
      }
      return maxKey;
   }
   
   //finds the amount of times a character is in a given pattern
   //takes parameters string pattern, and the char guess
   //returns number of occurrences
   private int matches (String pattern, char guess) {
      int matches = 0;
      for (int i = 0; i < pattern.length(); i++) {
         if(pattern.charAt(i) == guess) {
            matches++;
         }
      }
      return matches;
   }
}
