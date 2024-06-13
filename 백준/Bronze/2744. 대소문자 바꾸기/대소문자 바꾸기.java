// 아스키 코드 복습 문제

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String word = sc.next();
		
		char[] letters = word.toCharArray();
		
		int diff = 'a' - 'A';
		
		// 대문자 먼저, 그 다음 소문자
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] > 'Z') {
				// 소문자 -> 대문자로
				sb.append((char) (letters[i] - diff));
			}
			
			if(letters[i] < 'a') {
				// 대문자 -> 소문자로
				sb.append((char) (letters[i] + diff));
			}
		}
		
		System.out.println(sb);
	}
}
