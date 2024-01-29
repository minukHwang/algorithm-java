import java.util.Arrays;

/*
 * 문제 풀이 과정
 * 1. 입력 받아오기
 * 2. 어짜피 박스의 최상단이 낙차가 가장 크다는 것을 염두하고 탐색
 * 	2-1. 뒤에서부터 옆으로 옮기기.
 * 	2-2. 옆으로 옮기기 위해서는 본인과 그 다음 배열 요소의 높이를 비교
 * 		- 크면 자리를 바꾸고 낙차++
 * 		- 작으면 Stop
 * 3. 탐색하면서 구한 낙차의 최댓값 구하기.
 * 4. 출력.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 시행.
		for(int t = 1; t <= T; t++) {
			// 방의 크기를 받고 방(배열) 만들기
			int n = sc.nextInt();
			int[] room = new int[n];
			
			for(int i = 0; i < n; i++) {
				room[i] = sc.nextInt();
			}
			
			// 최댓값을 구하기 위한 변수
			int maxCount = 0;
			
			// 뒤에서부터 탐색하며 낙차를 구하기
			for(int i = n-2; i >= 0 ; i--) {
				// 낙차를 카운트할 변수
				int count = 0;
				
				// 비교를 위한 index 변수
				int index = i;
				
				// 만약 0이면 박스가 없으므로 패스
				if(room[i]==0) {
					continue;
				}
				
				// 최대한 갈 수 있는 곳까지 배열 요소 비교하기
				while (index != n-1) {
					// 만약 본인이 그 다음 요소의 높이보다 높으면 요소 서로 바꿔주기
					if(room[index] > room[index+1]) {
						int temp = 0;
						temp = room[index];
						room[index] = room[index+1];
						room[index+1] = temp;
						
						// 낙차 추가
						count++;
					} else {
						// 작으면 끝내기
						break;
					}
					
					// 한칸씩 내려가면서 비교하기 때문에 인덱스 값 추가
					index++;
				}
				
				// 최대 낙차 구하기
				if(count > maxCount) {
					maxCount = count;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n",t,maxCount);
		}
	}
}