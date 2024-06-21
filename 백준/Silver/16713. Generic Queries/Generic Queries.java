import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] acc = new int[N+1];
		int xor = 0;
		acc[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			xor ^= Integer.parseInt(st.nextToken());
			acc[i] = xor;
		}
		
		int answer = 0;
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			answer ^= acc[end] ^ acc[start - 1];
		}
		
		System.out.println(answer);
	}
}
