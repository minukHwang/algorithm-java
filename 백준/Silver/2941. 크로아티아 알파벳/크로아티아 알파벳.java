import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] alpha = { { 'c', '=' }, { 'c', '-' }, { 'd', 'z', '=' }, { 'd', '-' }, { 'l', 'j' }, { 'n', 'j' },
				{ 's', '=' }, { 'z', '=' } };

		int count = 0;
		int index = 0;
		String word = sc.next();

		char[] letter = word.toCharArray();

		while (index < letter.length) {

			// 첫 글자 비교
			for (int i = 0; i < alpha.length; i++) {
				if (letter[index] == alpha[i][0] && index <= letter.length - alpha[i].length) {

					int same = 1;

					// 그 다음 비교
					for (int j = 1; j < alpha[i].length; j++) {
						if (letter[index + j] == alpha[i][j]) {
							same++;
						}
					}

					if (same == alpha[i].length) {
						index += alpha[i].length - 1;
						break;
					}

				}
			}

			index++;
			count++;
		}

		System.out.println(count);
	}
}
