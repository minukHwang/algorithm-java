
import java.util.Scanner;

public class Main {
	static int N;
	static int[] queen;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		queen = new int[N];

		System.out.println(solve(0));
	}

	static int solve(int row) {
		int count = 0;
		// 기저 조건
		if (row == N) {
			return 1;
		}

		for (int col = 0; col < N; col++) {
			if (isAvailable(row, col)) {
				queen[row] = col;
				count += solve(row + 1);
			}
		}

		return count;
	}

	static boolean isAvailable(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (queen[i] == col) {
				return false;
			}

			if (Math.abs(row - i) == Math.abs(col - queen[i])) {
				return false;
			}
		}

		return true;
	}

}
