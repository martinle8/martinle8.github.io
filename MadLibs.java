import java.io.*;
import java.util.*;

public class MadLibs {
	public static void main(String args[])throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		boolean nextGame = true;
		intro();
		while(nextGame == true){
			choice(console);
		}
	}
	
	public static void intro(){
		System.out.println("Welcome to the game of Mad Libs.");
		System.out.println("I will ask you to provide various words");
		System.out.println("and phrases to fill in a story.");
		System.out.println("The result will be written to an output file.");
		System.out.println();
	}
	
	public static boolean choice(Scanner console)throws FileNotFoundException{
		int choice = 0;
		System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
		String option = console.nextLine();
		while(!option.equalsIgnoreCase("q")){
			if(option.equalsIgnoreCase("v")){
				choice = 1;
				getFile(console, choice);
				return true;
				
			}
			if(option.equalsIgnoreCase("c")){
				getFile(console, choice);
				return true;
			}
			if(option.equalsIgnoreCase("q")){
				return false;
			}else{
				System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
				option = console.nextLine();
			}
		}
		return true;
	}
	
	public static void getFile(Scanner console, int option)throws FileNotFoundException{
		System.out.print("Input file name: ");
		String inputFile = console.nextLine();
		File input = new File(inputFile);
		while(!input.exists()){
			System.out.print("File not found. Try again: ");
			inputFile = console.next();
		}	
		if(option == 1){
			view(input);
		}else{
			System.out.print("Output file name: ");
			String outputFile = console.nextLine();
			File output = new File(outputFile);
			PrintStream out = new PrintStream(output);
			Scanner readFile = new Scanner(inputFile);
			create(output, input, console);
		}
		
		
	}
	
	public static void view(File input)throws FileNotFoundException{
		Scanner inputter = new Scanner((input));
		System.out.println();
		while(inputter.hasNextLine()){
			String token = inputter.nextLine();
			System.out.println(token);
		}
		System.out.println();
	}
	
	public static void create(File output, File input, Scanner console)throws FileNotFoundException{
		Scanner inputFile = new Scanner(input);
		PrintStream out = new PrintStream(output);
		while(inputFile.hasNext()){
			String word = inputFile.next();
			if(word.charAt(0) == '<' & word.charAt(word.length() - 1) == '>'){
				char intital = word.charAt(1);
				String character = "" + intital;
				String identity = identifier(character);
				word = word.replaceAll("-", " ");
				word = word.substring(1, word.length() - 2);
				System.out.print("Please type" + identity + word + ":");
				String outter = console.next();
				out.print(outter + " ");
			}else{
				out.print(word + " ");
			}
		}
	}

	public static String identifier(String character){
		String decider;
		if(character.equalsIgnoreCase("U") || character.equalsIgnoreCase("A") || character.equalsIgnoreCase("O") || character.equalsIgnoreCase("E") || character.equalsIgnoreCase("I")){
				decider = " an ";
				return decider;
		}
			decider = " a ";
			return decider;
	}
	
}



