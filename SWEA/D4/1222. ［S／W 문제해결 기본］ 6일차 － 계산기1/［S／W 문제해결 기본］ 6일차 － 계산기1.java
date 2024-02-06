/*
 * 문제 풀이 과정
 * 1. 스택 구현하기 -> 자료형 char, int 두가지
 * 2. 후위 표기식 만들기
 * 	- 만약 피연산자가 나오면 문자열에 추가
 * 	- 만약 연산자 +가 나오면 스택이 비어있을 경우 문자형 스택에 push, 스택에 다른 연산자가 있다면
 *    스택에 아무것도 없을 때까지 pop해서 문자열에 추가하고 스택에 push
 * 3. 완성된 후위 표기식을 탐색하면서 연산
 * 	- 만약 피연산자가 나온다면 정수형 스택에 push
 *  - 만약 + 연산자가 나온다면 스택에서 정수 2개를 뽑아서 연산 후 해당 값 push
 * 4. 출력하기
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			// 처음에는 char 스택으로 초기화 (연산자를 스택하기 때문)
			// 연산자가 + 밖에 없기 때문에 1칸이면 충분하지만,
			// 후에 int 스택을 위해서 2칸으로 초기화
			charStack = new char[2];
			top = -1;

			int length = sc.nextInt();
			String input = sc.next();
			String postfix = "";

			for (int i = 0; i < length; i++) {
				char letter = input.charAt(i);

				// 만약 피연산자라면
				if (letter >= '0' && letter <= '9') {
					// 문자열에 바로 추가
					postfix += letter;

					// 만약 연산자라면
				} else if (letter == '+') {
					// 비워져 있으면 연산자 push
					if (isEmpty()) {
						pushChar(letter);

						// 만약 안 비워져 있다면,
					} else {
						// 비워질 때까지 pop해서 문자열에 추가하고 push
						while (!isEmpty()) {
							postfix += popChar();
						}
						pushChar(letter);
					}
				}
			}

			// stack에 하나 남은 연산자도 추가해주기.
			postfix += popChar();

			// 정수형 Stack 만들기
			intStack = new int[2];
			top = -1;

			// postfix 탐색
			for (int i = 0; i < postfix.length(); i++) {
				char letter = postfix.charAt(i);

				// 만약 연산자라면
				if (letter == '+') {
					// 숫자 두개 뽑아서 연산하고 push
					int second = popInt();
					int first = popInt();

					pushInt(first + second);
				} else {
					// 그 외 숫자들이라면 바로 push
					pushInt(letter - '0');
				}
			}

			System.out.printf("#%d %d\n", t, popInt());

		}

	}

	// 문자 스택 구현
	static int top;
	static char[] charStack;

	public static void pushChar(char a) {
		if (isFull()) {
			return;
		}
		charStack[++top] = a;
	}

	public static char popChar() {
		if (isEmpty()) {
			return '\u0000';
		}
		char result = charStack[top];
		charStack[top--] = '\u0000';
		return result;
	}

	// 숫자 스택 구현
	static int[] intStack;

	public static void pushInt(int a) {
		if (isFull()) {
			return;
		}
		intStack[++top] = a;
	}

	public static int popInt() {
		if (isEmpty()) {
			return 0;
		}
		int result = intStack[top];
		intStack[top--] = 0;
		return result;
	}

	// isEmpty, isFull
	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		// 둘이 길이 똑같이 해줄 것이기 때문에 그냥 하나로 통일.
		return top == charStack.length - 1;
	}
}