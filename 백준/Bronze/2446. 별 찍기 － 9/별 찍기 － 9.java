import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int star = sc.nextInt();
		int stars = star*2-1;
		int count = 0;
		for(int i=0; i< stars; i++) {
			for(int j=1; j<=stars-count; j++) {

				
				if(j <= count) {
					System.out.printf(" ");
				} else {					
					System.out.printf("*");
				}
				
				
				if(j==stars-count) {
					System.out.printf("%n");
					break;
				}
			}
			if(i<star-1) {				
				count ++;
			} else {
				count --;
			}
		}
	}

}