import java.util.ArrayList;
import java.util.List;

/*
 * 문제 풀이 과정
 * 1. 사다리 정보 입력 받기
 * 	- 입력 받을 때, 기둥의 위치들을 배열에 저장한다.
 *  - 예) 10010101 이렇게 되어 있다면 -> [0,3,5,7] 이렇게 정보를 담는 리스트 형성
 * 2. 2의 위치를 알아내고 해당 기둥의 위치를 기점으로 2차원 배열의 위로 올라가며 왼쪽 혹은 오른쪽에 1이 있는지 확인한다.
 * 3. 만약 1이 있다면 기둥 정보 배열의 인덱스를 바꿔 준다.
 * 	- 예) 10010102 이렇게 되어 있었다면 -> 기둥 [0,3,5,7]이고 처음 기둥 index는 4 -> 만약 왼쪽에 1이 있으면 3으로 이동
 * 4. 위의 과정을 반복하여 맨 위까지 올라왔을 때 기둥 배열에서 인덱스가 가르키고 있는 위치를 파악한다.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			int caseNum = sc.nextInt();

			// 사다리 배열
			int[][] ladder = new int[100][100];
			// 사다리 기둥 정보 배열
			List<Integer> columns = new ArrayList<>();
			// 사다리 기둥 정보 배열의 인덱스
			int colIndex = 0;

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();

					// 마지막 행에서 사다리 기둥 위치 정보를 받는다.
					if (r == 99) {
						switch (ladder[r][c]) {
						// 만약 1이라면 기둥의 위치 추가
						// 만약 2라면 기둥의 정보 배열의 집중 포인트인 colIndex를 2의 위치로 초기화 및 추가.
						case 1:
							columns.add(c);
							break;
						case 2:
							colIndex = columns.size();
							columns.add(c);
							break;
						}
					}
				}
			}

			// 100단계 올라가면서 초기 위치 알아내기
			int step = 99;
			int left;
			int right;

			while (step >= 0) {
				// 왼쪽 오른쪽 탐색
				left = columns.get(colIndex) - 1;
				right = columns.get(colIndex) + 1;

				// 만약 기둥이 0번째가 아니고, 왼쪽에 1이 있다면
				// 기둥이 0번째면 어짜피 왼쪽은 볼 필요가 없다.
				if (colIndex > 0 && ladder[step][left] == 1) {
					// 기둥이 있는 위치를 본인보다 왼쪽으로 옮겨준다.
					colIndex--;
					// 만약 기둥이 마지막이 아니고, 오른족에 1이 있다면
					// 마찬가지로 기둥이 마지막에 있으면 오른쪽은 볼 필요가 없다.
				} else if (colIndex < columns.size() - 1 && ladder[step][right] == 1) {
					// 기둥이 있는 위치를 본인보다 오른쪽으로 옮겨준다.
					colIndex++;
				}

				step--;
			}

			System.out.printf("#%d %d\n", caseNum, columns.get(colIndex));
		}

		sc.close();
	}
}