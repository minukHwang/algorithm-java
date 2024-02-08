/*
 * [문제 풀이 과정]
 * 1. 손님의 시간을 큐에 넣어준다.
 * 2. 손님의 시간은 랜덤하게 넣어지기 때문에 정렬을 해준다.
 * 3. 1초 단위로 시간을 변화시키면서 손님이 오면 붕어빵을 제공한다.
 * 	- 만약 붕어빵 제작 시간이 되면 붕어빵 추가하기
 * 	- 손님이 온 시간에 붕어빵이 있으면 제공, 및 손님 pop
 */

import java.util.Scanner;

public class Solution {
	
	static int[] queue;
	static int front;
	static int rear;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			queue = new int[n];
			front = -1;
			rear = -1;
			
			for(int i = 0; i < n; i++) {
				push(sc.nextInt());
			}
			
			// 배열 정렬하기 (삽입 정렬)
			for(int i = 1; i< n; i++) {
				int key = queue[i];

				int j;
				for (j = i - 1; j >= 0 && queue[j] > key; j--) {
					queue[j + 1] = queue[j];
				}

				queue[j + 1] = key;
			}
			
			// 초, 시간 변화
			int second = 0;
			int cooked = 0;
			
			// 0초부터 손님이 모두 올 때까지
			for(int i = 0; i <= queue[n-1]; i++) {
				
				// 만약 m초의 시간이 지난다면
				if(second%m==0 && second != 0) {
					cooked += k;
				}
				
				// 만약 손님이 온다면, 붕어빵이 있을 경우 Pop, 붕어빵 개수 빼주기
				// 손님은 같은 시간에 올 수 있다는 것을 명심
				while(cooked > 0) {
					if(Qpeek()==second) {
						pop();
						cooked--;
					} else {
						break;
					}
				}
			
				// 다음 시간으로 
				second++;
			}
			
			// 출력 
			System.out.printf("#%d %s\n", t, isEmpty()? "Possible":"Impossible");
		}
	}
	
	// 큐 구현하기
	public static void push(int a) {
		if (isFull()) {
			return;
		}
		queue[++rear] = a;
	}

	public static int pop() {
		if (isEmpty()) {
			return 0;
		}
		return queue[++front];
	}

	public static int Qpeek() {
		if (isEmpty()) {
			return 0;
		}
		return queue[front + 1];
	}

	public static boolean isFull() {
		return rear == queue.length;
	}

	public static boolean isEmpty() {
		return front == rear;
	}
}