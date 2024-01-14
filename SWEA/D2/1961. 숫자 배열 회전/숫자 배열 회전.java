import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //Test Case
		for(int t = 1; t <= T; t++) {
			
			int n = sc.nextInt(); // n*n의 갯수
			String nullString = sc.nextLine();
			
			int [][] numbers = new int [n][n]; //2차원 배열 초기화
			int [][] output = new int [n*n][n];
			
			//리스트 입력
			for(int i = 0; i < n; i++) {
				String [] str = sc.nextLine().split(" ");
				for(int j = 0; j < n; j++) {
					numbers[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			//회전
			for(int r = 0; r < 3; r++) {
				int [][] temp = new int [n][n];
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						temp[j][i] = numbers[n-i-1][j];
					}
					output[r+(i*3)] = temp[i];
				}
				numbers = temp;
			}
			
			//출력
			System.out.printf("#%d%n", t);
			for(int i = 0; i < n*3; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(output[i][j]);
					if(i%3!=2 && j == n-1) {
						System.out.print(" ");
					}
				}
				if(i%3==2) {
					System.out.printf("%n");
				}
			}
		}
		sc.close();
	}
}