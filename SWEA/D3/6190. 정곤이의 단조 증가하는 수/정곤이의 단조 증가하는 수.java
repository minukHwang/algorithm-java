import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			PriorityQueue<Integer> numbers = new PriorityQueue<>((a, b) -> {
				return b - a;
			});

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					char[] num = Integer.toString(arr[i] * arr[j]).toCharArray();
					int idx = 0;
					boolean isAvailable = true;

					while (idx < num.length - 1) {
						if (num[idx] > num[idx + 1]) {

							isAvailable = false;
							break;
						}

						idx++;
					}

					if (isAvailable) {
						numbers.add(arr[i] * arr[j]);
					}
				}
			}
			System.out.printf("#%d %d\n", t, numbers.isEmpty()? -1 :numbers.poll());
		}

	}
}
