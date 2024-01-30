import java.util.Scanner;

/*
 * 문제 풀이 과정
 * 1. 다양한 방법이 있겠지만, 문제에서 상자 높이의 범위와 정수라는 것, 
 * 	 여러 조건 등을 통해 카운팅 정렬을 사용하는 것이 좋을 것 같다고 판단.
 * 2. 카운팅 배열 만들기 -> 문제에서 상자의 높이가 1~100이하라고 했으니, int[101]
 * 3. 입력값 받아서 카운팅
 * 4. 카운팅 배열의 양옆을 탐색하여 최대 인덱스, 최소 인덱스 파악
 * 5. 덤프 횟수 만큼 최대 -> 최소로 덤프
 * 	 - 최대 인덱스 => 카운팅 배열의 요소(최대 인덱스의)중 하나가 (만약 다수라면) 1만큼 감소하는 것
 * 	 			   따라서, 해당 인덱스의 값이 1이 빠지고 최대보다 1작은 인덱스로 넘어감을 알 수 있다. 
 * 				   Ex) [1,2,3,4,5] => [1,2,3,5,4]
 * 	 - 최소는 이 반대로 진행하면됨.
 * 6. 출력
 */

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();

			int[] counts = new int[101];

			for (int i = 0; i < 100; i++) {
				counts[sc.nextInt()]++;
			}

			int maxIndex = 0;
			int minIndex = 0;

			// 배열 탐색하여 최대 최소 인덱스 파악.
			for (int i = 1; i < 101; i++) {
				if(counts[i]!=0) {
					minIndex = i;
					break;
				}
			}
			
			for (int i = 100; i >= 0; i--) {
				if(counts[i]!=0) {
					maxIndex = i;
					break;
				}
			}
			
			while(dump > 0) {
				// 1. 최대 최소 상자는 
				// 최대는 본인보다 하나 작은
				// 최소는 본인보다 하나 큰 높이로 이동하기 때문에
				// 카운팅 배열에서 최대인 경우에는 본인보다 하나 작은 인덱스로
				// 최소는 본인보다 하나 큰 인덱스로 이동한다고 생각.
				counts[minIndex] -= 1;
				counts[maxIndex] -= 1;
				
				counts[minIndex+1] += 1;
				counts[maxIndex-1] += 1;
				
				dump--;
				
				// 만약 카운트가 0이 된다면 다음 인덱스로 이동.
				if(counts[minIndex] == 0)
				{
					minIndex++;
				}
				
				if(counts[maxIndex]==0) {
					maxIndex--;
				}
			}
			
			System.out.printf("#%d %d\n",t, maxIndex - minIndex);
		}
	}

}
