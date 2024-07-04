import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static long N;
	static long[] wires;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		K = Integer.parseInt(input[0]);
		N = Long.parseLong(input[1]);
		
		wires = new long[K];
		
		for(int i = 0; i < K; i++) {
			wires[i] = Long.parseLong(br.readLine());
		}
		
		System.out.println(getMaxLength());
	}
	
	public static long getMaxLength() {
		long left = 0;
		long right = (1L << 31) - 1;
		long maxLength = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			if(isAvailableCount(mid)) {
				left = mid + 1;
				maxLength = mid;
			} else {
				right = mid - 1;
			}
		}
		
		return maxLength;
	}
	
	public static boolean isAvailableCount(long height) {
		long count = 0;
		
		for(int i = 0; i < K; i++) {
			count += (wires[i] / height);
		}
		
		return count >= N;
	}
}
