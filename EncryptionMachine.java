// Martin Le
// 2.8.2022
// CSE 142 Section AH
// TA: Claris Winston
// Encryption Machine
// Shifts the letters of given word in order to encrypt using class constants
// and user input
import java.util.*;
public class EncryptionMachine {
    public static final int SHIFT = 0;
    public static final String ALPHABET= "abcdefghijklmnopqrstuvwxyz";
    public static final int alphabetLength = ALPHABET.length();
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        intro();
        key(console);
        questions(console);
    }
    
    //prints the introduction statement for user
    public static void intro(){
        System.out.println("Welcome to the CSE142 Encryption Machine!");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
    }
    
    //encrypts the key
    //Parameters: console is getting user input and logs it into string key
    //String encrypted is the encrypted string after using the encrypt method
    public static void key(Scanner console){
        System.out.println("Encrypted messages use a shared keyword to decrypt.");
        System.out.print("  Enter key: ");
        String key = console.next();
        String encrypted = encrypt(key);
        System.out.println("    \"" + key + "\" has been encrypted to: " + encrypted );
        System.out.println();
    }
   
   //Asks the user how many words and encrypts them all into a message
   //Parameters: words is a scanner for user input that goes into int wordcount
   //String word is the user inputted word which is put into the encrypt method
    public static void questions(Scanner words){
        System.out.print("How many words are in your message? ");
        int wordcount = words.nextInt();
        for(int i = 1; i <= wordcount; i++){
            System.out.print("  Next word: ");
            String word = words.next();
            System.out.print("    \"" + word + "\" has been encrypted to: " + encrypt(word));
            System.out.println();   
        }
        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
    
    //this method encrypts the word of choice
    //Parameters: SHIFT is the number that it shifts on the ALPHABET
    public static String encrypt(String key){
        String encrypted = "";
        for(int i = 0; i <= (key.length() - 1); i++){
            char x = key.charAt(i);
            int y = ALPHABET.indexOf(x);
            int z = (y + SHIFT) % alphabetLength;
            char letter = ALPHABET.charAt(z);
            encrypted = encrypted + letter;
        }
        return encrypted;
    }
}
