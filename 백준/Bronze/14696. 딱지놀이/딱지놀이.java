import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int alength = sc.nextInt();
			List<Integer> aCards = new ArrayList<Integer>();

			for (int a = 0; a < alength; a++) {
				aCards.add(sc.nextInt());
			}

			int blength = sc.nextInt();
			List<Integer> bCards = new ArrayList<Integer>();

			for (int b = 0; b < blength; b++) {
				bCards.add(sc.nextInt());
			}

			Collections.sort(aCards, Collections.reverseOrder());
			Collections.sort(bCards, Collections.reverseOrder());


			int index = 0;
			char answer = 'D';

			while (index < Math.min(alength, blength)) {
				if (aCards.get(index) == bCards.get(index)) {
					index++;
					if (index == Math.min(alength, blength)) {
						if (alength > blength) {
							answer = 'A';
						} else if (alength < blength) {
							answer = 'B';
						}
					}
					continue;
				}

				else if (aCards.get(index) > bCards.get(index)) {
					answer = 'A';
					break;
				} else if (bCards.get(index) > aCards.get(index)) {
					answer = 'B';
					break;
				}
			}

			System.out.println(answer);
		}

	}
}
