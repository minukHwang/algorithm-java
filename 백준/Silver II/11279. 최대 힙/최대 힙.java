import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] heap;
	static int heapSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 반복 횟수.
		int n = Integer.parseInt(st.nextToken());

		heap = new int[n + 1];
		heapSize = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 입력받는 숫자.
			int num = Integer.parseInt(st.nextToken());

			if (num == 0) {
				bw.write(heapPop() + "\n");
			} else {
				heapPush(num);
			}
		}

		bw.flush();
	}

	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	public static void heapPush(int num) {
		heap[++heapSize] = num;

		int child = heapSize;
		int parent = child / 2;

		while (parent > 0 && heap[child] > heap[parent]) {
			swap(parent, child);

			child = parent;
			parent = child / 2;
		}

	}

	public static int heapPop() {
		if (heapSize == 0) {
			return 0;
		}

		int popNum = heap[1];
		heap[1] = heap[heapSize--];

		int parent = 1;
		int child = parent * 2;

		if (child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child++;
		}

		while (child <= heapSize && heap[child] > heap[parent]) {
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
