import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int count = 0;

			for (int c = 0; c < n; c++) {
				boolean isAvailable = false;
				for (int r = 0; r < n; r++) {
					if (map[r][c] == 1) {
						isAvailable = true;
					}

					if (map[r][c] == 2 && isAvailable == true) {
						count++;
						isAvailable = false;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, count);
		}
		
		sc.close();
	}
}
