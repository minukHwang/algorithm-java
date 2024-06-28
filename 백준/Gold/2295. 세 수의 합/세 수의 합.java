import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sums = new int[N * (N + 1) / 2];
		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sumIndex = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				sums[sumIndex++] = arr[i] + arr[j];
			}
		}
		
		Arrays.sort(sums);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int target = arr[i] - arr[j];
				if(isExist(target, sums)) {
					max = Math.max(max, arr[i]);
				}
				
			}
		}
		
		System.out.println(max);
	}


	public static boolean isExist(int num, int sum[]) {
		int left = 0;
		int right = sum.length - 1;

		while (right >= left) {
			int mid = (left + right) / 2;
			if (sum[mid] < num) {
				left = mid + 1;
			}
			else if (sum[mid] > num) {
				right = mid - 1;
			}
			else {
				return true;
			}
		}
		return false;
	}
}
