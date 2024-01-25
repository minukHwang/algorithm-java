import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x = 0;
		int y = 0;

		int[][] map = new int[100][100];

		// 1. 파일 입출력하면서, 최대 최소 value 받아오기.
		// 2. 색종이가 올라가는 영역을 1로 표시하기.
		for (int t = 0; t < n; t++) {
			x = sc.nextInt();
			y = sc.nextInt();

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		// 2. 100*100맵 탐색 및 계산
		
		int total = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]==1) {
					total += 1;
				}
			}
		}
		
		System.out.println(total);
	}
}