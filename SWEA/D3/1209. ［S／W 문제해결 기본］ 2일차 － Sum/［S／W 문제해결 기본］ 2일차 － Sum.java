/*
 * 풀이방법
 * 1. 입력 받으면서 가로합 구하기
 * 2. 입력 받으면서 대각선합 구하기
 * 	- 만약 r == c 일때 대각선합
 * 3. 가로합 대각선합 중 최대값 구하기
 * 4. 세로합 구하고 최대값 구하기
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			int caseNum = sc.nextInt();

			int[][] arr = new int[100][100];

			// 행의 합 최대 구하기
			int rowMax = 0;
			int diagonal = 0;
			int max = 0;

			for (int r = 0; r < 100; r++) {
				int sum = 0;

				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
					sum += arr[r][c];

					if (r == c) {
						// 대각선 합 구하기
						diagonal += arr[r][c];
					}
				}

				if (sum > rowMax) {
					rowMax = sum;
				}
			}

			// 최댓값 구하기(가로, 대각선 중)
			max = Math.max(rowMax, diagonal);

			// 열의 합 최대 구하기
			int colMax = 0;

			for (int c = 0; c < 100; c++) {
				int sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += arr[r][c];
				}

				if (sum > colMax) {
					colMax = sum;
				}
			}

			// 최댓값 구하기
			max = Math.max(max, colMax);

			System.out.printf("#%d %d\n", caseNum, max);
		}

		sc.close();
	}
}