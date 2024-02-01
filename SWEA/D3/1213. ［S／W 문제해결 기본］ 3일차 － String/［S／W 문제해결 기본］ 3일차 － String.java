import java.util.Scanner;

/*
 * 풀이 방법
 * *보이어-무어 알고리즘을 활용해보자!*
 * 1. 문자열을 받아드린다.
 * 2. 보이어-무어 알고리즘 구현
 * 	- 비교 배열의 뒤에서부터 비교하기, 비교 당하는 배열
 * 	- 스킵 메소드 만들어서 구현하기 => 실제로 배열이 움직이는 것은 아니고 인덱스 변경해주기.
 *  - 만약에 움직이다가 같은 배열 요소를 만나게 된다면 전체 비교 당하는 배열과 같은지 확인하고 갯수 파악
 */

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			int caseNum = sc.nextInt();

			char[] key = sc.next().toCharArray();
			String str = sc.next();

			// 배열을 움직일 index와 갯수 셀 준비.
			int indexStr = key.length - 1;
			int count = 0;

			while (indexStr < str.length()) {

				// 만약 해당 인덱스의 문자와 KEY의 마지막과 같다면.
				out: if (str.charAt(indexStr) == key[key.length - 1]) {
					// 해당 시점부터 전체 KEY와 같은지 확인하기
					for (int i = 0; i < key.length; i++) {
						// 만약 다르다면 이동
						if (str.charAt(indexStr - i) != key[key.length - i - 1]) {
							indexStr += key.length;
							break out;
						}
					}

					// 같은지 확인하고 갯수 추가 및 이동
					indexStr += key.length;
					count++;

				} else {
					// 만약 해당 인덱스의 문자와 KEY의 마지막과 다르다면 skip!
					indexStr += skip(key, str.charAt(indexStr));
				}

			}

			System.out.printf("#%d %d\n", caseNum, count);
		}

	}

	// 스킵 메소드 구현
	public static int skip(char[] key, char letter) {
		int delta = 0;

		// 만약 비교 배열안에 있는 요소와 비교 당하는 문자가 포함된다면,
		// 비교 배열이 해당 요소와 바로 비교 될 수 있도록 위치 조정해주기 위한 skip값 리턴
		for (int i = 0; i < key.length; i++) {
			if (key[i] == letter) {
				delta = key.length - i - 1;
				break;
			} else {
				delta = key.length;
			}
		}

		return delta;
	}
}