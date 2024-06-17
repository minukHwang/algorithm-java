import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;

	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new char[N][N];
		max = 0;

		for (int r = 0; r < N; r++) {
			map[r] = sc.next().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				if(map[r][c] != map[r][c+1]) {					
					char temp = map[r][c];
					
					map[r][c] = map[r][c + 1];
					map[r][c + 1] = temp;
					
					eat();
					
					map[r][c + 1] = map[r][c];
					map[r][c] = temp;
					
				}
			}
		}

		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N - 1; r++) {
				if(map[r][c] != map[r + 1][c]) {	
					char temp = map[r][c];
	
					map[r][c] = map[r + 1][c];
					map[r + 1][c] = temp;
	
					eat();
	
					map[r + 1][c] = map[r][c];
					map[r][c] = temp;
				}
			}
		}
		
		System.out.println(max);
	}

	public static void eat() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				char start = map[r][c];
				int count = 1;
				
				for(int i = 1; i < N - c; i++) {
					if(map[r][c + i] != start) {
						break;
					}
					
					count++;
				}
				
				max = Math.max(count, max);
			}
		}
		
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N - 1; r++) {
				char start = map[r][c];
				int count = 1;
				
				for(int i = 1; i < N - r; i++) {
					if(map[r + i][c] != start) {
						break;
					}
					
					count++;
				}
				
				max = Math.max(count, max);
			}
		}
	}
	
	public static void printMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
