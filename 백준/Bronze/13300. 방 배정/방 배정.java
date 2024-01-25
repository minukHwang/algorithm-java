import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 학생수
		int k = sc.nextInt(); // 한 방의 최대 인원
		
		double[][] students = new double[6][2]; 
		
		
		for(int i = 0; i < n; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt()-1;
			
			students[grade][gender]++;
		}
		
		int count = 0;
		
		for(int grade = 0; grade < 6; grade++) {
			for(int gender = 0; gender < 2; gender++) {
				int rooms = (int) Math.ceil(students[grade][gender]/k);
				count += rooms;
			}
		}
		
		System.out.println(count);
		
	}
}
