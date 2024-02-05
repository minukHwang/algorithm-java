import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();

			stack = new char[n / 2];
			top = -1;

			String input = sc.next();

			out: for (int i = 0; i < n; i++) {
				char letter = input.charAt(i);
				if (letter == '(' || letter == '[' || letter == '{' || letter == '<') {
					push(letter);
					continue;
				}

				switch (letter) {
				case ')':
					if (peek() == '(')
						pop();
					else {
						break out;
					}

					break;

				case ']':
					if (peek() == '[')
						pop();
					else {
						break out;
					}

					break;

				case '}':
					if (peek() == '{')
						pop();
					else {
						break out;
					}

					break;

				case '>':
					if (peek() == '<')
						pop();
					else {
						break out;
					}

					break;
					

				}

			}
			
			System.out.printf("#%d %d\n", t, isEmpty()? 1 : 0);

		}
	}

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