
import java.util.*;
import java.awt.*;

public class Husky extends Critter {
    public Husky(){

    }
    
    //returns string of husky
    public String toString(){
        return "o";
    }
   
   //returns color of husky
    public Color getColor(){
        return Color.BLACK;
    }
   
    // returns the move to be made by the lion
    public Action getMove(CritterInfo info){
        double rando = Math.random();
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME){
            return Action.LEFT;
        }else{
            return Action.HOP;
        }
    }
}

