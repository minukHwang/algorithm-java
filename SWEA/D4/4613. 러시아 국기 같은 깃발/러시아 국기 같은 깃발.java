/*
 * [문제 풀이 과정]
 * 1. 깃발에 대한 정보 받아오기
 * 2. 파란색의 시작점을 1~N-1까지, 빨간색의 시작점을 파란색 시작점 + 1 ~ 끝 - 1로 하여 반복문 탐색하기 
 * 	- 분절점을 완점 탐색해서 조합을 구하면 문제 해결 가능.
 * 3. 각각의 분절에 맞게 깃발을 탐색하며, 더 칠해야하는 부분 카운트
 * 4. 최소값을 비교하며 찾기.
 * 5. 출력
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 깃발 정보 입력
			char[][] flag = new char[N][M];

			for (int r = 0; r < N; r++) {
				char[] str = sc.next().toCharArray();
				for (int c = 0; c < M; c++) {
					flag[r][c] = str[c];
				}
			}

			// 최소를 구하는 문제이므로 처음에 큰 값을 넣어주어야한다.
			// 문제의 최악의 케이스는 모든 색을 바꾸는 것이니, row*col+1로 설정
			int minCount = N * M + 1;

			
			for (int blueStart = 1; blueStart < N - 1; blueStart++) {
				for (int redStart = blueStart + 1; redStart < N; redStart++) {

					int count = 0;
					
					// 흰색: 칠해야하는 칸 계산
					for (int whiteRow = 0; whiteRow < blueStart; whiteRow++) {
						for (int col = 0; col < M; col++) {
							if (flag[whiteRow][col] != 'W') {
								count++;
							}
						}
					}

					// 파란색: 칠해야하는 칸 계산
					for (int blueRow = blueStart; blueRow < redStart; blueRow++) {
						for (int col = 0; col < M; col++) {
							if (flag[blueRow][col] != 'B') {
								count++;
							}
						}
					}

					// 빨간색: 칠해야하는 칸 계산
					for (int redRow = redStart; redRow < N; redRow++) {
						for (int col = 0; col < M; col++) {
							if (flag[redRow][col] != 'R') {
								count++;
							}
						}
					}

					if (count < minCount) {
						minCount = count;
					}

				}
			}

			System.out.printf("#%d %d\n", t, minCount);

		}
	}
}
