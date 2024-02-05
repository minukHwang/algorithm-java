/*
 * 문제 풀이 과정
 * 1. Stack 구현!
 * 	- push, pop, isEmpty, isFull
 * 	- top static 변수로 설정하여 해당 위치에 따라 스택 배열의 메소드들이 구현되도록 한다.
 * 	- push : 배열 요소에 할당, top 위로.
 * 	- pop : 배열 요소 초기화, top 아래로.
 * 2. 테스트케이스별로 스택을 초기화하여 생성하고, 만약 0이 아닌 숫자면 push, 0면 pop
 * 3. 최종적으로 스택에 남은 요소들을 다 합한다.
 */

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int k = sc.nextInt();
			
			// 스택 초기화. 중요!!!!
			stack = new int[k];
			top = -1;
			
			for(int i = 0; i < k; i++) {
				int input = sc.nextInt();
				// 0이 아니면 push
				if(input != 0) {
					push(input);
				// 0이면 pop
				} else {
					pop();
				}
			}
			
			int sum = 0;
			
			// 스택에 남은 숫자 모두 합해주기.
			for(int i = 0; i < k; i++) {
				sum += stack[i];
			}
			
			System.out.printf("#%d %d\n", t, sum);
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