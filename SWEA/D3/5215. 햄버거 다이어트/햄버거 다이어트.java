import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int limit;
	static int[][] foods;
	static boolean[] selected;
	static int calories;
	static int score;
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
			
			calories = 0;
			score = 0;
			maxScore = 0;
			
			makeHamburger(0);
			System.out.printf("#%d %d\n", t, maxScore);
		}
		
	}

	private static void makeHamburger(int index) {
		if(index >= N) {
			for(int i = 0; i < N; i++) {
				if(selected[i]) {					
					score += foods[i][0];
					calories += foods[i][1];
				}
			}
			
			if(calories <= limit && score > maxScore) {
				maxScore = score;
			}
			
			score = 0;
			calories = 0;
			return;
		}
		
		
		selected[index] = true;
		makeHamburger(index+1);
		
		selected[index] = false;
		makeHamburger(index+1);
	}
}