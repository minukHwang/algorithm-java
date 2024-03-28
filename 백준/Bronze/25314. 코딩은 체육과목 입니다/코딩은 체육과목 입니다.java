import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int count = n / 4;
		
		for(int i = 0; i < count; i++) {
			sb.append("long ");
		}
		
		sb.append("int");
		
		System.out.println(sb);
	}
}
