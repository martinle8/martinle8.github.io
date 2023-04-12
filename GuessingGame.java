// Martin Le
// 2/9/2021
// CSE142
// TA: Claris Winston
// Guessing Game
// This program will play a guessing game with the user asking the user to guess numbers
// between 1 and the class constatnt range and computes the users overall score and best game
import java.util.*;
public class GuessingGame {
   public static final int MAX_VALUE = 100;
   public static void main (String[] args) {
      Random r = new Random();
      Scanner console = new Scanner(System.in);
      intro();
      results(console, r);
   }
   
   //this method outputs the introduction to the program
   public static void intro() {
      System.out.println("Hi there, how are you?");
      System.out.println("Let's play my favorite game!");
      System.out.println("It's super simple!");
     // System.out.println("<< your haiku intro message here >>");
      //System.out.println("<< your haiku intro message here >>");
      //System.out.println("<< your haiku intro message here >>");
      System.out.println();
   }
   
   //this method allows you to play one single game
   public static int singleGame(Scanner console, Random r) {
      
      System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
      //int guess = 101;
      int answer = r.nextInt(MAX_VALUE) + 1;
      //System.out.print(answer);
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int tries = 1;
      while(guess != answer){
         if(guess < answer){
            System.out.println("It's higher.");
         }else if(guess > answer){
            System.out.println("It's lower.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
         tries++;
      }
      if (tries == 1) {
         System.out.println("You got it right in " + tries + " guess!");
      } else {
         System.out.println("You got it right in " + tries + " guesses!");
      }
      return tries;
   }
   
   //this method uses while loops to constantly get user interface and output the overall results
   public static void results(Scanner console, Random r) {
      int totalGames = 1;
      int totalGuesses = singleGame(console, r);
      int bestGame = totalGuesses;
      int ex = 2;
      while (ex == 2) {
         System.out.print("Do you want to play again? ");
         String a = console.next();;
         if (a.startsWith("y") || a.startsWith("Y")) {
            System.out.println();
            totalGames++;
            int currentGame = singleGame(console, r);
            if (currentGame < bestGame) {
               bestGame = currentGame;
            }
            totalGuesses = totalGuesses + currentGame;
         } else {
            ex = 5;
            double finalGuess = totalGuesses;
            double finalGames = totalGames;
            double division = (finalGuess / finalGames);
            double finalScore = round (division);
            System.out.println();
            System.out.println("Overall results:");
            System.out.println("Total games   = " + totalGames);
            System.out.println("Total guesses = " + totalGuesses);
            System.out.println("Guesses/game  = " + finalScore);
            System.out.println("Best game     = " + bestGame);
         }         
      }
   }
   
   // this method rounds any number I need
   public static double round (double x) {
      return (Math.round(x * 10)) / 10.0;
   }
}
