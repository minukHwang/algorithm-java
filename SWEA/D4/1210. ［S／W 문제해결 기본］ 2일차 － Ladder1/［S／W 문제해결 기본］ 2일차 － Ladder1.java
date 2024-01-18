import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			// 케이스 넘버 받기
			int caseNum = sc.nextInt();

			// 사다리 초기화
			int[][] ladder = new int[100][100];
			int cnt = 0;
			int cnt2 = 0;

			// 라인 위치 찾기 + 사다리 입력
			for (int j = 0; j < 100; j++) {
				ladder[0][j] = sc.nextInt();
				if (ladder[0][j] == 1) {
					cnt++;
				}
			}

			int[] lines = new int[cnt];
			int colIndex = 0;

			for (int i = 1; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();

					if (i == 99) {
						if (ladder[i][j] == 1) {
							lines[cnt2] = j;
							cnt2++;
						} else if (ladder[i][j] == 2) {
							lines[cnt2] = j;
							colIndex = cnt2;
							cnt2++;
						}
					}
				}
			}

			int indexC;
			int indexR = 99;

			for (int i = 0; i < 100; i++) {
				indexC = lines[colIndex];

				if (indexC - 1 >= 0 && ladder[indexR][indexC - 1] == 1) {
					colIndex--;
				} else if (indexC + 1 < 100 && ladder[indexR][indexC + 1] == 1) {
					colIndex++;
				}

				indexR--;
			}

			// 출력
			System.out.printf("#%d %d%n", caseNum, lines[colIndex]);

		}
	}
}
