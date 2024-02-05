/*
 * 문제 풀이 과정
 * 1. Stack 구현하기
 * 2. 문자열을 받아드린다.
 * 3. () 레이저를 X로 치환한다.
 * 4. 반복문을 통해서 String의 문자에 따라 조건을 적용한다.
 * 	- 만약 '('가 나타난다면 막대기가 추가되는 것으로 stack에 막대기 개수 1을 push한다.
 * 	- 만약 'X'가 나타난다면 레이저이므로 stack이 비어있지 않다면, 막대기 개수들에게 1씩 더해준다.
 * 	- 만약 ')'가 나타난다면 막대기가 끝나는 것으로 stack에서 해당 막대기 개수를 pop해서 개수에 더해준다.
 * 5. 결과값 출력하기.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			// 좀 더 수월하게 문제 해결을 위해 레이저를 X로 치환.
			String str = sc.next().replace("()", "X");
			
			// 최악의 수를 생각한다면, 레이저가 하나이고 쇠막대기들로 string이 이루어질 수 있다.
			// 따라서 스택에 최대로 쌓일 수 있는 수는 문자열의 길이 / 2 - 1(레이저)
			// 아래와 같이 스택 초기화를 진행.
			stack = new int[str.length()/2-1];
			top = -1;
			
			// range는 스택의 막대기가 쌓였을 경우 해당 요소에만 1을 더하기 위해서 누적한다.
			// count는 최종 출력값을 담을 변수.
			int range = 0;
			int count = 0;
			
			for(int i = 0; i < str.length(); i++) {
				
				switch(str.charAt(i)) {
				
				// 만약 X면 레이저
				case 'X':
					// 비어있다면 아무것도 하지 않는다.
					if(isEmpty())
						break;
					// 비어있지 않다면 스택의 막대기 개수들에 1씩 더해준다.
					else
						for(int j = 0; j < range; j++) {
							stack[j]++;
						}
					break;
					
				// 막대기 시작
				case '(':
					// 막대기 개수를 추가
					push(1);
					// 막대기가 추가되면 추후에 레이저를 만났을 때 탐색 범위를 최소화하기 위해서 반영해주기.
					range++;
					break;
					
				case ')':
					// 막대기 개수 빼주기
					count += pop();
					// 막대기가 빠지게되면 추후에 레이저를 만났을 때 탐색 범위를 최소화하기 위해서 반영해주기.
					range--;
					break;
				}
			}
			
			System.out.printf("#%d %d\n", t, count);
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