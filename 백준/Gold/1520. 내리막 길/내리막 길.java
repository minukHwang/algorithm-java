// DP로 풀어야한다!

import java.util.Scanner;

public class Main {
	static int M, N;
	static int map[][];
	static int dp[][];

	static int[] deltaR = { 1, 0, 0, -1 };
	static int[] deltaC = { 0, 1, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		dp = new int[M][N];

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				dp[r][c] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	public static int dfs(int r, int c) {
		// 기저 조건
		if (r == M - 1 && c == N - 1) {
			return 1;
		}
		
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		dp[r][c] = 0;

		// 재귀 조건
		for (int i = 0; i < 4; i++) {
			int nextR = r + deltaR[i];
			int nextC = c + deltaC[i];

			// 범위 안에 있고, 만약 나보다 낮다고 하면.
			if (isNotOutBound(nextR, nextC) && map[r][c] > map[nextR][nextC]) {
				dp[r][c] += dfs(nextR, nextC);
			}
		}
		
		return dp[r][c];

	}

	public static boolean isNotOutBound(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
}
