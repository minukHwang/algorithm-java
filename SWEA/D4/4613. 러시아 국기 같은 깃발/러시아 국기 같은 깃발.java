import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			char[][] map = new char[N][M];
			int[][] counts = new int[3][N];

			for (int r = 0; r < N; r++) {
				char[] str = sc.next().toCharArray();
				for (int c = 0; c < M; c++) {
					map[r][c] = str[c];
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					switch (map[r][c]) {
					case 'W':
						counts[0][r]++;
						break;
					case 'B':
						counts[1][r]++;
						break;
					case 'R':
						counts[2][r]++;
						break;
					}
				}
			}

			int minCount = Integer.MAX_VALUE;
			// for문 지옥으로 풀어보기...
			// 추후에 백트래킹으로 다시 풀어볼게요...

			for (int i = 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {

					int sum = 0;
					for (int w = 0; w < i; w++) {
						sum += M - counts[0][w];
					}

					for (int b = i; b < j; b++) {
						sum += M - counts[1][b];
					}

					for (int r = j; r < N; r++) {
						sum += M - counts[2][r];
					}

					if (minCount > sum) {
						minCount = sum;
					}

				}
			}

			System.out.printf("#%d %d\n", t, minCount);

		}

	}
}
