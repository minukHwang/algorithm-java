import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] word1 = sc.nextLine().toCharArray();
		char[] word2 = sc.nextLine().toCharArray();
		
		int index = 0;
		int count = 0;
		
		while(index < word1.length - word2.length + 1) {
			boolean isAvailable = true;
			
			for(int i = 0; i < word2.length; i++) {
				if(word1[index + i] != word2[i]) {
					isAvailable = false;
					break;
				}
			}
			
			if(isAvailable) {
				index += word2.length;
				count++;
				continue;
			}
			
			index++;
		}
		
		System.out.println(count);
	}
}
