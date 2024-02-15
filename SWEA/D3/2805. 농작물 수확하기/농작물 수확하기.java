/*
 * [문제 풀이 과정]
 * 1. 문자열을 2차원 배열에 입력 받는다.
 * 2. left right 변수를 만들어서 2차원 배열의 c의 중심 index로 초기화를 해준다.
 * 3. r이 중간까지 left는 -- right는 ++
 * 4. 중간 이후로 left는 ++ right는 --
 * 5. 해당 위치를 범위로 2차원 배열에 있는 숫자들을 더해주고 출력.
 */

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
