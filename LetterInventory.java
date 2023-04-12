//Martin Le
//Section AJ
//TA:James Hu
//This program measures and records the number of each letter in a word
public class LetterInventory {
   private int[] elementData; //list of integar count for letters
   private int size; //total number of letters in each inventory
   
   //counts and stores the number of each alphabetic character
   //paramaters:
   //String data is the string from which we're creating
   //an inventory for
   public LetterInventory(String data) {
      elementData = new int[26];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         char test = data.charAt(i);
         int charToInt = test;
         if(charToInt >= 97 && charToInt <= 122) {
            elementData[charToInt - 97]++;
            size++;
         }
      }
   }
   
   //returns the total number of letters in an inventory
   public int size() {
      return size;
   }
   
   //returns ture if there are no letters in an inventory
   public boolean isEmpty() {
      if (size == 0) {
         return true;
      }
      return false;
   }
   
   //returns the number of occurencences of one letter from an inventory
   //parameters:
   //char letter is the character we're trying to find the count for
   //will throw an illegalarugmentexeption if the given character is not
   //in the alphabet
   public int get(char letter) {
      int charToInt= letter;
      if (!isLetter(charToInt)) {
         throw new IllegalArgumentException();
      }
      if (charToInt >= 65 && charToInt <= 90) {
         charToInt += 32;
      }
      return elementData[charToInt - 97];
   }
   
   //converts the inventory into a text form in alphabetical
   //order surrounded by brackets
   //returns this new string
   public String toString() {
      String answer = "[";
      for (int i = 0; i < elementData.length; i++) {
         int value = elementData[i];
         if (value > 0) {
            int indexToChar = i + 97;
            char intToChar = (char)indexToChar;
            for (int x = 0; x < value; x++) {
               answer  = answer + intToChar;
            }
         }
      }
      return answer  + "]";
   }
   
   //returns true if the given character is alphabetical
   //Parameters
   //int test is the integar value of the character we're
   //trying to figure out if it is alphabetical or not
   private boolean isLetter(int test) {
      if ((test >= 122 && test <= 97) || (test >= 90 && test<= 65)) {
         return false;
      }
      return true;
   }
   
   //sets the count of a letter to a value in an inventory
   //parameters:
   //char letter is the letter's count that we are manipulating
   //int value is the value that replaces what the orginal value of
   //char letter was
   //will throw an illegalarugmentexeption if the given character is not
   //in the alphabet
   public void set(char letter, int value) {
      int charToInt = letter;
      if (!isLetter(charToInt)|| value < 0) {
         throw new IllegalArgumentException();
      }
      if (charToInt < 97) {
         charToInt+=32;
      }
      size-=elementData[charToInt - 97];
      elementData[charToInt - 97] = value;
      size+=elementData[charToInt - 97];
   }
   
   //returns a new LetterInventory where the counts for each letter are the
   //sums of the counts of that letter for this LetterInventory and other
   //Letter Inventory
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      sum.size = this.size + other.size;
      for (int i = 0; i < 26; i++) {
         int value = this.elementData[i] + other.elementData[i];
         sum.elementData[i] = value;
      }
      return sum;
   }
   
   //returns a new LetterInventory where the counts for each letter is the
   //difference between the counts of that letter for this LetterInventory
   //and other LetterInventory
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory diff = new LetterInventory("");
      int diffSize = 0;
      for (int i = 0; i < 26; i++) {
         int value = this.elementData[i] - other.elementData[i];
         if (value >= 0) {
            diff.elementData[i] = value;
            diffSize += value;
         }else{
            return null;
         }
      }
      diff.size = diffSize;
      return diff;
   }
}