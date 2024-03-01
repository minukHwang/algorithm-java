import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int K;
	static LinkedList<Integer>[] magnet;
	static int[] turn;
	static int left = 6;
	static int right = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		magnet = new LinkedList[4];

		for (int i = 0; i < 4; i++) {
			magnet[i] = new LinkedList<>();
		}

		for (int i = 0; i < 4; i++) {
			char[] magnetInfo = sc.next().toCharArray();
			for (int j = 0; j < 8; j++) {
				magnet[i].add(magnetInfo[j] - '0');
			}
		}

		K = sc.nextInt();

		// 자석 회전
		for (int k = 0; k < K; k++) {
			int magNum = sc.nextInt() - 1;
			int rotate = sc.nextInt();
			turn = new int[4];

			checkTurn(magNum, rotate);

			for (int i = 0; i < 4; i++) {
				if (turn[i] == 1) {
					int last = magnet[i].removeLast();
					magnet[i].addFirst(last);
				} else if (turn[i] == -1) {
					int first = magnet[i].removeFirst();
					magnet[i].addLast(first);
				}
			}

		}

		int score = 0;

		for (int i = 0; i < 4; i++) {
			if (magnet[i].get(0) == 1) {
				score += Math.pow(2, i);
			}
		}

		System.out.println(score);
	}

	public static void checkTurn(int magNum, int rotate) {
		// 회전 정보 입력
		turn[magNum] = rotate;
//		System.out.println(Arrays.toString(turn));

		int leftNum = magNum - 1;
		int rightNum = magNum + 1;

		// 범위 안에 있다면
		if (leftNum >= 0 && leftNum < 4) {
			// 왼쪽부터 확인
			if (turn[leftNum] == 0 && magnet[leftNum].get(right) != magnet[magNum].get(left)) {
				checkTurn(leftNum, rotate * (-1));
			}

		}

		if (rightNum >= 0 && rightNum < 4) {
			// 오른쪽 확인
			if (turn[rightNum] == 0 && magnet[rightNum].get(left) != magnet[magNum].get(right)) {
				checkTurn(rightNum, rotate * (-1));
			}
		}

	}
}
