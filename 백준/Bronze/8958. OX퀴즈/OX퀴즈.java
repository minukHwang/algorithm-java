import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String result = sc.next();
			char[] letter = result.toCharArray();

			int score = 0;
			int sum = 0;

			for (int j = 0; j < letter.length; j++) {
				if (letter[j] == 'O') {
					score++;
				} else {
					score = 0;
				}

				sum += score;
			}

			System.out.println(sum);
		}

	}
}