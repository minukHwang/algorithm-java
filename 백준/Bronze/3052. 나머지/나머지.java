import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		int[] many = new int[10];

		int total = 0;

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt() % 42;
		}

		for (int i = 0; i < 10; i++) {
			for (int j = i; j < 10; j++) {
				if (arr[i] == arr[j] && i != j) {
					arr[j] = -1;
				}
			}
		}


		for (int i = 0; i < 10; i++) {
			if (arr[i] != -1) {
				total++;
			}
		}

		System.out.println(total);

	}
}
