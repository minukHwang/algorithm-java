import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] ground;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ground = new int[N + 1];

		int[] delta = new int[N + 2];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			delta[a] += k;
			delta[b + 1] -= k;
		}
		
		int [] accDelta = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			accDelta[i] = accDelta[i-1] + delta[i];
		}
		
		for(int i = 1; i <= N; i++) {
			bw.write((ground[i] + accDelta[i]) + " ");
		}
		
		bw.flush();
	}
}
