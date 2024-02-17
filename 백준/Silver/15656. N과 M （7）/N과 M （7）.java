import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	static int[] numbers;
	static int[] selNum;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[N];
		selNum = new int[M];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		Arrays.sort(numbers);

		perm(0);
		System.out.print(sb);

	}

	public static void perm(int depth) {
		if (depth == M) {
			for (int i = 0; i < selNum.length - 1; i++) {
				sb.append(selNum[i]).append(" ");
			}
			sb.append(selNum[selNum.length - 1]).append("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			selNum[depth] = numbers[i];
			perm(depth + 1);
		}

	}
}
