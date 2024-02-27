import java.util.Arrays;

/*
 * [문제 풀이 과정]
 * - 식재료드을 각각 N/2개씩 나누어서 요리를 한다고 하였으니 전체 N개 중에 N/2의 조합을 구하는 문제
 * 1. 조합 구하기 
 */

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] cook;
	static boolean[] selected;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cook = new int[N][N];
			selected = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cook[r][c] = sc.nextInt();
				}
			}

			getMinDiff(0, 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}

	// 조합 구하기
	public static void getMinDiff(int index, int depth) {
		// 기저 조건
		if (depth == (N / 2)) {
			int foodA = 0;
			int foodB = 0;

			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					for (int j = 0; j < N; j++) {
						if (j != i && selected[j]) {
							foodA += cook[i][j];
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (j != i && !selected[j]) {
							foodB += cook[i][j];
						}
					}
				}
			}

			int diff = Math.abs(foodA - foodB);

			if (min > diff) {
				min = diff;
			}
			return;
		}

		for (int i = index; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				getMinDiff(i + 1, depth + 1);
				selected[i] = false;
			}
		}

	}

}