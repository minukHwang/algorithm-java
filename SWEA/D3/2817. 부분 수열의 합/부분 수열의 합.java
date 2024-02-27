import java.util.Scanner;

/*
 * [문제 풀이 과정]
 * 1. 부분 집합을 구하기 위해서 재귀 함수를 구현한다.
 * 	- selected boolean 배열을 만들어서 부분 집한 안에 들어가는 요소를 체크한다.
 * 	- 재귀를 순회하면서 [true, false, false, false]와 같이 부분집합이 될 수 있는 요소 체크
 * 	1) index -> 0에서 시작
 * 	2) 해당 index true
 * 	3) 다음 인덱스로 이동
 * 	4) 해당 index true
 *	...
 *	기저 조건 -> 만약 index가 배열의 크기이면.
 *	5) 해당 index false하고 다시 다음 인덱스로 이동 
 * 2. 기저 조건에 도달하면 배열을 탐색하고 true의 index에서 숫자들은 합한 sum을 구한다.
 * 3. 만약 sum이 k와 같다면 count++
 */

public class Solution {
	static int N;
	static int K;
	static int[] numbers;
	static boolean[] selected;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {			
			N = sc.nextInt();
			K = sc.nextInt();
			numbers = new int[N];
			selected = new boolean[N];
			count = 0;
			
			for(int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			getSumCount(0);
			System.out.printf("#%d %d\n", t, count);
		}
	}

	public static void getSumCount(int idx) {
		if(idx >= N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) {					
					sum += numbers[i];
				}
			}
			
			if(sum==K) {
				count++;
			}
			
			return;
		}
		
		selected[idx] = true;
		getSumCount(idx+1);
		selected[idx] = false;
		getSumCount(idx+1);
	}
	
	
}