import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			char[][] map = new char[5][15];

			for (int i = 0; i < map.length; i++) {
				char[] letters = sc.next().toCharArray();

				for (int j = 0; j < letters.length; j++) {
					map[i][j] = letters[j];
				}
			}

			String answer = "";
			out: for (int c = 0; c < 15; c++) {
				int nullCount = 0;
				for (int r = 0; r < 5; r++) {
					if (map[r][c] == '\u0000') {
						nullCount++;
						continue;
					}
					answer += map[r][c];
				}
				if (nullCount == 5) {
					break out;
				}
			}

			System.out.printf("#%d %s\n", t, answer);
		}
	}
}
