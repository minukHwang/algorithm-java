import java.util.Scanner;

// 줄기세포 정의하기
class Cell {
	boolean isCell;
	boolean isDead;
	int time;
	int power;
	int nowTime;

	Cell() {
		isCell = false;
		isDead = false;
		time = 0;
		power = 0;
		nowTime = 0;
	}

	Cell(int time, int power) {
		this.isCell = false;
		this.isDead = false;
		this.time = time;
		this.power = power;
		this.nowTime = 0;
	}

	@Override
	public String toString() {
		return "" + power;
	}

}

public class Solution {
	static int T;
	static int N;
	static int M;
	static int K;
	static Cell[][] map;
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new Cell[N + K][M + K];

			for (int r = 0; r < N + K; r++) {
				for (int c = 0; c < M + K; c++) {
					map[r][c] = new Cell();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 생명력 부하
					map[K / 2 + r][K / 2 + c].power = sc.nextInt();

					if (map[K / 2 + r][K / 2 + c].power != 0) {
						// 시간 부하
						map[K / 2 + r][K / 2 + c].time = map[K / 2 + r][K / 2 + c].power * 2;
						// 세포인지 아닌지
						map[K / 2 + r][K / 2 + c].isCell = true;
					}
				}
			}

			// K 시간 동안
			for (int i = 0; i < K + 1; i++) {
				// 탐색 시작
				for (int r = 0; r < N + K; r++) {
					for (int c = 0; c < M + K; c++) {
						// 세포인 경우만 작용 & 안죽었다면
						if (map[r][c].isCell == true && map[r][c].isDead == false) {

							// 만약 활성 상태라면 (시간에 2배를 해줬기 때문에)
							if (map[r][c].time == map[r][c].power) {
								// 퍼지기 (사방 탐색)
								for (int d = 0; d < 4; d++) {
									// 다음 좌표
									int nextR = r + deltaR[d];
									int nextC = c + deltaC[d];

									// 다음 좌표 죽지 않은 세포라면
									if (map[nextR][nextC].isDead == false) {

										// 만약 빈 공간이라면
										if (map[nextR][nextC].isCell == false) {
											// 세포로 만들고
											map[nextR][nextC].isCell = true;

											// 생명력 복사
											map[nextR][nextC].power = map[r][c].power;

											// 시간 복사
											map[nextR][nextC].time = map[r][c].power * 2;

											map[nextR][nextC].nowTime = i;
										}

										// 빈 공간이 아니라면?
										else {
											// 나보다 힘이 약하고 만약 isNow가 지금 시간이라면?
											if (map[nextR][nextC].power < map[r][c].power
													&& map[nextR][nextC].nowTime == i) {

												// 생명력 복사
												map[nextR][nextC].power = map[r][c].power;

												// 시간 복사
												map[nextR][nextC].time = map[r][c].power * 2;
											}
										}
									}
								}

							}

							// 1. 시간 깎아주기 가장 마지막에 해주면 됩니다.
							if (map[r][c].nowTime != i) {
								map[r][c].time--;
							}

							if (map[r][c].time == 0) {
								map[r][c].isDead = true;
							}

						}
					}
				}
//				System.out.println("시간: " + i);
//				printMap();
//				System.out.println("-------------------------------------");
//				System.out.println();
			}

			int count = 0;
			for (int r = 0; r < N + K; r++) {
				for (int c = 0; c < M + K; c++) {
					if (map[r][c].isCell == true && map[r][c].isDead == false) {
						count++;
					}
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

	public static void printMap() {
		for (int r = 0; r < N + K; r++) {
			for (int c = 0; c < M + K; c++) {
				System.out.printf(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
