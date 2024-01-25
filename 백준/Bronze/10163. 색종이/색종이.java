/*
 * <풀이방법>
 * 1. 1001*1001의 2차원 배열을 만들어준다.
 * 2. 각 좌표들을 받아서 종이의 인덱스에 따라서 숫자를 바꿔준다.
 * 3. 전체를 다시 조회해서 개수를 셀 때 최대한 적은 범위를 탐색하기 위해서 0~1001이 아닌 최소x,y ~ 최대 x,y로 범위로 조회
 * 4. 출력하면 끝!
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[1001][1001];
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		int index = 1;

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int width = sc.nextInt() + x;
			int height = sc.nextInt() + y;

			if (x < minX)
				minX = x;
			if (y < minY)
				minY = y;
			if (width > maxX)
				maxX = width;
			if (height > maxY)
				maxY = height;

			for (int r = y; r < height; r++) {
				for (int c = x; c < width; c++) {
					map[r][c] = index;
				}
			}

			index++;
		}

		int[] counts = new int[n];

		for (int r = minY; r < maxY; r++) {
			for (int c = minX; c < maxX; c++) {
				for (int i = 1; i <= n; i++) {
					if (map[r][c] == i) {
						counts[i-1] += 1;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(counts[i]);
		}
	}
}
