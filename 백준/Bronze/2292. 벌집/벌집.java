import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt()-1;
		int d = 1;
		
		while(true) {			
			if(n >= 3*(d-1)*(d-2) && n <= 3*d*(d-1)) {
				break;
			}
			d++;
		}
		
		System.out.println(d);
	}
}
