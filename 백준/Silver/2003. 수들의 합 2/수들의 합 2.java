import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int rightIndex = 0;
		int currentSum = arr[0];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			while(currentSum < M && rightIndex < N - 1) {
				currentSum += arr[++rightIndex];
			}
			if(currentSum == M) {
				count++;
			}
			currentSum -= arr[i];
		}
		
		System.out.println(count);
	}
}
