import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] graph;
	static boolean[] checked;
	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int r = sc.nextInt();
		int q = sc.nextInt();

		graph = new ArrayList[n + 1];
		checked = new boolean[n + 1];
		count = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			graph[node1].add(node2);
			graph[node2].add(node1);
		}

		countChild(r);

		for (int i = 0; i < q; i++) {
			int u = sc.nextInt();

			sb.append(count[u]).append("\n");
		}

		System.out.println(sb);

	}

	public static void countChild(int node) {
		checked[node] = true;

		for (int i = 0; i < graph[node].size(); i++) {
			int child = graph[node].get(i);
			if (!checked[child]) {
				countChild(child);
				count[node] += count[child];

			}
		}

		count[node]++;
	}
}
