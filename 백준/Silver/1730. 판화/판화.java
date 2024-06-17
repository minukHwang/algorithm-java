import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static String move;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		move = sc.hasNext() ? sc.next() : ""; // 이거 중요

		map = new char[N][N];

		for (int r = 0; r < N; r++) {
			Arrays.fill(map[r], '.');
		}

		moveRobot();

		printMap();
	}

	private static void moveRobot() {
		int currR = 0;
		int currC = 0;

		for (int i = 0; i < move.length(); i++) {
			char dir = move.charAt(i);
			char current = map[currR][currC];

			int nextR = currR;
			int nextC = currC;

			// 다음 방향을 지정한다.
			switch (dir) {
			case 'U':
				nextR += -1;
				break;
			case 'D':
				nextR += 1;
				break;
			case 'L':
				nextC += -1;
				break;
			case 'R':
				nextC += 1;
				break;
			}

			// 만약에 밖으로 나가는 명령이라면 무시
			if (isOutBound(nextR, nextC)) {
				continue;
			}

			char next = map[nextR][nextC];
			
			// 선을 그려준다.
			if (dir == 'U' || dir == 'D') {
				if (current == '.') {
					current = '|';
				}

				if (current == '-') {
					current = '+';
				}
				
				if (next == '.') {
					next = '|';
				}

				if (next == '-') {
					next = '+';
				}
			}

			if (dir == 'L' || dir == 'R') {
				if (current == '.') {
					current = '-';
				}

				if (current == '|') {
					current = '+';
				}
				
				if (next == '.') {
					next = '-';
				}

				if (next == '|') {
					next = '+';
				}
			}
			
			map[currR][currC] = current;
			map[nextR][nextC] = next;

			currR = nextR;
			currC = nextC;
		}
	}

	private static boolean isOutBound(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= N;
	}

	public static void printMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
}
