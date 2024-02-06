/*
 * 문제 풀이 과정
 * 1. 스택 자료 구조 구현
 * 2. 연산자의 우선순위 할당 (맵 사용) => '(' << '+' '-' << '*' '/'
 * 3. 입력을 받아서 postfix를 만든다.
 *    *String 스택 활용
 *    1) '(' 연산자가 나오면 무조건 스택에 넣는다.
 *    2) '+' '*'  연산자가 나오면 스택의 마지막 요소의 우선순위가 만약 본인보다 낮거나 같다면 스택에 push
 *    	 만약 본인보다 우선순위가 높다면 우선순위가 낮은 요소가 등장할 때까지 pop해서 postfix에 붙여준다.
 *    3) ')' 연산자가 나오면 '('이 나올때 까지 pop해서 postfix에 넣어준다.
 *    4) 피연산자가 나오면 무조건 postfix에 넣어준다.
 * 4.만들어진 postfix를 탐색하며 연산을 처리한다.
 *    *Integer 스택 활용
 *    1) 피연산자를 만나면 스택에 push
 *    2) 만약 연산자를 만나면 스택에서 숫자를 두개 pop, 연산을 처리하고 다시 스택에 push
 *    3) 모든 과정이 끝난다면 마지막 남은 숫자를 pop해서 출력
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> priority = new HashMap<>();

		priority.put('(', 0);
		priority.put('+', 1);
		// priority.put('-', 1);
		priority.put('*', 2);
		// priority.put('/', 2);

		for (int t = 1; t <= 10; t++) {

			// postfix 만들기
			int length = sc.nextInt();
			String str = sc.next();

			String postfix = "";
			ArrayStack<Character> stack = new ArrayStack<Character>(length);

			for (int i = 0; i < length; i++) {
				char letter = str.charAt(i);

				if (letter == '(') {
					// 여는 괄호는 다 스택에 넣어줌
					stack.push(letter);
				} else if (letter == ')') {
					// 닫는 괄호는 여는 괄호 나올 때까지 pop
					while (stack.peek() != '(') {
						postfix += stack.pop();
					}

					// 마지막에 남는 괄호 버리기
					stack.pop();
				} else if (letter >= '0' && letter <= '9') {
					// 숫자들은 모두 postfix로 넣어줌
					postfix += letter;
				} else {
					// +, -, *, /
					if (stack.isEmpty()) {
						stack.push(letter);
					} else {
						// 우선순위가 낮은 연산자가 마지막에 위치할 때까지 pop
						while (!stack.isEmpty() && priority.get(letter) <= priority.get(stack.peek())) {
							postfix += stack.pop();
						}

						stack.push(letter);
					}
				}
			}

			// 마지막이 괄호가 아닌 경우는 한번 pop해서 남은 연산자 빼주기
			if (!stack.isEmpty()) {
				postfix += stack.pop();
			}

			// 숫자 담을 정수형 스택 생성
			ArrayStack<Integer> stack2 = new ArrayStack<Integer>(length);

			// postfix 탐색하면서 연산 처리하기.
			for (int i = 0; i < postfix.length(); i++) {
				char letter = postfix.charAt(i);

				if (letter >= '0' && letter <= '9') {
					// 만약 피연산자면 push
					stack2.push(letter - '0');
				} else {
					// 만약 연산자면 숫자 2개 pop해서 연산처리 후 push
					int second = stack2.pop();
					int first = stack2.pop();

					switch (letter) {
					case '+':
						stack2.push(first + second);
						break;

					case '*':
						stack2.push(first * second);
						break;

					// 사실 문제에서는 + *만 한다고 했으니 생략
//					case '-':
//						stack2.push(first - second);
//						break;

//					case '/':
//						stack2.push(first / second);
//						break;
					}
				}
			}

			// 스택에 마지막 남은 숫자를 pop해서 출력
			System.out.printf("#%d %d \n", t, stack2.pop());
		}
		sc.close();
	}

	// 내부 클래스로 선언 static으로 접근해야함
	public static class ArrayStack<E> {
		private E[] arr;
		private int top;
		private int length;

		public ArrayStack() {
		}

		public ArrayStack(int length) {
			this.arr = (E[]) new Object[length];
			this.top = -1;
			this.length = length;
		}

		public boolean isEmpty() {
			return top == -1;
		}

		public boolean isFull() {
			return top == arr.length - 1;
		}

		public void push(E e) {
			if (isFull()) {
				return;
			}
			arr[++top] = e;
		}

		public E peek() {
			if (isEmpty()) {
				return null;
			}
			return arr[top];
		}

		public E pop() {
			if (isEmpty()) {
				return null;
			}
			E result = arr[top];
			arr[top--] = null;
			return result;
		}

		@Override
		public String toString() {
			return Arrays.toString(arr);
		}

	}
}