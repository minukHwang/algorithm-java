import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];

		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < M+1; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for(int r = 1; r < N+1; r++) {
			for(int c = 1; c < M+1; c++) {
				dp[r][c] = Math.max(dp[r-1][c], Math.max(dp[r][c-1], dp[r-1][c-1])) + map[r][c];
			}
		}
		System.out.println(dp[N][M]);
		
	}
}
