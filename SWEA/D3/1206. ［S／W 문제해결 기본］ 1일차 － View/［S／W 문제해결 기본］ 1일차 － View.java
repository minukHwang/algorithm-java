import java.util.Scanner;

// [1206. View]

/*
 * 문제 풀이 과정
 * 1. 배열에 입력값들 받아오기.
 * 2. 배열을 탐색하면서 양 옆 2칸 확인하기.
 * 	- 양 옆 두 칸의 높이가 만약 본인 높이보다 작다면 그 차이 만큼은 조망권이 확보된다.
 * 	- 이 중에서 모든 양 옆 2칸이 본인보다 작아야하기 때문에, 겹치는 영역이 조망권 확보 영역이다.
 *  - 겹치는 영역은 차이의 최솟값이다.
 */

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			// 건물 개수 & 조망권
			int n = sc.nextInt();
			int total = 0;
			
			// 배열 만들기
			int[] buildings = new int[n];
			int[] delta = {-2, -1, 1, 2};
			
			// 배열에 입력값 받아오기
			for(int i = 0; i < n; i++) {
				buildings[i] = sc.nextInt();
			}
			
			// 왼쪽 오른쪽 2개(강)을 제외하고 반복 순회
			for(int i = 2; i < n-2; i++) {
				int view = Integer.MAX_VALUE;
				
				for(int j = 0; j < 4; j++) {
					// 양 옆 2칸 탐색
					int index = i + delta[j];
					
					// 양 옆 2칸 차이 활용하기
					int difference = buildings[i] - buildings[index];
					if(difference <= 0) {
						// 만약 차이가 0보다 작으면 조망권 있는 세대 없음
						view = 0;
						break;
					} else {
						// 차이가 0보다 크다면 조망권 있는 세대는 최소의 차이값
						if(view > difference) {
							view = difference;
						}
					}
				}
				total += view;
			}
			
			System.out.printf("#%d %d\n", t, total);
		}
	}
}
