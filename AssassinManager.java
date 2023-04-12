import java.util.*;
public class AssassinManager {
  private AssassinNode killRing;
  private AssassinNode graveyard;
   
   public AssassinManager (List<String> names) {
      if (names.isEmpty()) {
         throw new IllegalArgumentException();
      } 
         this.killRing = new AssassinNode(names.get(0));
         AssassinNode current = killRing;
         for (int i = 1; i < names.size(); i++) {
            current.next = new AssassinNode(names.get(i));
            current = current.next;
         }    
   }
  
   public void printKillRing() {
      AssassinNode current = this.killRing;
      if (current.next == null) {
         System.out.print("    " + current.name + " is stalking " + current.name);
      }else{
         AssassinNode front = this.killRing;
         while(current.next != null) {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;   
         }
         AssassinNode end = current;
         System.out.println("    " + end.name + " is stalking " + front.name); 
      }      
   }
   
   public void printGraveyard() {
      AssassinNode current = this.graveyard;
      while (current != null) {
         System.out.println("    " + current.name + " was killed by " + current.killer);
         current = current.next;
      }
   }
   
   public boolean killRingContains(String name) {
      AssassinNode current = this.killRing;
      if (gameOver() && name.equalsIgnoreCase(current.name)) {
         return true;
      }
      while(current != null) {
         if (name.equalsIgnoreCase(current.name)) {
            return true;
         }else {
            current = current.next;
         }
      }
      return false;
   }   
   
   public boolean graveyardContains(String name) {
      AssassinNode current = this.graveyard;
      if (current != null) {
         if (current.next != null){
            while (current.next != null) {
               String test = current.name;
               if (test.equalsIgnoreCase(name)) {
                  return true;
               }
               current = current.next;
            } 
         }
         String test = current.name;
         if (test.equalsIgnoreCase(name)) {
                  return true;
         }            
      }
      return false;
   }
   
   public boolean gameOver() {
      return killRing.next == null;
   }
   
   public String winner() {
      if (gameOver()){
         return killRing.name;
      }
         return null;
   }
   
   public void kill(String name) {
      if(gameOver()){
         throw new IllegalStateException();
      }
      if (!killRingContains (name)) {
         throw new IllegalArgumentException();
      }
      AssassinNode current = killRing;
      AssassinNode temp = killRing;
      while (current.next != null) {
         if (name.equalsIgnoreCase(current.next.name)) {
            temp = current.next;
            temp.killer = current.name;
            current.next = current.next.next;
            temp.next = this.graveyard;
            this.graveyard = temp;
         }else{
            current = current.next;
         }
      }    
    if(name.equalsIgnoreCase(this.killRing.name)) {
      temp = this.killRing;
      this.killRing = this.killRing.next;
      temp.next = this.graveyard;
      this.graveyard = temp;
      this.graveyard.killer = current.name;
    }
      
   }
}