/*
 * [문제 풀이 과정]
 * * 델타 탐색을 하면 되는 문제
 * 1. 문자열을 받아서 2차원 배열에 할당한다.
 * 2. 2차원 배열을 탐색하면서 만약 o를 만나게 된다면 해당 위치에서 8방 탐색을 진행한다.
 * 3. 8방 중 한 방향으로 계속 탐색하면서 5개를 연달아서 o를 발견하게 된다면 오목 판정 YES
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();

			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				map[i] = sc.next().toCharArray();
			}

			// 8방 탐색
			int[] deltaR = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] deltaC = { 0, 0, -1, 1, -1, 1, -1, 1 };

			boolean isAvailable = false;

			out: for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {

					// 만약 o를 발견한다면
					if (map[r][c] == 'o') {
						for (int i = 0; i < 8; i++) {
							// 오목 판정을 위한 카운트
							int count = 1;

							int indexR = r + deltaR[i];
							int indexC = c + deltaC[i];

							// 범위 안에 있을 때까지 한 방향으로 카운트가 5가 되는지 확인
							while (indexR >= 0 && indexR < n && indexC >= 0 && indexC < n) {

								if (map[indexR][indexC] == 'o') {
									count++;
									if (count >= 5) {
										isAvailable = true;
										break out;
									}
								} else {
									break;
								}

								indexR += deltaR[i];
								indexC += deltaC[i];
							}
						}
					}
				}
			}

			System.out.printf("#%d %s\n", t, isAvailable ? "YES" : "NO");

		}
	}
}
