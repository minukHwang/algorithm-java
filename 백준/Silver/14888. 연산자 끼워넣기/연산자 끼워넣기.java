import java.util.Scanner;

public class Main {
	static int N;
	static int[] numbers;
	static char[] operators;
	static char[] operator = { '+', '-', '*', '/' };
	static int max;
	static int min;
	static char[] selected;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		numbers = new int[N];
		operators = new char[N - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		selected = new char[N - 1];
		checked = new boolean[N - 1];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		int index = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt();

			for (int j = 0; j < cnt; j++) {
				operators[index++] = operator[i];
			}
		}

		perm(0);

		System.out.println(max);
		System.out.println(min);
	}

	public static void perm(int depth) {
		if (depth == N - 1) {
			int answer = numbers[0];

			for (int i = 0; i < N - 1; i++) {
				switch (selected[i]) {
				case '+':
					answer += numbers[i + 1];
					break;
				case '-':
					answer -= numbers[i + 1];
					break;
				case '*':
					answer *= numbers[i + 1];
					break;
				case '/':
					answer /= numbers[i + 1];
					break;
				}
			}

			if (answer > max) {
				max = answer;
			}

			if (answer < min) {
				min = answer;
			}

			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (!checked[i]) {
				checked[i] = true;
				selected[depth] = operators[i];
				perm(depth + 1);
				checked[i] = false;
			}
		}
	}

}
