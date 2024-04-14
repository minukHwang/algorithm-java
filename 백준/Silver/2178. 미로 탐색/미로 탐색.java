import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coord{
	int r;
	int c;
	int count;
	
	Coord(){
		
	}
	
	Coord(int r, int c, int count){
		this.r = r;
		this.c = c;
		this.count = count;
	}

	@Override
	public String toString() {
		return "#"+ count + "[" + r + ", " + c + "] ";
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;

		bfs(0, 0, 1);
		
		System.out.println(min);
	}

	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };
	static Queue<Coord> queue;

	private static void bfs(int r, int c, int count) {
		visited[r][c] = true;
		queue = new LinkedList<>();
		queue.add(new Coord(r, c, count));
		
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			Coord curr = queue.poll();
			
			if(curr.r == N-1 && curr.c == M-1) {
				min = curr.count;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = curr.r + deltaR[d];
				int nc = curr.c + deltaC[d];
				
				if(isNotOutBound(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new Coord(nr, nc, curr.count + 1));
				}
			}
		}
		
		
	}

	private static boolean isNotOutBound(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
