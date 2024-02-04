import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int day = sc.nextInt();
			int month = sc.nextInt();
			int threeMonths = sc.nextInt();
			int year = sc.nextInt();

			int[] schedule = new int[13];

			for (int i = 1; i < 13; i++) {
				schedule[i] = sc.nextInt();
			}

			// dp로 풀기 위해서는 일단 점화식 + 메모이제이션
			// 점화식은 다음과 같이 생각 가능
			// n번째 달 =
			// n-1 최소 + 1일권
			// n-1 최소 + 1달권
			// n-3 최소 + 3달권
			// n-12 최소 + 1년권 -> 사실 이건 그냥 1년권.
			// 이중에서 최소의 값을 구하면 됨.

			int[] minCost = new int[13];
			minCost[1] = Math.min(schedule[1] * day, month); // 첫달은 하루권 아니면 한달권 중 최소!

			for (int i = 2; i < 13; i++) {
				minCost[i] = Math.min(minCost[i - 1] + schedule[i] * day, minCost[i - 1] + month);
				
				if (i >= 3) {
					minCost[i] = Math.min(minCost[i], minCost[i - 3] + threeMonths);
				}

				if (i % 12 == 0) {
					minCost[i] = Math.min(minCost[i], year);
				}
			}
			System.out.printf("#%d %d\n", t, minCost[12]);
		}
	}
}
