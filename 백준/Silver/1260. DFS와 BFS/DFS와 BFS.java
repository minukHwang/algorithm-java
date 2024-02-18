import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, v;
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			graph[node1].add(node2);
			graph[node2].add(node1); // 무방향 그래프인 경우
		}

		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
	}

	public static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");

		Collections.sort(graph[node]);

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		Collections.sort(graph[node]);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}
