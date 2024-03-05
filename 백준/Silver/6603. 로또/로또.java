import java.util.Scanner;

public class Main {
	static int K;
	static int[] subset;
	static boolean[] visited;
	static int[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			K = sc.nextInt();

			// 종료 조건
			if (K == 0) {
				break;
			}

			subset = new int[K];
			visited = new boolean[K];
			selected = new int[6];

			for (int i = 0; i < K; i++) {
				subset[i] = sc.nextInt();
			}

			combination(0, 0);
			System.out.println();
		}

	}

	public static void combination(int start, int depth) {
		if (depth == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < selected.length - 1; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append(selected[selected.length - 1]);
			System.out.println(sb);
			return;
		}

		for (int i = start; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = subset[i];
				combination(i + 1, depth + 1);
				visited[i] = false;
			}
		}

	}
}
