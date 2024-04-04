import java.util.Scanner;

public class Solution {
	static int[] changes = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
	static int T, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			N = sc.nextInt();
			
			for(int i = 0; i < changes.length; i++) {
				int count = N / changes[i];
				N %= changes[i];
				
				sb.append(count);
				
				if(i == changes.length-1) {
					sb.append("\n");
					break;
				}
				
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}