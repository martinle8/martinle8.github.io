//Martin Le
//Section AJ
//TA:James Hu
//This class creates different HuffmanTrees, can write codes back to an output file
//and can write character sequences given a sequence of codes
import java.util.*;
import java.io.*;
public class HuffmanTree {
	//the root node of the tree
	private HuffmanNode root;
	//map of the characters as keys and their codes as values
	private Map<Character, String> codes = new HashMap<>();
	//the pseudo-end of file int +1 of the highest character with frequency
	//higher than 0
	public int endOfFile;
	
	//Creates a huffman tree, given character frequencies through array count
	public HuffmanTree (int[] count) {
		PriorityQueue<HuffmanNode> pQueue = new PriorityQueue<HuffmanNode>();
		int highestCh = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				highestCh = i;
				char ch = (char)i;
				highestCh = i;
				HuffmanNode temp = new HuffmanNode(ch, count[i], null, null);
				pQueue.add(temp);
			}
		}
		endOfFile = highestCh;
		HuffmanNode eof = new HuffmanNode((char)256, 1, null, null);
		pQueue.add(eof);
		while (pQueue.size() > 1) {
			HuffmanNode current = pQueue.remove();
			HuffmanNode current2 = pQueue.remove();
			HuffmanNode parent = new HuffmanNode('\0', current.freq + current2.freq, current, current2);
			pQueue.add(parent);
		}
		root = pQueue.remove();
	}
	
	//send the root node into a writeHelper method in order
	//to write codes to a PrintStream output
	public void write (PrintStream output) {
		writeHelper(output,"", root);
	}
	
	//takes in a printstream output to write codes to, an initially empty String code
	//representing the huffman code of the character, and the root HuffmanNode
	//puts values into a map then prints them to the output
	private void writeHelper(PrintStream output, String code, HuffmanNode root) {
		if(root == null) {
			return;
		}
		if(root.isLeaf()) {
			output.println((int)root.character);
			output.println(code);
		}
		writeHelper(output, code + "0", root.left);
		writeHelper(output, code + "1", root.right);
	}
	
	public HuffmanTree(Scanner input) {
		Map<Integer, String> codeMap = new HashMap<>();
		while(input.hasNextLine()) {
			int n = Integer.parseInt(input.nextLine());
			String code = input.nextLine();
			codeMap.put(n, code);
		}
		HuffmanNode roots = new HuffmanNode('\0', 0, null, null);
		for(Map.Entry<Integer, String> entry : codeMap.entrySet()) {
			int chara = (int)(entry.getKey());
			char c = (char)chara;
			String code = entry.getValue();
			HuffmanNode currentNode = roots;
			for (int i = 0; i < code.length(); i++) {
				char bit = code.charAt(i);
				if (bit == '0') {
					if (currentNode.left == null) {
						currentNode.left = new HuffmanNode('\0', 0, null, null);
						
					}
					currentNode = currentNode.left;
				} else {
					if (currentNode.right == null) {
						currentNode.right = new HuffmanNode('\0', 0, null, null);
					}
					currentNode = currentNode.right;
				}
			}
			currentNode.character = c;
		}
	}
	
	//takes in BitInputStream input of character codes, a PrintStream output, and the
	//eof pseudo-end-of-file number to know when its reaches the end of the input
	public void decode(BitInputStream input, PrintStream output, int eof){
		eof = endOfFile;
		int bit = input.readBit();
		HuffmanNode current = root;
		HuffmanNode current2 = current;
		if (current2 != null) {
			while (bit == 1 || bit == 0) {
				if(!current2.isLeaf()) {
					if (bit == 0) {
						current2 = current2.left;
					} else {
						current2 = current2.right;
					}
					
				} else {
					int print = (int)current2.character;
					current2 = current;
				}
				bit = input.readBit();
			}
		}
	}
}
