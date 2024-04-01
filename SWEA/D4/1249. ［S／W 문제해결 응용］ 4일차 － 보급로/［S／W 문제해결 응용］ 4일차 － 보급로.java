/*
 * [문제 풀이 방법]
 * *다익스트라 알고리즘 활용*
 * 1. map, dist visited 배열을 만들고 map에 지도 정보를 받는다.
 * 2. dist 배열의 요소들을 무한대로 초기화한다.
 * 3. 다익스트라 알고리즘을 활요하기 위해 PriorityQueue를 만든다.
 * 4. pq에 start 좌표를 넣는데, 좌표에 대한 정보를 pq로 정렬할 수 있게 ground 클래스를 만들어서 map에 들어있는 복구 작업 시간을 정렬 기준으로 잡는다.
 * 5. pq가 비워질 때까지, 모든 좌표를 순회한다. 각 좌표는 사방 탐색 좌표로 넘어가기 위해서 사방 탐색 좌표로 0,0에서 바로 갔을 경우의 dist 각 좌표를 거쳐서 지나가는 경우 중 최소값으로 갱신하며 반복한다.
 * 6. 최종적으로 마지막에 종점에 저장된 dist 값을 출력.
 * 
 */

import java.util.PriorityQueue;
import java.util.Scanner;

class Ground implements Comparable<Ground> {
	int r;
	int c;
	int w;

	Ground() {

	}

	Ground(int r, int c, int w) {
		super();
		this.r = r;
		this.c = c;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Ground [r=" + r + ", c=" + c + ", w=" + w + "]";
	}

	@Override
	public int compareTo(Ground o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	static int T, N;
	static int[][] map;
	static int[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N];

			for (int r = 0; r < N; r++) {
				char[] arr = sc.next().toCharArray();
				for (int c = 0; c < N; c++) {
					map[r][c] = arr[c] - '0';
					dist[r][c] = INF;
				}
			}

			dijkstra(0, 0);

			sb.append(dist[N - 1][N - 1] + "\n");
		}
		
		System.out.println(sb);
	}

	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	private static void dijkstra(int startR, int startC) {
		PriorityQueue<Ground> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];

		dist[startR][startC] = 0;
		pq.add(new Ground(startR, startC, 0));

		while (!pq.isEmpty()) {
			Ground curr = pq.poll();

			if (visited[curr.r][curr.c] == true)
				continue;
			visited[curr.r][curr.c] = true;

			for (int i = 0; i < 4; i++) {
				int nextR = curr.r + deltaR[i];
				int nextC = curr.c + deltaC[i];

				if (isNotOutBound(nextR, nextC) && !visited[nextR][nextC] &&  dist[nextR][nextC] > map[nextR][nextC] + dist[curr.r][curr.c]) {
					dist[nextR][nextC] = map[nextR][nextC] + dist[curr.r][curr.c];
					pq.add(new Ground(nextR, nextC, dist[nextR][nextC]));
				}
			}
		}
	}


	private static boolean isNotOutBound(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
