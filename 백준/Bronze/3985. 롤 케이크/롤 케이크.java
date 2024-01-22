import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();

		int n = sc.nextInt();

		int max1 = 0;
		int max2 = 0;

		int index1 = 0;
		int index2 = 0;

		int[] rc = new int[l];

		for (int i = 1; i <= n; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			int count = 0;

			int d = k - p;

			if (d > max1) {
				max1 = d;
				index1 = i;
			}

			for (int j = p; j <= k; j++) {
				if (rc[j - 1] == 0) {
					rc[j - 1] = i;
					count++;
				}
			}

			if (count > max2) {
				max2 = count;
				index2 = i;
			}

		}

		System.out.println(index1);
		System.out.println(index2);
	}
}
