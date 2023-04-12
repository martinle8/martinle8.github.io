import java.util.*;
import java.awt.*;

public class Bear extends Critter {
    //private variables to track steps and polar or not
    private int count;
    private boolean polar;
    public Bear(boolean polar){
        this.count = 0;
        this.polar = polar;
    }

    //returns color of bear
    public Color getColor(){
        if(this.polar) {
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }

    //returns string value of bear
    public String toString(){
        if(count % 2 == 0){
            return "/";
        }else{
            return "\\";
        }
    }
    
    // returns the move to be made by the bear
    public Action getMove(CritterInfo info){
        this.count = this.count + 1;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return Action.LEFT;
        }
    }
}










