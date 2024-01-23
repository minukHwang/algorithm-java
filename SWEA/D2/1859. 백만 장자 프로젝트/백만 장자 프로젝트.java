import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			long[] arr = new long[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			long maxPoint = arr[n - 1];
			long profit = 0;
			for (int i = n - 2; i >= 0; i--) {
				if (maxPoint > arr[i]) {
					profit += maxPoint - arr[i];
				} else {
					maxPoint = arr[i];
				}
			}
			
			System.out.printf("#%d %d%n",t,profit);
		}
	}
}