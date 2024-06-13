import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int alphaCount = 'z' - 'a' + 1;

		int[] count1 = new int[alphaCount];
		int[] count2 = new int[alphaCount];

		String word1 = sc.next();
		String word2 = sc.next();

		for (int i = 0; i < word1.length(); i++) {
			int letter = word1.charAt(i) - 'a';

			count1[letter]++;
		}

		for (int i = 0; i < word2.length(); i++) {
			int letter = word2.charAt(i) - 'a';
			
			count2[letter]++;
		}
		
		for (int i = 0; i < count1.length; i++) {
			if(count1[i] > 0 && count2[i] > 0) {
				if(count1[i] > count2[i]) {
					count1[i] -= count2[i];
					count2[i] = 0;
				} else {
					count2[i] -= count1[i];
					count1[i] = 0;
				}
			}
		}
		
		int total = 0;
		
		for (int i = 0; i < count1.length; i++) {
			total += count1[i] + count2[i];
		}
		
		System.out.println(total);
	}
}
