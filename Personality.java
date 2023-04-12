// Martin Le
// 3/1/2021
// CSE142
// TA: Claris Winston
// Personality
// This program takes a user inputted file and breaks down a text file
//to determine response statistics and uses the statistics to print to a user inputted
//output file stats and a final "personality type"
import java.util.*;
import java.io.*;
public class Personality {
	public static final int DIMENSIONS = 4;
	//not sure if I should comment this but this gets the input file and output file
	//name and breaks it into line by line by using a while loops
	//when length of line is not 70 it means its a line with a mame so it prints to the output file
	//when length of line IS 70 then it while do the count method
	public static void main(String[] args)throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		intro();
		System.out.print("input file name? ");
		String inputFile = console.nextLine();
		System.out.print("output file name? ");
		String outputFile = console.nextLine();
		PrintStream output = new PrintStream(new File(outputFile));
		console = new Scanner(new File(inputFile));
		while(console.hasNextLine()){
			String line = console.nextLine();
			if(line.length() != 70){
				output.print(line + ": ");
			}else{
				count(line, output);
			}
		}
	}
	
	//this method prints the inro message to the console
	public static void intro(){
		System.out.println("This program processes a file of answers to the");
		System.out.println("Keirsey Temperament Sorter. It converts the");
		System.out.println("various A and B answers for each person into");
		System.out.println("a sequence of B-percentages and then into a");
		System.out.println("four-letter personality type.");
		System.out.println();
	}
	
	//this method counts the amount of A and B responses from the file
	//it reads the file line by line from the string line and printstreams to output
	//which is the output file from user input. It tallies everytime there is an A or B
	//after sending it to wrapup method it prints it back into printsteam output
	//it also breaks it down line by line from string line we get from main
	public static void count (String line, PrintStream output){
		int[] countA = new int [DIMENSIONS];
		int[] countB = new int [DIMENSIONS];
		line = line.toLowerCase();
		for(int i = 1; i <= 10; i++){
			int question = ((i * 7) - 7);
			if(line.charAt(question) == 'a'){
				countA[0]++;
			}else if(line.charAt(question) == 'b'){
				countB[0]++;
			}
			for(int y = 1; y < DIMENSIONS; y++){
				for(int u = 1; u <= 2; u++){
					question++;
					if(line.charAt(question) == 'a'){
						countA[y]++;
					}else if(line.charAt(question) == 'b'){
						countB[y]++;
					}
				}
			}
		}
		output.println(wrapup(countA, countB));
	}
	
	//this method uses the int countA and countB in order to determine persolaity type
	//using conditionals and for loops it returns the string wrapup
	//which is the percentages in each DIMENSION as well as the final personality type
	public static String wrapup(int countA[], int countB[]){
		String wrapup = "[";
		String personality;
		int[] percentB = new int[DIMENSIONS];
		for(int i = 0; i < DIMENSIONS; i++){
			double a = ((double)countA[i]);
			double b = ((double)countB[i]);
			double percent = ((b / (a + b)) * 100);
			percent = Math.round(percent);
			int finalPercent = ((int)percent);
			percentB[i] = finalPercent;
		}
		wrapup = wrapup + percentB[0] + ", " +
			percentB[1] + ", " + percentB[2] + ", " + percentB[3] + "] = ";
		if(percentB[0] > 50){
			personality = "I";
		}else if (percentB[0] == 50){
			personality = "X";
		}else{
			personality = "E";
		}
		if(percentB[1] > 50){
			personality = personality + "N";
		}else if(percentB[1] == 50){
			personality = personality + "X";
		}else{
			personality = personality + "S";
		}
		if(percentB[2] > 50){
			personality = personality + "F";
		}else if (percentB[2] == 50) {
			personality = personality + "X";
		}else{
			personality = personality + "T";
		}
		if(percentB[3] > 50){
			personality = personality + "P";
		}else if(percentB[3] == 50) {
			personality = personality + "X";
		}else{
			personality = personality + "J";
		}
		wrapup = wrapup + personality;
		return wrapup;
	}
}
