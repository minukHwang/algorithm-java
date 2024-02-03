/*
 * 문제 풀이 과정
 * 1. 문자열을 입력 받아서 2차원 배열로 만들어준다. 
 * 2. 주어진 회문의 길이가 짝수 홀수에 따라서 조건을 달리한다.
 * 	 - 짝수 : 두칸 연속으로 같은 지점이 나타난다면 그 지점부터 양 옆으로 같은 지점이 몇개인지 파악
 * 	 - 홀수 : 한칸을 건너뛰고 같은 지점이 나타난다면 그 지점부터 양 옆으로 같은 지점이 몇개인지 파악
 * 3. 문제 조건에서 주어지는 길이와 같은지 확인하고 카운트하여 출력한다. 
 */


import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t <= 10; t++) {
			int count = 0;
			
			// 문자열 -> 2차원 배열
			int n = sc.nextInt();
			char[][] map = new char[8][];
			
			for(int i = 0; i < 8; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			// 짝수 홀수이냐에 따라서 다른 메소드
			if(n%2 == 0) {
				count = evenPalindrome(map, n);
			} else {
				count = oddPalindrome(map, n);
			}
			
			// 출력
			System.out.printf("#%d %d\n", t, count);
		}

		sc.close();
	}
	
	public static int evenPalindrome(char[][] map, int n) {
		int count = 0;
		
		// 짝수 행 탐색
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 7; c++) {
				// 만약 양옆으로 같은 지점이 나온다면.
				if(map[r][c]==map[r][c+1]) {
					// 왼쪽 오른쪽을 기준삼아 이동시켜주고
					int left = c;
					int right = c + 1;
					
					int length = 0;
					
					while(left >= 0 && right < 8 && map[r][left] == map[r][right] ) {
						length += 2;
						
						//문제에서 원하는 길이가 나오면 카운트
						if(length == n) {
							count++;
							break;
						}
						
						left--;
						right++;
					}
				}
			}
		}
		
		// 짝수 열 탐색
		for(int c = 0; c < 8; c++) {
			for(int r = 0; r < 7; r++) {
				// 만약 위 아래로 같은 지점이 나온다면.
				if(map[r][c]==map[r+1][c]) {
					// 위쪽 아래쪽을 기준삼아 이동시켜주고
					int top = r;
					int bottom = r + 1;
					int length = 0;
					
					while(top >= 0 && bottom < 8 && map[top][c] == map[bottom][c] ) {
						length += 2;
						
						//문제에서 원하는 길이가 나오면 카운트
						if(length == n) {
							count++;
							break;
						}
						
						top--;
						bottom++;
					}
				}
			}
		}
		
		
		return count;
	}
	
	public static int oddPalindrome(char[][] map, int n) {
		int count = 0;
		
		// 홀수 행 탐색
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 6; c++) {
				// 만약 한칸 건너 옆으로 같은 지점이 나온다면.
				if(map[r][c]==map[r][c+2]) {
					// 왼쪽 오른쪽을 기준삼아 이동시켜주고
					int left = c;
					int right = c + 2;
					int length = 1;
					
					while(left >= 0 && right < 8 && map[r][left] == map[r][right] ) {
						length += 2;
						
						//문제에서 원하는 길이가 나오면 카운트
						if(length == n) {
							count++;
							break;
						}
						
						left--;
						right++;
					}
				}
			}
		}
		
		// 홀수 열 탐색
		for(int c = 0; c < 8; c++) {
			for(int r = 0; r < 6; r++) {
				// 만약 한칸 건너 위 아래로 같은 지점이 나온다면.
				if(map[r][c]==map[r+2][c]) {
					// 위쪽 아래쪽을 기준삼아 이동시켜주고
					int top = r;
					int bottom = r + 2;
					int length = 1;
					
					while(top >= 0 && bottom < 8 && map[top][c] == map[bottom][c] ) {
						length += 2;
						
						//문제에서 원하는 길이가 나오면 카운트
						if(length == n) {
							count++;
							break;
						}
						
						top--;
						bottom++;
					}
				}
			}
		}
		
		
		return count;
	}
}