import java.util.Scanner;

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = new int[N][N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			dfs(i, i, 0, 0);
		}

		System.out.println(answer);
	}

	public static void dfs(int start, int node, int depth, int cost) {
		if (depth == N && start == node) {
			answer = Math.min(answer, cost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && W[node][i] != 0) {
				visited[i] = true;
				dfs(start, i, depth + 1, cost + W[node][i]);
				visited[i] = false;
			}
		}

	}

}
