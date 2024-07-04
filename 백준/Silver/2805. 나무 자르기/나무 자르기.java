import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static long[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		trees = new long[N];
		
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getMaxHeight());
	}
	
	public static long getMaxHeight() {
		long left = 0;
		long right = 1000000000;
		long maxHeight = 0;
		
//		System.out.println(right);
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long totalHeight = getTotalHeight(mid);
//			System.out.println("left: " + left + " right: " + right + " mid: " + mid + " totalHeight: " + totalHeight + " maxHeight: " + maxHeight);
			
			if(totalHeight >= M) {
				left = mid + 1;
				maxHeight = mid;
			} else {
				right = mid - 1;
			}
			
//			System.out.println("left: " + left + " right: " + right + " mid: " + mid + " totalHeight: " + totalHeight + " maxHeight: " + maxHeight);
//			System.out.println();
		}
		
		return maxHeight;
	}
	
	public static long getTotalHeight(long height) {
		long totalHeight = 0;
		
		for(int i = 0; i < N; i++) {
			long cuttedHeight = trees[i] - height;
			
			if(cuttedHeight > 0) {
				totalHeight += cuttedHeight;
			}
		}
		
		return totalHeight;
	}
}
