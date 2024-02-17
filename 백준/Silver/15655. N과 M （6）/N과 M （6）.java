import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	
	static int[] numbers;
	static boolean[] checked;
	static int[] selNum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[N];
		checked = new boolean[N];
		selNum = new int[M];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers);
		
		perm(0, 0);
		
		
	}
	
	public static void perm(int start, int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < selNum.length - 1; i++) {
				sb.append(selNum[i]).append(" ");
			}
			sb.append(selNum[selNum.length-1]);
			System.out.println(sb);
			return;
		}
		
		for(int i = start; i < numbers.length; i++) {
			if(!checked[i]) {
				checked[i] = true;
				selNum[depth] = numbers[i];
				perm(i + 1, depth+1);
				checked[i] = false;
			}
		}
		
	}
}
