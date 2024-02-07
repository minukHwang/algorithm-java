import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] count = new int[N + M + 1];

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					count[i + j]++;
				}
			}

			Queue queue = new Queue(N + M + 1);

			int max = 0;
			
			for (int i = 2; i < N + M + 1; i++) {
				if(max < count[i]) {
					max = count[i];
				}
			}
			
			for (int i = 2; i < N + M + 1; i++) {
				if(count[i]==max) {
					queue.push(i);
				}
			}
			
			System.out.printf("#%d",t);
			while(queue.Qpeek()!=0) {
				System.out.printf(" %d", queue.pop());
			}
			System.out.println();

		}
	}

	public static class Queue {

		int[] queue;
		int length;
		int front = -1, rear = -1;

		public Queue() {

		}

		public Queue(int length) {
			this.length = length;
			this.queue = new int[length];

		}

		public void push(int a) {
			if (isFull()) {
				return;
			}
			queue[++rear] = a;
		}

		public int pop() {
			if (isEmpty()) {
				return 0;
			}
			return queue[++front];
		}

		public int Qpeek() {
			return queue[front + 1];
		}

		public boolean isFull() {
			return rear == queue.length;
		}

		public boolean isEmpty() {
			return front == rear;
		}

		@Override
		public String toString() {
			return Arrays.toString(queue);
		}
	}
}