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
 * 2. 기저 조건에 도달하면 배열을 탐색하고 true의 index에서 음식의 칼로리와 점수를 더한다.
 * 3. 더해진 칼로리가 만약 범위를 넘어서지 않는다면 최대값 판별.
 */

public class Solution {
	static int N;
	static int limit;
	static int[][] foods;
	static boolean[] selected;
	static int maxScore;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			limit = sc.nextInt();
			foods = new int[N][2];
			selected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				foods[i][0] = sc.nextInt();
				foods[i][1] = sc.nextInt();
			}
			
			maxScore = 0;
			
			makeHamburger(0);
			System.out.printf("#%d %d\n", t, maxScore);
		}
		
	}

	public static void makeHamburger(int index) {
		if(index >= N) {
			int calories = 0;
			int score = 0;
			
			for(int i = 0; i < N; i++) {
				if(selected[i]) {					
					score += foods[i][0];
					calories += foods[i][1];
				}
			}
			
			if(calories <= limit && score > maxScore) {
				maxScore = score;
			}
			
			return;
		}
		
		
		selected[index] = true;
		makeHamburger(index+1);
		
		selected[index] = false;
		makeHamburger(index+1);
	}
}