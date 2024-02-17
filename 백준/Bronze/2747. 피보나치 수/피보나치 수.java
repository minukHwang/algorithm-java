import java.util.Scanner;

public class Main {
	static int[] cache = new int[46];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(fibo(sc.nextInt()));
	}
	
	public static int fibo(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		if(cache[n] != 0) {
			return cache[n];
		}
		
		cache[n] = fibo(n-1) + fibo(n-2);
		return cache[n];
	}
}
