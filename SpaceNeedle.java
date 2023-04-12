// Martin Le
// 1.28.2022
// CSE 142 Section AH
// TA: Claris Winston
// Space Needle
// Prints a design of the space needle using keyboard characters
// uses class constant "SIZE" to determine the size of the space needle
// uses loops to draw
public class SpaceNeedle {
    public static final int SIZE = 4;
    public static void main(String[] args){
        point(); 
        hat();
        valley();
        point();
        beam();
        hat();
    }
    
    //Prints the point of the space needle using loops
    public static void point(){
        for(int i = 1; i <= SIZE; i++){ 
            for(int pointSpace = 1; pointSpace <= SIZE * 3; pointSpace++){
                System.out.print(" ");
            }
            System.out.println("||");
        }        
    }

    //Prints the top half of the "building part" of the space needle using loops
    public static void hat(){
        for(int i = 1; i <=SIZE ; i++){
            for(int hatSpace = 1; hatSpace <= i * (-3) + (SIZE * 3); hatSpace++){
                System.out.print(" ");
            }
            System.out.print("__/"); 
            for(int hatDot = 1; hatDot <= i * 3 - 3; hatDot++){
                System.out.print(":");
            }
            System.out.print("||");
            for(int hatDot = 1; hatDot <= i * 3 - 3; hatDot++){
                System.out.print(":");
            }            
            System.out.println("\\__");            
        }
        breakLine();    
    }

    //Prints the breakline using loops
    public static void breakLine(){
        System.out.print("|");
        for(int i = 1; i <= SIZE * 6; i++){
            System.out.print("\"");
        }
        System.out.println("|");
    }

    //Prints the valley shaped "building part" of the space needle using loops
    public static void valley(){
        for(int i = 1; i <=SIZE ; i++){
            for(int valleySpace = 1; valleySpace <= i * 2 - 2; valleySpace++){
                System.out.print(" ");
            }
            System.out.print("\\_");
            for(int valleyHat = 1; valleyHat <= (i * (-2)) + SIZE * 3 + 1; valleyHat++){
                System.out.print("/\\");
            }
            System.out.println("_/");
        }        
    }

    //Prints the straight beam of the space needle where the
    //elevator would go up using loops
    public static void beam(){
        for(int i = 1; i <= SIZE * SIZE; i++){
            for(int beamSpace = 1; beamSpace <= SIZE * 2 + 1; beamSpace++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int beamDesign = 1; beamDesign <= SIZE - 2; beamDesign++){
                System.out.print("%");
            }
            System.out.print("||");
            for(int beamDesign = 1; beamDesign <= SIZE - 2; beamDesign++){
                System.out.print("%");
            }            
            System.out.println("|");
        }
    }
}
