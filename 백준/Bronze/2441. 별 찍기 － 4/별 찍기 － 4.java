import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int star = sc.nextInt();
		int count = 0;
		for(int i=0; i< star; i++) {
			int blank = count;
			for(int j=0; j<star; j++) {

				
				if(blank>0) {
					System.out.printf(" ");
					blank --;
				} else {					
					System.out.printf("*");
				}
				
				
				if(j==star-1) {
					System.out.printf("%n");
					break;
				}
			}
			count ++;
		}
	}

}