//Martin Le
//Section AJ
//TA: James Hu
public class QuestionNode {
   public String data;
   public QuestionNode left;
   public QuestionNode right;
   
   public QuestionNode(String answer) {
      this(answer, null, null);
   }
   public QuestionNode(String data, QuestionNode left, QuestionNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
}
