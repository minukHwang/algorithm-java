/*
 * [문제 풀이 과정]
 * * 백트래킹 연습
 * 1. 2차원 배열이 아니라 1차원 배열로 퀸 배치 표현 -> 행(Index) 열(값)
 * 2. 한 행에 어짜피 퀸은 한개이므로 한 행에 배치하면 다음 행으로 넘어가서 재귀
 * 3. 재귀를 진행하기 전에 해당 열에 놓을 수 있는지 백트래킹으로 검사 
 * 	- 같은 열에 없는지 확인
 * 	- 대각선에 없는지 확인
 */

import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static int[] queen;
	static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			queen = new int[N];
			total = 0;

			solve(0);

			System.out.println("#" + t + " " + total);
		}
	}

	static void solve(int row) {
		// 기저 조건
		if (row == N) {
			total++;
		}

		// 재귀 케이스
		for (int col = 0; col < N; col++) {
			// 백트래킹 조건이 맞는지 확인하고 해당 부분만 재귀.
			if (isAvailable(row, col)) {
				queen[row] = col;
				solve(row + 1);
			}
		}
	}

	// 백트래킹 조건
	static boolean isAvailable(int row, int col) {
		for (int i = 0; i < row; i++) {
			// 만약 열이 같다면 안됨
			if (queen[i] == col) {
				return false;
			}

			// 만약 대각선에 퀸이 있다면 안됨
			if (Math.abs(row - i) == Math.abs(col - queen[i])) {
				return false;
			}
		}

		// 이 모든 것을 통과해야만 가능
		return true;
	}

}
