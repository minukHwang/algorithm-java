import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		double seats = 1;

		char[] arr = str.toCharArray();

		for (int i = 0; i < n; i++) {
			if (arr[i] == 'S') {
				seats += 1;
			} else {
				seats += 0.5;
			}

			if (seats == n) {
				break;
			}
		}

		System.out.println((int) seats);

	}
}
