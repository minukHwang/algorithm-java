import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		int[] count = new int[1000000+1];
		int ans = 0;
		
		
		for(int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i < n; i++) {
			int pair = x - arr[i];
			if(pair >= 0 && pair <= 1000000 && count[pair] > 0) {
				ans += count[x - arr[i]];
			}
		}
		
		System.out.println(ans / 2);
	} 
}
