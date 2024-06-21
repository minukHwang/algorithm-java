import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] prefix = new int[N + 1];
		int sum = 0;
		
		for(int i = 1; i < N + 1; i++) {
			int number = sc.nextInt();
			sum += number;
			
			prefix[i] = sum;
		}
		
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt();
			
			int answer = prefix[end] - prefix[start];
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
