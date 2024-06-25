import java.util.*;
import java.io.*;

public class Main {

	static int N, M, T, K, a, b;
	static char[][] map;
	static int[][] acc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		map = new char[N + 1][M + 1];
		acc = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			String str = br.readLine();

			for (int c = 1; c <= M; c++) {
				map[r][c] = str.charAt(c - 1);
			}
		}

		while (T-- > 0) {
			getAcc();
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					int startR = Math.max(r - K , 1);
					int startC = Math.max(c - K, 1);
					int endR = Math.min(r + K, N);
					int endC = Math.min(c + K, M);
					
					int nearAlive = acc[endR][endC] - acc[startR - 1][endC] - acc[endR][startC - 1] + acc[startR - 1][startC - 1];
					
					if (map[r][c] == '*') {
						nearAlive--;
						
						if(nearAlive > b) {
							map[r][c] = '.';
						}
						
						else if (nearAlive >= a) {
							continue;
						}
						
						else {
							map[r][c] = '.';
						}
					}

					else {
						if(nearAlive > a && nearAlive <= b) {
							map[r][c] = '*';
						}
					}
				}
			}
		}
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				bw.write(map[r][c]);
			}
			bw.write("\n");
		}

		bw.flush();
	}

	private static void getAcc() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				acc[r][c] = (map[r][c] == '*'? 1 : 0) + acc[r - 1][c] + acc[r][c - 1] - acc[r - 1][c - 1];
			}
		}
	}
}
