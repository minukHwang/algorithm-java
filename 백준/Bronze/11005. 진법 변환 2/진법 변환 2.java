import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long N = sc.nextInt();
		long B = sc.nextInt();
		long temp = 1L;
		char[] digits = new char[36];
		
		for(int i = 0; i < 36; i++) {
			if(i < 10) {				
				digits[i] = (char) ('0' + i);
			}
			
			if(i >= 10) {
				digits[i] = (char) ('A' - 10 + i);
			}
		}
		
		List<Long> b = new ArrayList<>();
		
		while(temp <= N) {
			b.add(temp);
			
			temp *= B;
		}
		
		for(int i = b.size() - 1; i >= 0; i--) {
			long div = b.get(i);
			
			int digit = (int) (N / div);
			N %= div;
			
			sb.append(digits[digit]);
		}
		
		System.out.println(sb);
	}
}
