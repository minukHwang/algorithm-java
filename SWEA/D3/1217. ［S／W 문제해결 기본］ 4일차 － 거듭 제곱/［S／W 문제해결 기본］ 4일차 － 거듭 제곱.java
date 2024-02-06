import java.util.Scanner;

/*
 * 문제 풀이 과정
 * 1. 재귀 호출 함수 만들기
 * 	- n을 연속적으로 곱해주는 재귀 함수
 * 	- n,m을 동시에 함수의 매개변수로하고, m을 1씩 줄이면서 함수에 n을 곱한 값을 리턴한다.
 * 	- 기저 조건으로 만약 m이 1이 되면 n을 리턴하도록 한다.
 * 2. 출력하기
 */

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int caseNum = sc.nextInt();

			int N = sc.nextInt();
			int M = sc.nextInt();

			int answer = power(N, M);

			System.out.printf("#%d %d\n", caseNum, answer);
		}
	}

	public static int power(int n, int m) {
		// 기저 조건
		// m이 1이 되는 시점에서 n의 개수가 n-1번 곱해져 있기 때문에 n을 리턴
		if (m == 1) {
			return n;
		}

		// 재귀 호출
		return n * power(n, --m);
	}

}