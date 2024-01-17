import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] switches = new int[n];

		for (int i = 0; i < n; i++) {
			switches[i] = sc.nextInt();
		}

		int students = sc.nextInt();

		for (int i = 0; i < students; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			if (gender == 1) {
				// 남자일 때
				for (int s = 1; s <= switches.length; s++) {
					if (s % num == 0) {
						switch (switches[s - 1]) {
						case 1:
							switches[s - 1] = 0;
							break;
						case 0:
							switches[s - 1] = 1;
							break;
						}
					}
				}

			} else if (gender == 2) {
				// 여자일 때
				int[] direction = { -1, 1 };
				int centerIndex = num - 1;
				int leftIndex = centerIndex + direction[0];
				int rightIndex = centerIndex + direction[1];

				switch (switches[centerIndex]) {
				case 1:
					switches[centerIndex] = 0;
					break;
				case 0:
					switches[centerIndex] = 1;
					break;
				}

				while (leftIndex >= 0 && rightIndex < n) {
					if (switches[leftIndex] == switches[rightIndex]) {

						switch (switches[leftIndex]) {
						case 1:
							switches[leftIndex] = 0;
							switches[rightIndex] = 0;
							break;
						case 0:
							switches[leftIndex] = 1;
							switches[rightIndex] = 1;
							break;
						}

						leftIndex += direction[0];
						rightIndex += direction[1];

					} else {
						break;
					}

				}
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.print(switches[i]);

			if (i != n - 1) {
				System.out.print(" ");
			}

			if (i % 20 == 19) {
				System.out.println();
			}
		}

		sc.close();

	}
}