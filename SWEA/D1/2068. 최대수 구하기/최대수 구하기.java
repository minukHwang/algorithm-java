/*
 * 문제 풀이 과정
 * 1. 숫자를 입력 받는다.
 * 2. 각각의 숫자를 비교하며 최대값을 담는 변수 활용.
 *  - 숫자를 입력 받으면서 만약 max라는 변수보다 크면 max값 바꿔주기 반복.
 *  - 해당 변수를 초기화 할때는 최대한 작은 수로 해야한다.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			// 최댓값을 비교, 저장할 변수 생성.
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				// 만약 max보다 크다면 max 값 바꿔주기
				// 이를 모든 입력값에 적용하면 해당 배열의 최댓값을 구할 수 있다.
				if(num > max) {
					max = num;
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
