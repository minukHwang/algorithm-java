import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String message = sc.next();
		
		char[] letters = message.toCharArray();
		int n = letters.length;
		int c = 0;
		int r = 0;
		
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				r = i;
				c = n/i;
			}
		}
		
		char[][] map = new char[r][c];
		int index = 0;
		String answer = "";
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				map[j][i] = letters[index];
				index++;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {				
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
}
