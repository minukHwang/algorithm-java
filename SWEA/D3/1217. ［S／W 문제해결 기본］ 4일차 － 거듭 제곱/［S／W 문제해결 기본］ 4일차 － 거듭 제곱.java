/*
 * [문제 풀이 과정]
 * - 분할 정복 활용하기
 * 1. 재귀적으로 반으로 나누어서 숫자들을 지속적으로 곱해나간다.
 * 2. 반으로 나눈 부분들을 tmp 변수에 저장하여 곱해준다.
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int caseNum = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int answer = pow(N, M);
			
			System.out.printf("#%d %d\n", caseNum, answer);
		}
	}
	
	public static int pow(int number, int count) {
		if(count == 1) {
			return number;
		}
		
		int tmp = pow(number, (count / 2));
		if(count % 2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * number;
		}
	}
}