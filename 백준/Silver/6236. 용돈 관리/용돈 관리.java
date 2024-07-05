import java.util.*;

public class Main {
	static int N, M;
	static int[] cash;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		cash = new int[N];

		for (int i = 0; i < N; i++) {
			cash[i] = sc.nextInt();
		}

		System.out.println(getMinCash());
	}

	public static int getMinCash() {
		int left = 0;
		int right = N * 10000;
		int minCash = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if(isAvailableCount(mid)) {
				minCash = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return minCash;
	}

	public static boolean isAvailableCount(int K) {
		int count = 1;
		int currentCash = K;

		for (int i = 0; i < N; i++) {
			if(cash[i] > K) return false;
			
			if (currentCash < cash[i]) {
				if(count == M) return false;
				count++;
				currentCash = K;
			}

			currentCash -= cash[i];
		}

		return true;
	}
}
