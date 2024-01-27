import java.util.Scanner;

/*
 * 문제 풀이
 * 1. 문자열을 읽어들인다.
 * 2. 카드 종류를 나누어서 13개의 길이를 가진 리스트를 만든다.
 * 3. 해당리스트에서 문자열에 포함된 카드는 ++를 해준다.
 * 4. 전체 리스트를 돌아보면서 필요한 카드를 파악하고 1이상이 있으면 에러 출력.
 */

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String line = sc.next();
			char[] info = line.toCharArray();

			int[] spade = new int[13];
			int[] diamond = new int[13];
			int[] heart = new int[13];
			int[] clover = new int[13];

			int num = 0;
			for (int i = 0; i < info.length; i += 3) {
				num = (info[i + 1] - '0') * 10 + (info[i + 2] - '0') - 1;
				switch (info[i]) {
				case 'S':
					spade[num]++;
					break;
				case 'D':
					diamond[num]++;
					break;
				case 'H':
					heart[num]++;
					break;
				case 'C':
					clover[num]++;
					break;
				}
			}
			int s = count(spade);
			int d = count(diamond);
			int h = count(heart);
			int c = count(clover);

			System.out.printf("#%d", t);
			if (s != -1 && d != -1 && h != -1 && c != -1) {
				System.out.printf(" %d %d %d %d%n", s, d, h, c);
			} else {
				System.out.print(" ERROR\n");
			}

		}

	}

	public static int count(int[] cardList) {
		int count = 13;
		for (int i = 0; i < cardList.length; i++) {
			if (cardList[i] == 1) {
				count--;
			} else if (cardList[i] > 1) {
				count = -1;
				break;
			}
		}

		return count;
	}
}
