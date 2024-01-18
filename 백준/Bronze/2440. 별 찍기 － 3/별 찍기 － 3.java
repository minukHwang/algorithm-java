import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = n; i > 0; i--) {
			int cnt = i;
			while(cnt != 0) {
				System.out.printf("%s","*");
				cnt--;
			}
			System.out.println();
		}
	}
}
