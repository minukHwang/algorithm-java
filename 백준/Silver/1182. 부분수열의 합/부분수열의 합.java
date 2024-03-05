import java.util.Scanner;

public class Main {
	static int N, S;
	static int[] nums;
	static boolean[] checked;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt(); // 그 수의 합이 S가 되는 경우의 수
		nums = new int[N];
		checked = new boolean[N];
		count = 0;

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		subset(0);

		System.out.println(count);
	}

	public static void subset(int index) {
		if (index == N) {
			int total = 0;
			int falseCount = 0;

			for (int i = 0; i < N; i++) {
				if (checked[i]) {
					total += nums[i];
				} else {
					falseCount++;
				}
			}

			if (total == S && falseCount < N) {
				count++;
			}

			return;
		}

		checked[index] = true;
		subset(index + 1);
		checked[index] = false;
		subset(index + 1);
	}
}
