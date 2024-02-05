/*
 * 문제 풀이 과정
 * 1. 스택을 구현한다.
 * 2. 여는 괄호일 경우 스택에 push
 * 3. 닫는 괄호인 경우 스택의 마지막 요소를 비교한다.
 * 	- 닫는 요소가 나오는 시점에서는 무조건 해당 요소와 짝이되는 여는 괄호가 나와야한다. 만약에 아니라면 바로 false
 *  - 닫는 요소가 여는 요소와 짝이지어진다면, pop
 *  - 만약 스택이 비워져 있는데, 닫는 요소가 나온다면 이 또한 괄호가 짝지어진 것이 아니기 때문에 바로 false
 * 4. 만약 모든 조건을 통과하고 생성된 스택이 비워져있지 않다면 여는 요소가 더 많은 것이기 때문에 false
 * 5. 비워져 있다면 모두 짝지어진 것이기 때문에 true!
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();

			// 최악의 경우의 수를 고려하여 모두 여는 괄호일 경우는 배열이 n 크기가 필요하다.
			stack = new char[n];
			top = -1;

			String input = sc.next();
			boolean answer = true;

			out: for (int i = 0; i < n; i++) {
				char letter = input.charAt(i);
				
				// 만약 여는 괄호라면 push!
				if (letter == '(' || letter == '[' || letter == '{' || letter == '<') {
					push(letter);
					continue;
				}

				// 닫는 괄호는 케이스가 여러개이기 때문에 스위치문 활용
				switch (letter) {
				case ')':
					// 본인과 짝이되는 요소가 스택의 마지막에 있어야된다.
					// 만약 같다면 pop
					if (peek() == '(')
						pop();
					
					// 만약 비워져 있다면 짝이 안지어지기 때문에 (닫는 괄호가 많아짐)
					// 바로 false
					else if(isEmpty()) {
						answer = false;
						break out;
					}
					
					// 만약 그 외 다른 괄호가 나온다면
					// 서로 짝이 안맞아서 false
					else {
						answer = false;
						break out;
					}

					break;

				case ']':
					if (peek() == '[')
						pop();
					else if(isEmpty()) {
						answer = false;
						break out;
					}
					else {
						answer = false;
						break out;
					}

					break;

				case '}':
					if (peek() == '{')
						pop();
					else if(isEmpty()) {
						answer = false;
						break out;
					}
					else {
						answer = false;
						break out;
					}

					break;

				case '>':
					if (peek() == '<')
						pop();
					else if(isEmpty()) {
						answer = false;
						break out;
					}
					else {
						answer = false;
						break out;
					}

					break;
					

				}

			}
			
			// 만약 비워져 있지 않다면 false
			if(!isEmpty()) {
				answer = false;
			}
			
			System.out.printf("#%d %d\n", t, answer? 1 : 0);

		}
	}

	// 스택 구현
	static char[] stack;
	static int top;

	public static void push(char a) {
		if (isFull()) {
			return;
		}
		stack[++top] = a;
	}

	public static char pop() {
		if (isEmpty()) {
			return '\u0000';
		}
		char result = stack[top];
		stack[top--] = '\u0000';
		return result;
	}

	// 마지막 요소를 확인하기 위해서 peek도 구현
	public static char peek() {
		return stack[top];
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}
}