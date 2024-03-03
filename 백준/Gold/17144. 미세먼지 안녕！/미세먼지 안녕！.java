import java.util.Scanner;

// 제한 시간 1초
// 1초동안 일어나는 일
// 1. 미세먼지 확산
// - 상하좌우로 /5 만큼
// - 미세먼지가 있던 칸은 확산한 만큼 빼기
// - 공기청정기가 있는 칸은 확산X
// 2. 공기 청정기 작동
// - 위쪽 -> 반시계
// - 아래쪽 -> 시계
// - 먼지는 한칸씩 이동하고, 만약 공기청정기 좌표로 들어가게 되면 정화됨
// - T초후 미세먼지 양 구하기

public class Main {
	static int R, C, time;
	static int[][] map;
	static boolean[][] isCenter;
	static int[][] temp;
	static int[][] airpurifier;

	// 상하좌우
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	// 반시계 -> 우, 상, 좌, 하
	static int[] topDeltaR = { 0, -1, 0, 1 };
	static int[] topDeltaC = { 1, 0, -1, 0 };

	// 시계 -> 우, 하, 좌, 상
	static int[] bottomDeltaR = { 0, 1, 0, -1 };
	static int[] bottomDeltaC = { 1, 0, -1, 0 };

	static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		time = sc.nextInt();
		map = new int[R][C];
		airpurifier = new int[2][2];

		int idx = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == -1) {
					airpurifier[idx][0] = r;
					airpurifier[idx][1] = c;
					idx++;
				}
			}
		}

//		System.out.println(Arrays.deepToString(airpurifier));

//		printMap();

		while (time > 0) {
			isCenter = new boolean[R][C];
			temp = new int[R][C];
			// 1. 센터인지 확인하기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 빈 공간도, 공기청정기도 아니라면
					if (map[r][c] != -1 && map[r][c] != 0) {
						isCenter[r][c] = true;
					}
				}
			}

			// 2. 센터를 기준으로 확산 시뮬
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 빈 공간도, 공기청정기도 아니라면
					if (isCenter[r][c]) {
						dust(r, c);
					}
				}
			}

			isCenter = new boolean[R][C];

			// 3. 확산된 먼지들 더해주기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] += temp[r][c];
				}

			}
			// temp 지워주기
			temp = new int[R][C];

			// 4. 공기청정기 작동시키기
			runAirPurifier();
