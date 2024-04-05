/*
 * dp에는 최대의 점수 값을 갱신
 * dp[0] = 0;
 * dp[1] = stairs[1];
 * dp[2] = stairs[2] + stairs[1]; // 무조건 2를 밟는다
 * dp[3] = stairs[3] + dp[1], stairs[3] + stairs[1] + dp[0]
 * dp[4] = stairs[4] + dp[2], stairs[4] + stairs[3] + dp[1]
 * dp[5] = stairs[5] + dp[3], stairs[5] + stairs[4] + dp[2]
 * ...
 * dp[n] = stairs[n] + dp[n-2], stairs[n] + stairs[n-1] + dp[n-3] 중 최대의 값으로 갱신
 * (n번째를 밟는 경우와 n번째를 안 밟는 두 경우 비교)
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] stairs = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			stairs[i] = sc.nextInt();
		}

		int[] dp = new int[N + 1];

		for (int n = 1; n < N + 1; n++) {
			if(n == 1) {
				dp[1] = stairs[1];
				continue;
			}
			
			if(n == 2) {
				dp[2] = stairs[2] + stairs[1];
				continue;
			}
			
			dp[n] = Math.max(stairs[n] + dp[n - 2], stairs[n] + stairs[n - 1] + dp[n - 3]);
		}

		System.out.println(dp[N]);
	}
}
