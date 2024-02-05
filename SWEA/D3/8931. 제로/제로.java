import java.util.Scanner;

public class Solution {
	
	static int[] stack;
	static int top;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int k = sc.nextInt();
			
			stack = new int[k];
			top = -1;
			
			for(int i = 0; i < k; i++) {
				int input = sc.nextInt();
				if(input != 0) {
					push(input);
				} else {
					pop();
				}
			}
			
			int sum = 0;
			
			for(int i = 0; i < k; i++) {
				sum += stack[i];
			}
			
			System.out.printf("#%d %d\n", t, sum);
		}
	}
	
	
	public static void push(int a) {
		if(isFull()) {
			return;
		}
		stack[++top] = a;
	}
	
	public static int pop() {
		if(isEmpty()) {
			return 0;
		}
		int result = stack[top];
		stack[top--] = 0;
		return result;
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stack.length -1;
	}
}