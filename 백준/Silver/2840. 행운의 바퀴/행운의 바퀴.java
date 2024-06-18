import java.util.*;

public class Main {
	static int N, K;
	static char[] wheel;
	static int pointer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		K = sc.nextInt();

		wheel = new char[N];
		Arrays.fill(wheel, '?');

		pointer = 0;

		boolean isAvailable = true;

		for (int i = 0; i < K; i++) {
			int change = sc.nextInt();
			char letter = sc.next().charAt(0);

			pointer = (pointer + change) % N;

			if (wheel[pointer] != '?' && wheel[pointer] != letter) {
				isAvailable = false;
				break;
			}

			wheel[pointer] = letter;
		}

		if (isAvailable) {
			char[] alpha = new char['Z' - 'A' + 1];
			for (int i = 0; i < wheel.length; i++) {
				if(wheel[i] != '?')
					alpha[wheel[i] - 'A']++;
			}

			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] > 1) {
					isAvailable = false;
					break;
				}
			}
		}

		if (isAvailable) {
			int shift = N;
			while (shift > 0) {
				int current = (pointer + shift) % N;
				sb.append(wheel[current]);

				shift--;
			}
		} else {
			sb.append("!");
		}

		System.out.println(sb);
	}
}
