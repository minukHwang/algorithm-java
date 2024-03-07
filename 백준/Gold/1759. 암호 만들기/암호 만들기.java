import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static String[] letters;
	static boolean[] visited;
	static String[] selected;
	static String[] alphabet = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();

		sc.nextLine();
		letters = sc.nextLine().split(" ");

		visited = new boolean[C];
		selected = new String[L];

		Arrays.sort(letters);

		combination(0, 0);

	}

	public static void combination(int start, int depth) {
		if (depth == L) {
			StringBuilder sb = new StringBuilder();

			// 모음이 있는지 판단 먼저?
			if (isAvailable() == 0 || isAvailable() >= L - 1) {
				return;
			}

			for (int i = 0; i < L; i++) {
				sb.append(selected[i]);
			}

			System.out.println(sb);
			return;
		}

		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = letters[i];
				combination(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static int isAvailable() {
		int count = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < alphabet.length; j++) {
				if (selected[i].equals(alphabet[j])) {
					count++;
				}
			}
		}

		return count;
	}
}
