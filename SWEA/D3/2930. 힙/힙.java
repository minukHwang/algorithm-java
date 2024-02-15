import java.util.Scanner;

public class Solution {

	static int[] heap;
	static int heapSize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			// StringBuilder로 출력할 문자열 append
			sb.append("#").append(t);

			// 연산 몇번 할 것인지.
			int n = sc.nextInt();

			// heap 초기화
			// 연산을 n번하면 n번 추가될 가능성이 있으니 n+1
			// heapSize도 매번 초기화 해주기.
			heap = new int[n+1];
			heapSize = 0;

			for (int i = 0; i < n; i++) {
				int cal = sc.nextInt();

				if (cal == 1) {
					int num = sc.nextInt();
					heapPush(num);

				} else if (cal == 2) {
					int returnNum = heapPop();
					sb.append(" ").append(returnNum);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	public static void heapPush(int num) {
		heap[++heapSize] = num;

		int child = heapSize;
		int parent = heapSize / 2;

		while (parent > 0 && heap[parent] < heap[child]) {
			swap(parent, child);

			child = parent;
			parent = child / 2;
		}
	}

	public static int heapPop() {
		if (heapSize == 0) {
			return -1;
		}

		int popNum = heap[1];
		heap[1] = heap[heapSize--];

		int parent = 1;
		int child = parent * 2;

		if (child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child++;
		}

		// 리프 노드일 경우 종료 && 자식이 작다면 종료
		while (child <= heapSize && heap[parent] < heap[child]) {
			
			swap(parent, child);

			parent = child;
			child = parent * 2;
			
			if (child + 1 <= heapSize && heap[child] < heap[child + 1]) {
				child++;
			}
		}

		return popNum;
	}
}