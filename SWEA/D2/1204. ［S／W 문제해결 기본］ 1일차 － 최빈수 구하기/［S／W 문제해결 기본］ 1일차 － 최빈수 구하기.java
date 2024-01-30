import java.util.Scanner;

/*
* 문제 풀이 과정
* 1. 0~100점까지 빈도수를 측정하기 위해서 배열은 만든다.
* 2. 학생 1000명의 점수를 입력 받으면서 해당 점수의 수를 카운팅 한다.
* 3. 빈도수 배열에서 최대의 값을 찾고 이를 출력한다.
* 	- 점수를 출력해야함.
* 	- 또한 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라고 한 부분에 유의.
*/

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int caseNum = sc.nextInt();
			// 0~100점이라고 하였으니 배열 크기는 101로 공간을 만들어준다.
			int[] scores = new int[101];

			for (int i = 0; i < 1000; i++) {
				// 배열에서 점수를 인덱스로 가지면 배열 요소 ++
				scores[sc.nextInt()]++;
			}

			int max = 0;
			int index = 0;

			for (int i = 0; i < 101; i++) {
				// 빈도수가 여러개일 때는 값을 계속 갱신할 수 있도록 초과X 이상O
				// 순차탐색으로 갱신하면 큰 최빈수가 나온다.
				if (scores[i] >= max) {
					max = scores[i];
					index = i;
				}
			}

			System.out.printf("#%d %d\n", caseNum, index);

		}

	}

}
