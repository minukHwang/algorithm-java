import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String str = sc.next().replace("()", "X");
			
			// 최악의 수를 생각한다면, 레이저가 하나이고 쇠막대기들로 string이 이루어질 수 있다.
			stack = new int[str.length()/2-1];
			top = -1;
			
			int count = 0;
			int total = 0;
			
			for(int i = 0; i < str.length(); i++) {
				
				switch(str.charAt(i)) {
				
				case 'X':
					if(isEmpty())
						break;
					else
						for(int j = 0; j < count; j++) {
							stack[j]++;
						}
					break;
					
				case '(':
					push(1);
					count++;
					break;
					
				case ')':
					total += pop();
					count--;
					break;
				}
			}
			
			System.out.printf("#%d %d\n", t, total);
		}
	}
	
	static int[] stack;
	static int top;
	
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