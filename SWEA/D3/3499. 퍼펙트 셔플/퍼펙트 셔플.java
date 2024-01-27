import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			sc.nextLine();

			int firstLength;
			int secondLength;

			if (n % 2 == 0) {
				firstLength = n / 2;
				secondLength = n / 2;
			} else {
				firstLength = n / 2 + 1;
				secondLength = n / 2;
			}

			String[] cards = sc.nextLine().split(" ");
			String[] firstHalf = new String[firstLength];
			String[] secondHalf = new String[secondLength];

			System.arraycopy(cards, 0, firstHalf, 0, firstLength);
			System.arraycopy(cards, firstLength, secondHalf, 0, secondLength);

			System.out.printf("#%d ", t);
			for (int i = 0; i < secondLength; i++) {
				if (n % 2 == 0 && i == secondLength - 1) {
					System.out.print(firstHalf[i] + " ");
					System.out.print(secondHalf[i] + "\n");
					break;
				}
				
				if(n%2 == 1 && i == secondLength -1) {
					System.out.print(firstHalf[i] + " ");
					System.out.print(secondHalf[i] + " ");
					System.out.print(firstHalf[i+1] +"\n");
					break;
				}
				
				System.out.print(firstHalf[i] + " ");
				System.out.print(secondHalf[i] + " ");
			}
		}

	}
}
