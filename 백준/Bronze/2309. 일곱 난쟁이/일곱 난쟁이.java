import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] heights = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();

			sum += heights[i];
		}

		sum -= 100;

		out: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (heights[i] + heights[j] == sum && i != j) {
					heights[i] = 0;
					heights[j] = 0;
					break out;
				}
			}
		}

		Arrays.sort(heights);
		int[] answer = Arrays.copyOfRange(heights, 2, heights.length);

		for (int i = 0; i < 7; i++) {
			System.out.println(answer[i]);
		}

		sc.close();
	}
}
