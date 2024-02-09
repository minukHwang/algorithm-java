/*
 * [문제 풀이 과정]
 * 1. 큐를 구현하여 8개의 숫자들을 push 한다.
 * 	- 해당 문제에서는 인덱스 넘버만 바꿔서 큐를 구현하면, 계속 반복하며 공간에 채워야하기 때문 공간이 매우 크게 필요하다.
 * 	- 혹은 push를 할 때마다 배열 자체를 다시 복사해서 완벽한 큐를 구현해야한다.
 *  - 원형큐를 사용하는 방법도 있다. => 이게 제일 효율적이다.
 * 2. 하나씩 순차적으로 반복문을 돌리며 문제 조건에 맞게 암호문을 생성한다.
 * 	- for문으로 pop한 요소에서 인덱스를 1씩 증가시키고 5까지 증가시켜서 빼주며 1사이클 완성. 이를 반복!
 * 	- 만약 pop한 요소에서 count를 뺐을 때, 만약 0보다 작아지는 타이밍이 온다면 0을 push하고 반복문 끝내기
 * 3. 출력!
 */

import java.util.Scanner;

public class Solution {
	static int[] queue = new int[9];
	static int front = 0, rear = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			int caseNum = sc.nextInt();
			
			// 원형큐에 8개의 숫자 넣기
			for (int i = 0; i < 8; i++) {
				enQueue(sc.nextInt());
			}
			
			int diff = 1;

			out: while (true) {
				
				// 사이클 반복
				for(int i = 1; i <= 5; i++) {
					diff = deQueue() - i;
					
					// 만약 차이가 0이되는 경우에는 push(0)하고 끝내기
					if (diff <= 0) {
						diff = 0;
						enQueue(diff);
						break out;
					}
					
					enQueue(diff);
				}
			}

			System.out.printf("#%d", caseNum);
			for(int i = 0; i < 8; i++) {
				System.out.printf(" %d", deQueue());
			}
			System.out.println();
		}
	}

	// 원형큐 구현
	public static void enQueue(int data) {
		if (isFull()) {
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}

	public static int deQueue() {
		if (isEmpty()) {
			return 0;
		}
		front = (front + 1) % queue.length;
		return queue[front];
	}

	public static int peek() {

		return queue[(front + 1) % queue.length];
	}

	public static boolean isEmpty() {
		return front == rear;
	}

	public static boolean isFull() {
		return front == (rear + 1) % queue.length;
	}
}