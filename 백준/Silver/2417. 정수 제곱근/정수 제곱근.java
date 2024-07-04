import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		long answer = getMinSqrtNum(n);
		
		System.out.println(answer);
	}

	private static long getMinSqrtNum(long n) {
		if(n == 0) return 0;
		
		long left = 1, right = 1L << 32, sqrt = -1;
		while(left <= right) {
			long m = (left + right) / 2;
			if(isAvailableSqrt(n, m)) {
				right = m - 1;
				sqrt = m;
			}
			else left = m + 1;
 		}
		
		return sqrt;
	}

	private static boolean isAvailableSqrt(long n, long q) {
		return q >= (n - 1) / q + 1;
	}
}
