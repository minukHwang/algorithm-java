import java.util.Scanner;

/*
* 문제 풀이 과정
* 1. 입력받은 숫자들을 정렬한다.
* 	- Selection Sort를 구현해보자!
* 2. 중간값만 찾으면 되니 가운데 값(n/2+1)번째 값을 정렬을 통해 구하면 
* 	 더 이상 정렬은 하지 않고 바로 답 구하기.
*/

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(findMidNum(arr, n));

	}

	public static int findMidNum(int[] arr, int n) {
		// 중간값은 n / 2 + 1번째
		// 배열은 0부터 시작하니 인덱스는 n/2
		int midIndex = n / 2 + 1;

		// 모든 배열요소들을 정렬할 필요는 없다. 중간값까지 구하면 바로 종료.
		// 따라서 범위는 midIndex까지
		for (int i = 0; i < midIndex; i++) {
			// 처음에는 본인을 최소 인덱스로.
			int minIndex = i;

			// 본인보다 하나 뒤의 요소부터 계속 비교하면서 최소값이 나오면 인덱스 갱신
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// 최소값이 있는 위치를 알아내면 이를 본인의 위치와 스왑
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

		}

		// 중간값 리턴.
		return arr[midIndex - 1];
	}

}
