import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//tc 입력
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int answer = 1;
			String [] correct = {"INCORRECT", "CORRECT"};
			
			int [][] sudoku = new int [9][9];
			
			//스도쿠 입력
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			
			//3*3 탐색
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					int [] arr = new int[9];
					for(int k=0; k<3; k++) {
						for(int l=0; l<3; l++) {
							arr[sudoku[k+3*i][l+3*j]-1] += 1;
							
							if(arr[sudoku[k+3*i][l+3*j]-1]>1) {
								answer = 0;
								break;
							}
						}
					}
				}
			}
			
			// 가로 탐색
			for(int i=0; i<9; i++) {
				int [] arr = new int [9];
				for(int j=0; j<9; j++) {
					arr[sudoku[i][j]-1] += 1;
					if(arr[sudoku[i][j]-1] > 1) {
						answer=0;
						break;
					}
				}
			}
			
			// 세로 탐색
			for(int i=0; i<9; i++) {
				int [] arr = new int [9];
				for(int j=0; j<9; j++) {
					arr[sudoku[j][i]-1] += 1;
					if(arr[sudoku[j][i]-1] > 1) {
						answer=0;
						break;
					}
				}
			}
			
			System.out.printf("Case %d: %s%n", t, correct[answer]);
		}
		sc.close();
	}
}