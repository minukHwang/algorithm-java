/*
 * 1. dp[n] = dp[n/3] + 1; // n이 3의 배수라면.
 * 2. dp[n] = dp[n/2] + 1; // n이 2의 배수라면
 * 3. dp[n] = dp[n - 1] + 1;
 * 
 * 위 세개를 비교해서 가장 작은 값을 채워나간다!
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1]; // dp[1] = 0;

		for (int i = 2; i < N + 1; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 3 == 0) {
				// 3의 배수라면
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}

			if (i % 2 == 0) {
				// 2의 배수라면
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}
		
		System.out.println(dp[N]);

	}
}