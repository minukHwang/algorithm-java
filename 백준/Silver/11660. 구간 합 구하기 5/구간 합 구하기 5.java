import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] table = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int number = sc.nextInt();
				table[r][c] = number + table[r][c - 1] + table[r - 1][c] - table[r - 1][c - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int answer = table[x2][y2] - table[x2][y1 - 1] - table[x1 - 1][y2] + table[x1 - 1][y1 - 1];
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	public static void printMap(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.printf("%4d", map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
