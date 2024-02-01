/*
 * 풀이 방법
 * 1. 문자를 읽어드린다.
 * 2. 문자를 중간점으로부터 양끝으로 들어갈 때까지 left와 right가 같은지 판별한다.
 * 3. 만약 모두 같으면 회문!
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			int size = str.length();

			boolean isPalindrome = true;

			// left와 right를 중간점으로 설정
			// 문자 길이가 짝수 홀수인지에 따라 다르게 설정
			int left = size % 2 == 1 ? size / 2 : size / 2 - 1;
			int right = size % 2 == 1 ? size / 2 : size / 2;

			while (left >= 0 && right <= size) {
				// 만약 left와 right가 같지 않다면 false
				if (str.charAt(left) != str.charAt(right)) {
					isPalindrome = false;
					break;
				}
				left--;
				right++;
			}
			// while문을 모두 통과하면 전체가 같기 때문에 true로 유지

			System.out.printf("#%d %d\n", t, isPalindrome ? 1 : 0);
		}
	}
}