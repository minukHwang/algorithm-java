import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M;
	static List<Integer>[] graph;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		for(int vertex : graph[v]) {
			if(!visited[vertex]) {
				dfs(vertex);
			}
		}
	}
}
