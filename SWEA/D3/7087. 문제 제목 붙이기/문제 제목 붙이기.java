import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] alphabet = new int[26];
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				char letter = sc.next().toCharArray()[0];

				alphabet[letter - 'A'] += 1;
			}

			int count = 0;

			for (int i = 0; i < 26; i++) {
				if (alphabet[i] == 0) {
					break;
				}

				count++;
			}

			System.out.printf("#%d %d\n", t, count);

		}

	}
}
