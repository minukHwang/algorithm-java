import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String pattern = sc.next();

			char[] letter = pattern.toCharArray();

			char first = letter[0];
			int index = 1;

			while(index < 10) {
				out: if(letter[index]==first) {
					for(int i = index; i < 10; i++) {
						if(letter[i%index] != letter[i]) {
							index = i;
							break out;
						}
					}
					break;
				}
				
				index++;
			}

			System.out.printf("#%d %d%n", t,index);

		}

	}
}
