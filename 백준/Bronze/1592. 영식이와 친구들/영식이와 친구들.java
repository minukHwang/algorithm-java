import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		int[] table = new int[n];
		int indexBall = 0;
		int count = 0;

		while (true) {
			table[indexBall]++;

			if (table[indexBall] == m) {
				break;
			}

			if (table[indexBall] % 2 == 1) {
				// 홀수
				indexBall += l;
				if (indexBall > table.length - 1) {
					indexBall -= table.length;
				}
			} else {
				// 짝
				indexBall -= l;
				if (indexBall < 0) {
					indexBall += table.length;
				}
			}

			count++;
		}

		System.out.println(count);

	}
}
