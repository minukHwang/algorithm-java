/*
 * [문제 풀이 과정]
 * 1. 정점, 간선 정보 입력 받고 인접 리스트 만들기.
 * 2. 시작 정점에서 bfs
 * 3. bfs 순회하면서 visited 배열에 본인의 회차를 누적하면서 할당
 * 	- visited 배열을 int 배열로 만들고, 0이 아니라면 방문한 것으로 가정
 * 	- 처음 정점에는 visited에 1을 할당
 * 	- 큐에 넣고 pop 할 때 count 값을 visited 안에 있는 숫자로 할당
 * 	- 다음 정점을 queue에 넣을 때 count값에 +1을 한 값을 visited에 할당
 * 4. 가장 마지막 그룹의 숫자를 파악하고 해당 visited 값을 가지고 있는 숫자들 중 max 값을 구하고 출력.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, start;
	static List<Integer>[] list;
	static int visited[];
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#"+ t +" ");
			
			N = sc.nextInt();
			start = sc.nextInt();

			list = new ArrayList[101];

			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < (N / 2); i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				list[from].add(to); // 양방향 아님
			}

			visited = new int[101];

			int max = bfs(start);
			int answer = -1;

			for (int i = 0; i < 101; i++) {
				if(visited[i] == max) {
					answer = Math.max(answer, i);
				}
			}

			
			sb.append(answer+"\n");
		}
		
		System.out.println(sb);
	}

	private static int bfs(int node) {
		int max = -1;

		visited[node] = 1;

		queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			int count = visited[current];

			max = Math.max(max, count);

			for (int next : list[current]) {
				if (visited[next] == 0) {
					visited[next] = count + 1;
					queue.add(next);
				}
			}
		}

		return max;
	}
}