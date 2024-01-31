/*
 * 풀이 방법
 * 1. 배열 크기를 입력 받고 초기화한다.
 * 2. 델타 탐색 배열을 만든다.
 * 	- 델타 탐색 배열은 달팽이가 회전하며 이동하는 방향 순서대로 만든다. (우, 하, 좌, 상)
 * 3. 만약 배열 밖을 나가거나 이미 숫자가 채워진 경우는 방향을 바꿔준다. 
 * 	- 방향을 바꿔주는 것은 % 연산자를 활용하여 델타 배열이 반복해서 사용될 수 있도록 한다.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();

			int[][] snail = new int[n][n];

			// 델타 배열 만들어주기 (우, 하, 좌, 상)
			int[] deltaRow = { 0, 1, 0, -1 };
			int[] deltaCol = { 1, 0, -1, 0 };

			// 스타트 포인트 + 초기 방향 설정.
			int rowIndex = 0;
			int colIndex = 0;
			int direction = 0;

			int count = 0;

			while (count < n * n) {
				snail[rowIndex][colIndex] = ++count;

				// 다음 이동 좌표 적합성 확인
				int tempR = rowIndex + deltaRow[direction];
				int tempC = colIndex + deltaCol[direction];

				// 다음 이동 좌표에 이미 숫자가 있거나 범위가 아닌 경우는 방향을 바꿔준다.
				// 여기서 &&의 순서가 중요하다. 단축 평가가 일어나도록 해야함
				// index에 들어가는 숫자가 범위 밖일 수 있기 때문에 범위 조건을 먼저!
				if (!(tempR >= 0 && tempR < n && tempC >= 0 && tempC < n && snail[tempR][tempC] == 0)) {
					direction += 1;
					direction %= 4;
				}

				// 적합성 확인이 끝났다면 다음 좌표로 이동시키기
				rowIndex += deltaRow[direction];
				colIndex += deltaCol[direction];
			}

			System.out.printf("#%d\n", t);
			printArr(snail);
		}
		sc.close();
	}

	// 출력 메소드
	public static void printArr(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				if (c == arr.length - 1) {
					System.out.print(arr[r][c]);
					break;
				}
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}