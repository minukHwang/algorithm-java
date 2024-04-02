import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T, D, W, K;
	static int[][] map;
	static int minCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 너비
			K = sc.nextInt(); // 기준

			map = new int[D][W];

			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			minCount = Integer.MAX_VALUE;
			
			dfs(0, 0);

			sb.append("#" + t + " " + minCount + "\n");
		}

		System.out.println(sb);
	}

	// 조합 구하기
	public static void dfs(int r, int count) {
		if(count >= minCount) return;

		// 끝까지 다 간 경우에
		if (r == D) {
			// 이제 완성이 되었으니 가능한지 확인
			boolean pass = isAvailable();

			if (!pass) {
				return;
			}

			minCount = Math.min(minCount, count);
			return;
		}

		int[] temp = map[r].clone();

		// 아무것도 투입 안함
		dfs(r + 1, count);

		// A 투입
		Arrays.fill(map[r], 0);
		dfs(r + 1, count + 1);

		// B 투입
		Arrays.fill(map[r], 1);
		dfs(r + 1, count + 1);

		map[r] = temp;
	}

	// 성능 검사 메소드
	private static boolean isAvailable() {
		boolean pass = true;

		for (int c = 0; c < W; c++) {
			if (!isRowAvailable(c)) {
				pass = false;
			}
		}

		return pass;
	}

	// 열 가능 메소드
	private static boolean isRowAvailable(int c) {
		boolean rowPass = false;

		for (int r = 0; r < D - K + 1; r++) {
			int first = map[r][c];
			int count = 0;

			for (int i = 0; i < K; i++) {
				if (map[r + i][c] == first) {
					count++;
				} else {
					break;
				}
			}

			if (count >= K) {
				rowPass = true;
				break;
			}
		}

		return rowPass;
	}
}
