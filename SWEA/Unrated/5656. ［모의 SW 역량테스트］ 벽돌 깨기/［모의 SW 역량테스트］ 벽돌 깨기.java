import java.util.Scanner;

// 해야할일
// 조합도 구해야하느......... 오 마이 갓 
// 1. 재귀적으로 벽돌 깨기
// - 선택된 블록 -> 다른 블록에 영향가는지 보고 만약에 있다면 넘겨주고
// 2. 벽돌 다 깨고 정리하는 함수 만들기
// 3. 마지막으로 카운트 해주면 끝입니다. 

public class Solution {
	static int T, N, W, H;
	static int[][] map;
	static int[][] temp;
	static int[] selected;
	static int minCount;

	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			temp = new int[H][W];

			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			// 초기화
			selected = new int[N];
			minCount = W * H + 1;
			getTarget(0, 0);

			System.out.println("#" + t + " " + minCount);
		}
	}

	public static void getTarget(int start, int depth) {
		if (depth == N) {
			int count = 0;

			// 임시 배열에 deepcopy
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					temp[r][c] = map[r][c];
				}
			}

			// 여기서 이제 블록깨기 호출
			// 조합순으로 블록깨기
			for (int i = 0; i < selected.length; i++) {
				// 블록깨기
				out: for (int r = 0; r < H; r++) {
					if (temp[r][selected[i]] != 0) {
						targetBlock(r, selected[i]);
						break out;
					}
				}
				// 깨진 블록들 연결
				reArrange();
			}

			// 이제 최솟값 판별하기
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (temp[r][c] != 0) {
						count++;
					}
				}
			}

			if (count < minCount) {
				minCount = count;
			}

			return;
		}

		for (int i = 0; i < W; i++) {
			selected[depth] = i;
			getTarget(i + 1, depth + 1);
		}

	}

	public static void targetBlock(int r, int c) {
		// 블록 깨는 메소드
		int powerLimit = temp[r][c];
		int power = 1;

		temp[r][c] = 0; // 본인 블록 깨기

		// 만약 본인이 1이면 어짜피 돌지 않는다.
		while (power < powerLimit) {
			for (int d = 0; d < 4; d++) {
				int nextR = r + deltaR[d] * power;
				int nextC = c + deltaC[d] * power;

				// 범위 안에 있다면 ~
				if (nextR >= 0 && nextR < H && nextC >= 0 && nextC < W) {
					// 다음 블록 제거
					targetBlock(nextR, nextC);
				}
			}

			power++;
		}
	}

	public static void reArrange() {
		// 행 우선 탐색
		for (int c = 0; c < W; c++) {
			int[] tempRow = new int[H];
			int index = H - 1;
			for (int r = H - 1; r >= 0; r--) {
				if (temp[r][c] != 0) {
					tempRow[index--] = temp[r][c];
				}
			}

			for (int r = 0; r < H; r++) {
				temp[r][c] = tempRow[r];
			}
		}
	}

	public static void printMap() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				System.out.print(temp[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		System.out.println();
	}
}
