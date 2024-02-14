import java.util.Arrays;
import java.util.Scanner;

class Node {
	String data;
	int num;
	Node left;
	Node right;
	
	Node(){
		
	}
	
	Node(String data){
		this.data = data;
	}
	
}

public class Solution {
	static Node[] nodes = new Node[100+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t <= 10; t++) {			
			int N = sc.nextInt();
			sc.nextLine();
			
			for(int i=1; i < N+1; i++) {
				nodes[i] = new Node();
			}
			
			for (int i = 1; i < N+1; i++) {
				String[] str = sc.nextLine().split(" ");
				
				nodes[i].num = Integer.parseInt(str[0]);
				nodes[i].data = str[1];
				
				for(int j = 2; j < str.length; j++) {
					if(nodes[i].left == null) {
						nodes[i].left = nodes[Integer.parseInt(str[j])];
					} else {
						nodes[i].right = nodes[Integer.parseInt(str[j])];
					}
				}
			}
			
			System.out.printf("#%d ", t);
			inorder(nodes[1]);
			System.out.println();
		}
	}
	
	//LVR
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	}
}
