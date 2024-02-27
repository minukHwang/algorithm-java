import java.util.Scanner;

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