/*
 * 문제 풀이 과정
 * 1. 숫자를 입력 받는다.
 * 2. 최대 최소를 제외한 평균이기 때문에 평균은 (총합 - 최댓값 - 최솟값) / 8임을 활용한다.
 * 3. 입력 받으면서 숫자의 총합과 최댓값, 최솟값을 구한다.
 * 4. 평균 구해서 출력!
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			int sum = 0;

			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();

				// 입력값들의 최댓값 구하기.
				if (num > max) {
					max = num;
				}

				// 입력값들의 최솟값 구하기.
				if (num < min) {
					min = num;
				}

				// 총합 구하기.
				sum += num;
			}
			
			// 평균은 실수로 계산하여 소숫점이 존재하도록 한다. (형변환 필요)
			double avg = (double) (sum - max - min) / 8.0;
			
			// 출력할 때는 소숫점 첫째 자리에서 반올림한 정수를 출력.
			System.out.printf("#%d %.0f\n", t, avg);
		}
		
		sc.close();
	}
}