//			printTemp();
//			printMap();

			time--;
		}

		total = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 빈 공간도, 공기청정기도 아니라면
				if (map[r][c] != -1 && map[r][c] != 0) {
					total += map[r][c];
				}
			}
		}

		System.out.println(total);
	}

	public static void runAirPurifier() {
		int topR = airpurifier[0][0];
		int topC = airpurifier[0][1];
		int bottomR = airpurifier[1][0];
		int bottomC = airpurifier[1][1];

		int topDir = 0;
		int bottomDir = 0;

		int nextTopR = topR + topDeltaR[topDir];
		int nextTopC = topC + topDeltaC[topDir];

		int nextBottomR = bottomR + bottomDeltaR[bottomDir];
		int nextBottomC = bottomC + bottomDeltaC[bottomDir];

		// 위부터 돌리기
		while (nextTopR != topR || nextTopC != topC) {
			// 만약 범위 안에 있다면
			if (nextTopR >= 0 && nextTopR < R && nextTopC >= 0 && nextTopC < C) {
				// 먼지 밀어내기
				if (map[nextTopR - topDeltaR[topDir]][nextTopC - topDeltaC[topDir]] != -1) {
					temp[nextTopR][nextTopC] = map[nextTopR - topDeltaR[topDir]][nextTopC - topDeltaC[topDir]];
				}
			} else {
				// 범위를 벗어난다면 회전!!
				// 회전하기 전에 범위를 벗어났으니 다시 보정해주고
				nextTopR -= topDeltaR[topDir];
				nextTopC -= topDeltaC[topDir];
				// 다음 방향으로 바꿔주기
				topDir = (topDir + 1) % 4;
			}

			// 다음 좌표로 이동
			nextTopR += topDeltaR[topDir];
			nextTopC += topDeltaC[topDir];
		}

		// 아래 돌리기
		while (nextBottomR != bottomR || nextBottomC != bottomC) {
			// 만약 범위 안에 있다면
			if (nextBottomR >= 0 && nextBottomR < R && nextBottomC >= 0 && nextBottomC < C) {
				// 먼지 밀어내기
				if (map[nextBottomR - bottomDeltaR[bottomDir]][nextBottomC - bottomDeltaC[bottomDir]] != -1) {
					temp[nextBottomR][nextBottomC] = map[nextBottomR - bottomDeltaR[bottomDir]][nextBottomC
							- bottomDeltaC[bottomDir]];
				}
			} else {
				// 범위를 벗어난다면 회전!!
				// 회전하기 전에 범위를 벗어났으니 다시 보정해주고
				nextBottomR -= bottomDeltaR[bottomDir];
				nextBottomC -= bottomDeltaC[bottomDir];
				// 다음 방향으로 바꿔주기
				bottomDir = (bottomDir + 1) % 4;
			}

			// 다음 좌표로 이동
			nextBottomR += bottomDeltaR[bottomDir];
			nextBottomC += bottomDeltaC[bottomDir];
		}

		topDir = 0;
		bottomDir = 0;

		nextTopR = topR + topDeltaR[topDir];
		nextTopC = topC + topDeltaC[topDir];

		nextBottomR = bottomR + bottomDeltaR[bottomDir];
		nextBottomC = bottomC + bottomDeltaC[bottomDir];

		// 위부터 돌리기
		while (nextTopR != topR || nextTopC != topC) {
			// 만약 범위 안에 있다면
			if (nextTopR >= 0 && nextTopR < R && nextTopC >= 0 && nextTopC < C) {
				// temp랑 바꿔치기
				map[nextTopR][nextTopC] = temp[nextTopR][nextTopC];
			} else {
				// 범위를 벗어난다면 회전!!
				// 회전하기 전에 범위를 벗어났으니 다시 보정해주고
				nextTopR -= topDeltaR[topDir];
				nextTopC -= topDeltaC[topDir];
				// 다음 방향으로 바꿔주기
				topDir = (topDir + 1) % 4;
			}

			// 다음 좌표로 이동
			nextTopR += topDeltaR[topDir];
			nextTopC += topDeltaC[topDir];
		}

		// 아래 돌리기
		while (nextBottomR != bottomR || nextBottomC != bottomC) {
			// 만약 범위 안에 있다면
			if (nextBottomR >= 0 && nextBottomR < R && nextBottomC >= 0 && nextBottomC < C) {
				map[nextBottomR][nextBottomC] = temp[nextBottomR][nextBottomC];
			} else {
				// 범위를 벗어난다면 회전!!
				// 회전하기 전에 범위를 벗어났으니 다시 보정해주고
				nextBottomR -= bottomDeltaR[bottomDir];
				nextBottomC -= bottomDeltaC[bottomDir];
				// 다음 방향으로 바꿔주기
				bottomDir = (bottomDir + 1) % 4;
			}

			// 다음 좌표로 이동
			nextBottomR += bottomDeltaR[bottomDir];
			nextBottomC += bottomDeltaC[bottomDir];
		}
	}

	public static void dust(int centerR, int centerC) {
		// 가운데 먼지 저장
		int centerDust = map[centerR][centerC];

		for (int d = 0; d < 4; d++) {
			int nextR = centerR + deltaR[d];
			int nextC = centerC + deltaC[d];

			// 범위안에 있고, 공기청정기가 아니라면
			if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && map[nextR][nextC] != -1) {
				// 가운데 먼지의 1/5
				int nextDust = centerDust / 5;
				// 확산 (가운데 정보가 뒤바뀌지 않게 일단 확산은 temp에 저장)
				temp[nextR][nextC] += nextDust;

				// 확산하고 중간은 빼준다.
				map[centerR][centerC] -= nextDust;
			}
		}
	}

	public static void printMap() {
		System.out.println("Map");
		System.out.println("---------------------------------------------------------");
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.printf("|  %-3d ", map[r][c]);
			}
			System.out.println("|");
			System.out.println("---------------------------------------------------------");
		}

		System.out.println();
	}

	public static void printTemp() {
		System.out.println("Temp");
		System.out.println("---------------------------------------------------------");
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.printf("|  %-3d ", temp[r][c]);
			}
			System.out.println("|");
			System.out.println("---------------------------------------------------------");
		}

		System.out.println();
	}

	public static void printCenter() {
		System.out.println("Center");
		System.out.println("---------------------------------------------------------");
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.printf("|  %-5b ", isCenter[r][c]);
			}
			System.out.println("|");
			System.out.println("---------------------------------------------------------");
		}

		System.out.println();
	}
}
