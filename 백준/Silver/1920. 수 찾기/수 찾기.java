import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			boolean ans = isExist(arr, num);
			sb.append(ans ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean isExist(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		while (right >= left) {
			int mid = (left + right) / 2;

			if (arr[mid] < num)
				left = mid + 1;
			else if (arr[mid] > num)
				right = mid - 1;
			else
				return true;
		}

		return false;
	}
}
