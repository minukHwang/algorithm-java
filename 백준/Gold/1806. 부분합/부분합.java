import java.util.*;
import java.io.*;

public class Main {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int currentSum = arr[0];
		int rightIndex = 0;
		int minCount = N + 1;
		
		for(int i = 0; i < N; i++) {
			while(currentSum < S && rightIndex < N - 1) {
				currentSum += arr[++rightIndex];
			}
			
			if(currentSum >= S) {			
				minCount = Math.min(minCount, rightIndex - i + 1);
			}
			currentSum -= arr[i];
		}
		
		if(minCount > N) {
			minCount = 0;
		}
		System.out.println(minCount);	
	}
}
