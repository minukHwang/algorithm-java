
/*
 * [문제 풀이 과정]
 * - 부분집합을 구하는 재귀를 만들어서 푸는 문제
 * 	- 한 직원을 선택하고, 선택하지 않는 과정을 수행
 * 	- 만약 N명의 직원을 모두 고려했다면, 최소 합을 구하기.
 * 		- 단, 만약 B보다 작다면 리턴	
 * 		- 만약 B보다 크다면 최소 합으로 갱신 
 *	- 재귀 수행 시 최소의 합보다 넘겨받은 합이 더 커진다면, 백트래킹 가지치기.
 */

import java.util.Scanner;

public class Solution {
	static int T, N, B, S;
	static int[] height;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];

			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
				S += height[i];
			}

			min = S;
			
			getMin(0, 0);
			
			sb.append(min - B).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void getMin(int idx, int sum) {
		// 가지치기
		if(sum > min) {
			return;
		}
		
		if (idx == N) {
			// 합이 작으면 조건에 안맞음 리턴.
			if(sum < B) {
				return;
			}
			
			// 최소의 값 갱신
			min = Math.min(min, sum);
			return;
		}

		getMin(idx + 1, sum + height[idx]); // 선택함
		getMin(idx + 1, sum); // 선택 안함
	}
}
