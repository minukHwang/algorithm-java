

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			int lowerBound = getLowerBound(cards, number);
			int upperBound = getUpperBound(cards, number);
			bw.write((upperBound - lowerBound) + " ");
		}
		
		bw.flush();
	}

	private static int getLowerBound(int[] arr, int number) {
		// 처음으로 number 이상이 되는 index
		int lowerBound = arr.length;
		
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(number > arr[mid]) {
				left = mid + 1;
			} else {
				lowerBound = mid;
				right = mid - 1;
			}
		}
		
		return lowerBound;
	}
	
	private static int getUpperBound(int[] arr, int number) {
		// 처음으로 number 초과가 되는 index
		int upperBound = arr.length;
		
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(number >= arr[mid]) {
				left = mid + 1;
			} else {
				upperBound = mid;
				right = mid - 1;
			}
		}
		
		return upperBound;
	}
	
}
