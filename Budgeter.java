// Martin Le
// 2.11.2022
// CSE 142 Section AH
// TA: Claris Winston
// Budgeter
// Takes user inputted income and expenses and calculates
// What kind of person the user is (spender/saver)
import java.util.*;
public class Budgeter {
   public static final int DAYS_IN_MONTH = 31;
   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
      intro();
      results(console);
   }
   
   //Prints introduction statement
   public static void intro(){
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   //Gets income categories and finds total income for the month
   //using total method
   //Parameters: scanner income for user input and stores in categories
   public static double income(Scanner income) {
      String incomeCat = "income";
      double totalIncome= total(income, incomeCat);
      System.out.println();
      return totalIncome;
   }
   
   //Gets expense type using user input from
   //scanner expensetype and returns int expenseKind
   public static int expenseType(Scanner expenseType){
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int expenseKind = expenseType.nextInt();
      return expenseKind;
   }
   
   //uses int expenseKind from expenseType method for
   //int expenseType and calculates the total expense using total method
   //modifies double totalExpense based on expenseType and returns that value
   public static double expenseAmount(Scanner expenseAmount, int expenseType){
      String expense = "expense";
      double totalExpense = total(expenseAmount, expense);
      if (expenseType == 2){
         totalExpense = totalExpense * DAYS_IN_MONTH ;
      }
      return totalExpense;
   }
   
   //finds either total income or expenses by using a string since
   //they are the same formula and both reuquire categories
   //in a loop then returns total
   public static double total(Scanner console, String type){
      System.out.print("How many categories of " + type + "? ");
      int categories = console.nextInt();
      double total = 0.0;
      for (int i = 1; i <= categories; i++){
         System.out.print("    Next " + type + " amount? $");
         total = total + console.nextDouble();
      }
      return total;
   }
   
   //takes the totalIncome from income method and daily
   //and total expense from expenseAmount method
   //uses parameter of expenseType to determine
   //daily income using DAYS_IN_MONTH constant
   //then prints final income and expense numbers
   public static void results(Scanner console) {
      double finalIncome = roundNumber(income(console));
      double dailyIncome = roundNumber(finalIncome / DAYS_IN_MONTH );
      double expenseTotal = expenseAmount(console, expenseType(console));
      double dailyExpense = roundNumber(expenseTotal / DAYS_IN_MONTH );
      System.out.println();
      System.out.println("Total income = $" + finalIncome + " ($" + dailyIncome + "/day)");
      System.out.println("Total expenses = $" + roundNumber(expenseTotal) +
            " ($" + dailyExpense + "/day)");
      System.out.println();
      resultsTwo(finalIncome, expenseTotal);
   }
   
   //takes results from results method and
   //compares the expense and income totals
   //to determine whether user is spender or saver
   public static void resultsTwo(double finalIncome, double expenseTotal){
      if(finalIncome < expenseTotal || finalIncome == expenseTotal){
         double difference = roundNumber(expenseTotal - finalIncome);
         System.out.println("You spent $" + (difference) + " more than you earned this month.");
         if (difference < 250 || difference == 0){
            System.out.println("You're a spender.");
            System.out.println("Do you're thing booboo!");
         }else{
            System.out.println("You're a big spender.");
            System.out.println("Better save more money next month!");
         }
      }else if (finalIncome > expenseTotal){
         double profit = roundNumber(finalIncome - expenseTotal);
         System.out.println("You earned $" + (profit) + " more than you spent this month.");
         if (profit <= 250){
            System.out.println("You're a saver.");
            System.out.println("Nice! Extra cash for the future!");
         }else{
            System.out.println("You're a big saver.");
            System.out.println("Sigh, wish I could be like you.");
         }
      }
   }
   
   //Rounds a number to the nearest hundreth for money purposes
   public static double roundNumber(double number) {
      return (Math.round(number * 100)) / 100.0;
   }
}
