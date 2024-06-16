import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] tri = new int[n+1];
			int limit = 0;
			int answer = 0;
			
			for(int i = 1; i <= n; i++) {
				tri[i] = (i * (i + 1)) / 2;
				
				if(tri[i] >= n) {
					limit = i;
					break;
				}
			}
			
			
			out: for(int i = 1; i <= limit; i++) {
				for(int j = i; j <= limit; j++) {
					for(int k = i; k <= limit; k++) {
						if(tri[i] + tri[j] + tri[k] == n) {
							answer = 1;
							break out;
						}
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
