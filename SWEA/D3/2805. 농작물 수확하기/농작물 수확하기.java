import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();

			int[][] farm = new int[n][n];

			for (int r = 0; r < n; r++) {
				String[] line = sc.next().split("");
				for (int c = 0; c < n; c++) {
					farm[r][c] = Integer.parseInt(line[c]);
				}
			}
			
			int total = 0;
			
			int left = n/2;
			int right = n/2;
			
			for(int r = 0; r < n; r++) {
				for(int c = left; c <= right; c++) {
					total += farm[r][c];
				}
				if(r < n/2) {
					left--;
					right++;
				} else {
					left++;
					right--;
				}
			}

			System.out.printf("#%d %d%n", t, total);
		}
	}

}
