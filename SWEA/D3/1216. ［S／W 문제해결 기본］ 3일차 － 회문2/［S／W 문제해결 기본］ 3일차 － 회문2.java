import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int caseNum = sc.nextInt();

			char[][] map = new char[100][100];

			for (int r = 0; r < 100; r++) {
				map[r] = sc.next().toCharArray();
			}

			int maxCount = 0;

			// 짝수 행
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 99; c++) {
					if (map[r][c] == map[r][c + 1]) {
						int count = 0;
						count += 2;
						int left = c - 1;
						int right = c + 2;

						while (left >= 0 && right < 100 && map[r][left] == map[r][right]) {
							count += 2;
							left--;
							right++;
						}

						if (count > maxCount) {
							maxCount = count;
						}
					}
				}
			}

			// 홀수 행
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 98; c++) {

					if (map[r][c] == map[r][c + 2]) {
						int count = 0;
						count += 3;
						int left = c - 1;
						int right = c + 3;

						while (left >= 0 && right < 100 && map[r][left] == map[r][right]) {
							count += 2;
							left--;
							right++;
						}

						if (count > maxCount) {
							maxCount = count;
						}
					}

				}
			}

			// 짝수 열
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 99; r++) {
					if (map[r][c] == map[r + 1][c]) {
						int count = 0;
						count += 2;
						int top = r - 1;
						int bottom = r + 2;

						while (top >= 0 && bottom < 100 && map[top][c] == map[bottom][c]) {
							count += 2;
							top--;
							bottom++;
						}

						if (count > maxCount) {
							maxCount = count;
						}
					}
				}
			}

			// 홀수 열
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 98; r++) {
					if (map[r][c] == map[r + 2][c]) {
						int count = 0;
						count += 3;
						int top = r - 1;
						int bottom = r + 3;

						while (top >= 0 && bottom < 100 && map[top][c] == map[bottom][c]) {
							count += 2;
							top--;
							bottom++;
						}

						if (count > maxCount) {
							maxCount = count;
						}
					}
				}
			}

			System.out.printf("#%d %d\n", caseNum, maxCount);
		}
	}
}