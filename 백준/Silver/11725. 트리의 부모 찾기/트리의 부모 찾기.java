import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] tree;
	static int[] parent;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		tree = new ArrayList[n + 1];
		checked = new boolean[n + 1];
		parent = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			tree[node1].add(node2);
			tree[node2].add(node1);
		}

		find(1);

		for (int i = 2; i < n + 1; i++) {
			sb.append(parent[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static void find(int node) {
		checked[node] = true;
		for (int i = 0; i < tree[node].size(); i++) {
			int child = tree[node].get(i);
			if (!checked[child]) {
				parent[child] = node;
				find(child);
			}
		}
	}
}
