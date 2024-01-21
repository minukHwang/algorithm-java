import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int d1 = 0;
		int d2 = 0;
		
		int index = 0;
		
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			sum += arr[i];
			
			if(sum>=100) {
				index = i;
				break;
			}
		}
		
		d1 = Math.abs(sum - arr[index] - 100);
		d2 = Math.abs(sum - 100);
		
		if(d1 < d2) {
			sum = sum - arr[index];
		}
		
		System.out.println(sum);
		
		
	}
}
