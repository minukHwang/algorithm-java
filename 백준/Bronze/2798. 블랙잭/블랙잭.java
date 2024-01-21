import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		int ans = 0;
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				for(int k = j+1; k < n; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(m-sum >= 0 && (m-sum) < min) {
						min = m-sum;
						ans = sum;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}