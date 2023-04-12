public class HuffmanNode implements Comparable<HuffmanNode>  {
   public final int freq;
   public char character;
   public HuffmanNode left;
   public HuffmanNode right;   
   
   public HuffmanNode (char character, int freq, HuffmanNode left, HuffmanNode right) {
      this.character = character;
      this.freq = freq;
      this.left = left;
      this.right = right;
   }
   
   
   public int compareTo(HuffmanNode other) {
		return (this.freq - other.freq);
	}     
   
   public boolean isLeaf (){
      return (this.right == null && this.left == null );
   }   
}