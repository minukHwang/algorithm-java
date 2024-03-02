import java.util.Scanner;

public class Solution {
	static int T, N, M, C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] selected;
	static boolean[] subset;
	static int[] maxPerson;
	static int maxHoney;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			selected = new int[2][M];
			subset = new boolean[M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			maxHoney = 0;

			getHoney(0, 0, 0);

			System.out.println("#" + t + " " + maxHoney);
		}
	}

	public static void getSubset(int index, int person) {
		if (index == M) {
			int count = 0;

			for (int i = 0; i < M; i++) {
				if (subset[i]) {
					count += selected[person][i];
				}
			}

			// 범위 안 넘는지 확인
			if (count > C) {
				return;
			}

			int total = 0;

			// 만약 안 넘는다면? 이제 채취
			for (int i = 0; i < M; i++) {
				if (subset[i]) {
					total += Math.pow(selected[person][i], 2);
				}
			}

			if (maxPerson[person] < total) {
				maxPerson[person] = total;
			}

			return;
		}

		subset[index] = true;
		getSubset(index + 1, person);

		subset[index] = false;
		getSubset(index + 1, person);
	}

	public static void getHoney(int rStart, int cStart, int count) {
		if (count == 2) {
			maxPerson = new int[2];

			getSubset(0, 0);
			getSubset(0, 1);

			int sum = maxPerson[0] + maxPerson[1];

			if (sum > maxHoney) {
				maxHoney = sum;
			}
			return;
		}

		for (int r = rStart; r < N; r++) {
			for (int c = 0; c < N; c++) {
				boolean isAvailable = true;
				for (int d = 0; d < M; d++) {
					int indexC = c + d;

					// 일단 모든 애들이 범위 안에 있는지 확인 필요
					// 하나라도 범위 밖에 있다면, 하나라도 방문한 적이 있다면,
					if (indexC < 0 || indexC >= N || visited[r][indexC]) {
						isAvailable = false;
					}

				}

				// 만약 모두 범위 안에 있고, 방문한 적이 없다면
				if (isAvailable) {
					for (int d = 0; d < M; d++) {
						int indexC = c + d;

						visited[r][indexC] = true;
						// 선택 배열 안에 넣어주기
						selected[count][d] = map[r][indexC];
					}
					getHoney(r, c + M, count + 1);

					for (int d = 0; d < M; d++) {
						int indexC = c + d;

						visited[r][indexC] = false;
					}
				}
			}
		}

	}

}
