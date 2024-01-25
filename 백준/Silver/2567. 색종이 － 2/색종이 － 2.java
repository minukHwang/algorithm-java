import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x = 0;
		int y = 0;

		// * 가장자리까지 계산하기 위해서 상하좌우 1칸씩 늘려서 생성.
		int[][] map = new int[102][102]; 

		// 1. 파일 입출력하면서, 최대 최소 value 받아오기.
		// 2. 색종이가 올라가는 영역을 1로 표시하기.
		for (int t = 0; t < n; t++) {
			x = sc.nextInt() + 1;
			y = sc.nextInt() + 1;

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		// 3. 사방 탐색을 위한 준비.
		int[] deltaRow = { -1, 1, 0, 0 };
		int[] deltaCol = { 0, 0, -1, 1 };
		int totalLength = 0;

		// 4. 100*100맵 탐색 및 계산
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (map[i][j] == 0) {
					for (int d = 0; d < 4; d++) {
						int indexR = i + deltaRow[d];
						int indexC = j + deltaCol[d];
						
						//  5. 만약 위치가 0인데, 상하좌우에 1이 있으면 해당 부분은 가장자리이기 때문에 1을 더한다.
						if (indexR >= 0 && indexR < 102 && indexC >= 0 && indexC < 102) {
							if (map[indexR][indexC] == 1) {
								totalLength++;
							}
						}
					}
				}
			}
		}
		
		System.out.println(totalLength);
	}
}