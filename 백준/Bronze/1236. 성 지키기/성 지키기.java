import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][N];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(checkIsRowNeeded(r, c) && checkIsColNeeded(r, c)) {
					map[r][c] = 'X';
					count++;
//					printMap();
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(checkIsRowNeeded(r, c)) {
					map[r][c] = 'X';
					count++;
//					printMap();
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(checkIsColNeeded(r, c)) {
					map[r][c] = 'X';
					count++;
//					printMap();
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean checkIsRowNeeded(int currR, int currC) {
		boolean isNeeded = true;
		
		for(int r = 0; r < N; r++) {
			if(map[r][currC] == 'X') {
				isNeeded = false;
			}
		}
		
		return isNeeded;
	}
	
	public static boolean checkIsColNeeded(int currR, int currC) {
		boolean isNeeded = true;
		
		for(int c = 0; c < M; c++) {
			if(map[currR][c] == 'X') {
				isNeeded = false;
			}
		}
		
		return isNeeded;
	}
	
	public static void printMap() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
