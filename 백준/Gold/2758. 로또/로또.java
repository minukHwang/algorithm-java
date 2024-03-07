import java.util.Scanner;

public class Main {
	static int T, N, M;
	static long[][] memoization;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			memoization = new long[N + 1][M + 1];

			// 초기화 해주기
			// 0으로 알아서 되는데 -1로 해주는 이유 -> 결과값으로 0은 나올 수 있지만 -1은 아예 안나오기 때문에.
			for (int index = 0; index < N + 1; index++) {
				for (int last = 0; last < M + 1; last++) {
					if (last == 0) {
						continue;
					}

					if (index == 1) {
						memoization[index][last] = last;
						continue;
					}

					memoization[index][last] = -1;
				}
			}

			long count = lotto(N, M);

			System.out.println(count);
		}
	}

	public static long lotto(int index, int last) {
		if (memoization[index][last] == -1) {
			memoization[index][last] = lotto(index - 1, last / 2) + lotto(index, last - 1);
		}

		return memoization[index][last];
	}
}
