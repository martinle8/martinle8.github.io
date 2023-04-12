// Martin Le
// 2.11.2022
// CSE 142 Section AH
// TA: Claris Winston
// Song
// Prints a song with a custom sixth verse
// Uses methods to eliminate redundancy
public class Song {
    public static void main(String[] args){
        parOne();
        parTwo();
        parThree();
        parFour();
        parFive();
        parSix();
        outro();
    }
    
    //Prints the first paragraph and using the lastTwo method to end
    public static void parOne(){
        System.out.println("There was an old woman who swallowed a fly.");
        lastTwo();
    }

    //Prints the second paragraph and using the lastThree method to end 
     public static void parTwo(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        lastThree();
    }
    
    //Prints the third paragraph and using the lastFour method to end 
    public static void parThree(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        lastFour();
    }
    
    ////Prints the fourth paragraph and using the lastFive method to end 
    public static void parFour(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        lastFive();
    }
   
   //Prints the fifth paragraph and using the lastSix method to end 
    public static void parFive(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        lastSix();
    }
    
    //Prints the sixth paragraph and using the lastSix method to end 
    public static void parSix(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a Snake,");
        System.out.println("Instead of steak she chose a snake.");
        System.out.println("She swallowed the snake to catch the dog,");
        lastSix();
    }
   
   //Prints the outro
    public static void outro(){
        System.out.println();
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }                   
   
   //Prints the last two lines of verses
    public static void lastTwo(){
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
    }
   
   //Prints the last three lines of verses
    public static void lastThree(){
        System.out.println("She swallowed the spider to catch the fly,");
        lastTwo();
    }
    
    //Prints the last four lines of verses
    public static void lastFour(){
        System.out.println("She swallowed the bird to catch the spider,");
        lastThree();
    }
    
    //Prints the last five lines of verses
    public static void lastFive(){
        System.out.println("She swallowed the cat to catch the bird,");
        lastFour();
    }
   
   //Prints the last six lines of verses
    public static void lastSix(){
        System.out.println("She swallowed the dog to catch the cat,");
        lastFive();
    }  
}
