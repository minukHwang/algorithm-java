/*
 * [문제 풀이 과정]
 * *삽입 정렬 이용해보기!*
 * 1. 빈 배열에 숫자를 입력 받는다.
 * 2. 삽입 정렬로 정렬을 진행한다.
 * 	1) 배열을 2그룹으로 나눈다.
 * 	2) 뒤의 그룹의 첫번째 숫자와 앞의 그룹을 뒤에서부터 비교하면서 만약 크기가 더 큰 요소가 있다면 위치를 바꿔준다.
 *  3) 위의 과정을 첫번째 그룹이 1개의 숫자로 이루어져있을 때, 2개의 숫자.. 3개의 숫자.. .... n-1개의 숫자가 될 때까지 진행.
 * 3. 출력!
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 배열 정렬하기
			for (int i = 1; i < n; i++) {
				int key = arr[i];

				int j;
				// 그룹을 두개로 나누어서 본인보다 큰 요소가 없을 때까지 옆으로 shift
				for (j = i - 1; j >= 0 && arr[j] > key; j--) {
					arr[j + 1] = arr[j];
				}

				arr[j + 1] = key;
			}
			
			System.out.printf("#%d", t);
			for(int i = 0; i < n; i++) {
				System.out.printf(" %d", arr[i]);
			}
			System.out.println();
		}
	}
}