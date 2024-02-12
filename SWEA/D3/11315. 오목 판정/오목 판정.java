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

					if (map[r][c] == 'o') {
						for (int i = 0; i < 8; i++) {
							int count = 1;

							int indexR = r + deltaR[i];
							int indexC = c + deltaC[i];

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
