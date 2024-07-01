import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] liquids;
	static int minSum;
	static int[] minLiq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		liquids = new int[N];
		minSum = -2000000001;
		minLiq = new int[2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquids);
		
		for(int i = 0; i < N; i++) {			
			getNum(liquids[i], i);
			
			if(minSum == 0) {
				break;
			}
		}
		
		System.out.printf("%d %d\n", minLiq[0], minLiq[1]);
	}
	
	public static void getNum(int num, int start) {
		int left = start + 1;
		int right = liquids.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int sum = num + liquids[mid];
			
			
			if(Math.abs(minSum) > Math.abs(sum)) {
				minSum = sum;
				minLiq[0] = num;
				minLiq[1] = liquids[mid];
			}
			
			if(sum > 0) {
				right = mid - 1;
			}
			
			else if (sum < 0) {
				left = mid + 1;
			}
			
			else {
				break;
			}
		}
	}
}
