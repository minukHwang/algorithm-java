import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
	int time;
	int count;
	int dir;

	Cell() {
		this.time = 0;
		this.count = 0;
		this.dir = 0;
	}

	Cell(int time, int count, int dir) {
		this.time = time;
		this.count = count;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "{" + count + ", " + dir + "}";
	}

}

public class Solution {
	static int T, N, time, cells;
	static Queue<Cell>[][] map;
	static int[] deltaR = { 0, -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, 0, -1, 1 };
	static int totalCells;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// init
			N = sc.nextInt();
			time = sc.nextInt();
			cells = sc.nextInt();
			map = new Queue[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = new LinkedList<>();
				}
			}

			for (int i = 0; i < cells; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int count = sc.nextInt();
				int dir = sc.nextInt();

				Cell cell = new Cell(time, count, dir);
				map[r][c].add(cell);
			}
//			System.out.println("초기");
//			printMap();

			// 반복문으로 풀어야함
			while (time > 0) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 1시간 단위로 세포들을 움직인다.

						if (!map[r][c].isEmpty()) {
							// 일단 셀을 빼서
							Cell cell = map[r][c].peek();
							if (cell.time == time) {
								// 다음 좌표 이동 준비
								int nextR = r + deltaR[cell.dir];
								int nextC = c + deltaC[cell.dir];

								// 만약에 벽이라면
								if (nextR == 0 || nextR == N - 1 || nextC == 0 || nextC == N - 1) {
									// 군집 수 감소시키기
									cell.count /= 2;
									// 방향 바꿔주기
									switch (cell.dir) {
									case 1:
										cell.dir = 2;
										break;
									case 2:
										cell.dir = 1;
										break;
									case 3:
										cell.dir = 4;
										break;
									case 4:
										cell.dir = 3;
										break;
									}
								}

								// 다음 좌표 큐에 넣어주기
								cell = map[r][c].poll();
								cell.time--;
								map[nextR][nextC].add(cell);
//								System.out.println("일단 배치");
//								printMap();
							}
						}
					}
				}

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 1시간 단위로 세포들을 움직인다.

						if (!map[r][c].isEmpty() && map[r][c].size() > 1) {
							int totalCount = 0;
							int maxCount = 0;
							int maxDir = 0;
//							System.out.println(map[r][c].size());

							while (!map[r][c].isEmpty()) {
								Cell cell = map[r][c].poll();
								totalCount += cell.count;

								// 최대 최소 판별
								if (cell.count > maxCount) {
									maxCount = cell.count;
									maxDir = cell.dir;
								}
							}

							Cell newCell = new Cell(time - 1, totalCount, maxDir);
//							System.out.println(newCell);
							map[r][c].add(newCell);
						}
					}
				}
				time--;
				// 1시간 지남
//				System.out.println(time + "시간에 최종");
//				printMap();
			}

			// 최종적으로 남아있는 미생물 수를 확인한다.
			totalCells = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!map[r][c].isEmpty()) {
						while (!map[r][c].isEmpty()) {
							Cell cell = map[r][c].poll();
							totalCells += cell.count;
						}
					}
				}
			}

			System.out.println("#" + t + " " + totalCells);
		}
	}

	public static void printMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.printf("%-15s", map[r][c]);
			}
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
		}

		System.out.println();
	}
}
