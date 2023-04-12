import java.util.*;
import java.io.*;
//Martin Le
//Section AJ
//TA: James Hu
//This program creates a question binary QuestionTree
//and allows for the new branches and leaves through
//a user game. incomplete 
public class QuestionTree {
   private Scanner console = new Scanner(System.in);
   private QuestionNode overallRoot;
   
   public QuestionTree() {
      overallRoot = new QuestionNode("computer");
   }
   
   public void write(PrintStream output) {
      write(output, overallRoot);
   }
   
   private void write(PrintStream output, QuestionNode root) {
      if (root.left == null && root.right == null) {
         System.out.print("A:\n" + root.data);
      }else{
         System.out.print("Q:\n" + root.data);
         write(output, root.left);
         write(output, root.right);
      }
   }
   
   public void read(Scanner input) {
      overallRoot = readHelper(input);
      
   }
   
   private QuestionNode readHelper(Scanner input) {
      QuestionNode product = new QuestionNode(null);
      return product;
         
  }       

         // post: asks the user a question, forcing an answer of "y" or "n";
   //       returns true if the answer was yes, returns false otherwise
   public boolean yesTo(String prompt) {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
      while (!response.equals("y") && !response.equals("n")) {
         System.out.println("Please answer y or n.");
         System.out.print(prompt + " (y/n)? ");
         response = console.nextLine().trim().toLowerCase();
      }
      return response.equals("y");
   }
   
   public void askQuestions() {
      overallRoot = game(overallRoot);
   }
   
   private QuestionNode game(QuestionNode root) {
      if (root.left == null && root.right == null) {
         if(yesTo("Would your object happen to be " + root.data + "?")) {
            System.out.println("Great, I got it right!");
         }else{
            root = userAdd(root);
         }
      }
      return root;
   }
   
   private QuestionNode userAdd (QuestionNode root) {
      QuestionNode e = new QuestionNode(null);
      System.out.print("What is the name of your object? ");
      QuestionNode answer = new QuestionNode (console.nextLine());
      System.out.print("Please give me a yes/no question that\n" + "distinguishes between your object\n" + "and mine--> ");
      String q = console.nextLine();
      if(yesTo("And what is the answer for your object?" )) {
          e = new QuestionNode(q, answer, root);
      }else{
         e = new QuestionNode(q, root, answer);
      }
      return e;  
   }
}
