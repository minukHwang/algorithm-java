import java.util.Scanner;

class Egg {
	int durability;
	int weight;

	public Egg(int d, int w) {
		this.durability = d;
		this.weight = w;
	}

	public void fight(Egg other) {
		this.durability -= other.weight;
		other.durability -= this.weight;
	}

	public void restore(Egg other) {
		this.durability += other.weight;
		other.durability += this.weight;
	}
}

public class Main {
	static Egg[] eggs;
	static int n;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		eggs = new Egg[n];

		for (int i = 0; i < n; i++) {
			eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
		}

		solve(0);
		System.out.println(answer);

	}

	public static void solve(int pick) {
		// base case
		// 만약 가장 오른쪽 계란을 선택하였다면,
		if (pick == n) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				// 깨진 계란 카운트
				if (eggs[i].durability <= 0)
					count++;
			}
			answer = Math.max(answer, count);
			return;
		}

		// recursive case
		if (eggs[pick].durability > 0) {
			boolean targetExist = false;
			for (int target = 0; target < n; target++) {
				// 본인은 건너뛰고
				if (pick == target)
					continue;
				if (eggs[target].durability > 0) {
					targetExist = true;
					// 깨고
					eggs[pick].fight(eggs[target]);
					solve(pick + 1);
					eggs[pick].restore(eggs[target]);
				}
			}
			// 만약 아무도 없다면 그 다음으로 넘어가기
			if (!targetExist)
				solve(pick + 1);
		} else {
			solve(pick + 1);
		}

	}

}
