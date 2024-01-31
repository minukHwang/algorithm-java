/*
 * 풀이방법
 * 1. 2차원 배열 받아오기
 * 2. m*m 크기의 파리채 => m*m 배열단위로 탐색하며 최대합 구하기.
 * 	- n*n안에서 m*m 단위로 탐색을 하게 된다면 기준이 되는 점은 m*m의 [0,0] => 스타트 포인트
 * 	- 스타트 포인트를 [n-m,n-m]까지 이동시키며 탐색해서 최대합 구하기
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] flies = new int[n][n];

			int max = 0;

			// 입력 받아오기
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					flies[r][c] = sc.nextInt();
				}
			}

			// 스타트 포인트를 [0,0]에서 [n-m,n-m]까지 이동시키며 파리채 크기만큼 갯수 탐색
			for (int r = 0; r < n - m + 1; r++) {
				for (int c = 0; c < n - m + 1; c++) {
					int catchNum = flyCatch(flies, r, c, m);

					if (catchNum > max) {
						max = catchNum;
					}
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}

	// 파리채 메소드 만들기
	public static int flyCatch(int[][] map, int startRow, int startCol, int size) {
		int sum = 0;

		// 2차원 배열 안에서 스타트 포인트가 주어지면 파리채의 크기에 맞게 탐색.
		for (int r = startRow; r < startRow + size; r++) {
			for (int c = startCol; c < startCol + size; c++) {
				sum += map[r][c];
			}
		}

		return sum;
	}
}