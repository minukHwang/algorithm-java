import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int T, N;
	static int[][] map;
	static boolean[][] visited;

	// 무조건 시계 방향으로 움직이도록
	static int[] deltaR = { 1, 1, -1, -1 };
	static int[] deltaC = { 1, -1, -1, 1 };

	static int startR;
	static int startC;
	static int startD;

	static LinkedList<Integer> path;

	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			max = 0;
			
			sb.append("#").append(t).append(" ");

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					startR = r;
					startC = c;

//					for (int i = 0; i < 4; i++) {
						int nextR = r + deltaR[0];
						int nextC = c + deltaC[0];

						// 여기서 일단 갈 수 있는 곳인지 먼저 판별을 하는 과정을 거친다.
						if (isNotOutBound(nextR, nextC)) {
//							System.out.println("startR: " + startR + " startC: " + startC + " nextR: " + nextR + " nextC: " + nextC);
							visited = new boolean[N][N];
							path = new LinkedList<>();
							startD = 0;

							visited[nextR][nextC] = true;
							path.add(map[nextR][nextC]);
							dfs(nextR, nextC, 0, 1);
//							System.out.print(path);
//							System.out.println();
						}
//					}
				}
			}
			
			if(max == 0) max = -1;
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int dir, int sum) {
		

		// 기저 조건 : 다시 처음 위치에 오는 경우 + 방향을 세번 바꾼 경우
		if (r == startR && c == startC && dir == (startD + 3) % 4) {
			max = Math.max(max, sum);
			return;
		}

		// 만약 사각형을 안그리는 경우? -> 방향이 출발 방향 -1이 아닌 경우
		// 애초에 visited 배열 쓰면 근데 안가긴 할듯?? 그래도 혹시 모르니
		if (r == startR && c == startC && dir != (startD + 3) % 4) {
			// 이때는 갱신하지 않는다.
			return;
		}

		// 재귀 조건

		// 같은 방향으로 가도 되는거 아닌가? 맞음
		// 그리고 무조건 다음 방향으로 가야하지 않나? // 맞음
		for (int i = 0; i <= 1; i++) {
			// 다음 좌표 추론
			int nextD = (dir + i) % 4;
			int nextR = r + deltaR[nextD];
			int nextC = c + deltaC[nextD];

			// 일단 원래 가던 방향으로 갈 수 있는지 먼저 확인
			// 확인 해야하는 조건들
			// 1. 범위 안에 있는지?
			// 2. 방문한 적이 없는지?
			// 3. 이미 간 카페가 없는지?
			if (isNotOutBound(nextR, nextC) && !visited[nextR][nextC] && isNotSame(nextR, nextC)) {
				visited[nextR][nextC] = true;
				path.addLast(map[nextR][nextC]);
//				System.out.print(path);
				dfs(nextR, nextC, nextD, sum + 1);
				
				visited[nextR][nextC] = false;
				path.removeLast();
//				System.out.print(path);
				
			}
		}
	}

	private static boolean isNotSame(int nextR, int nextC) {
		boolean isAvailable = true;
		int nextCafe = map[nextR][nextC];

		for (int i = 0; i < path.size(); i++) {
			if (nextCafe == path.get(i)) {
				isAvailable = false;
				break;
			}
		}

		return isAvailable;
	}

	private static boolean isNotOutBound(int nextR, int nextC) {
		return nextR >= 0 && nextR < N && nextC >= 0 && nextC < N;
	}
}
