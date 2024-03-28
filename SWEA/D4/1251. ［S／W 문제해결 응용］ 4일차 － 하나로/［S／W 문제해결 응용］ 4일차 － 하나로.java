/*
 * [문제 풀이 과정]
 * *프림 알고리즘 구현*
 * 1. 정점의 정보들을 먼저 입력 받는다.
 * 2. 조합을 활용하여 간선들을 구하고 이를 리스트 배열 정점 index에 맞게 넣는다.
 * 
 * -------프림---------
 * 3. 방문 배열과 PriorityQueue를 만든다.
 * 4. 0에서 시작하는 모든 간선을 pq에 넣는다.
 * 5. pq가 다 비워질 때까지 반복하면서 pq에서 간선을 poll하고, 만약 간선의 종점이 방문처리 되었다면 continue
 * 	  아니라면, 해당 간선의 거리의 값을 통해서 환경 부담금을 계산한다. (또한, 해당 간선의 종점 방문 처리)
 * 6. 간선의 종점에서 출발하는 다른 간선들 중 종점이 방문 처리 되지 않는 간선들을 다시 pq에 넣는다. (이 과정까지를 반복)
 * 7. 최종적으로 구해진 답을 출력한다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertex {
	int idx;
	int x;
	int y;
}

class Edge implements Comparable<Edge> {
	Vertex start;
	Vertex end;
	double distance;

	Edge() {

	}

	public Edge(Vertex start, Vertex end) {
		this.start = start;
		this.end = end;
		this.distance = getDistance(start, end);
	}

	private double getDistance(Vertex start, Vertex end) {
		return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.distance, o.distance);
	}
}

public class Solution {
	static int T, N;
	static Vertex[] vertices;
	static List<Edge>[] edges;
	
	static boolean checked[];
	static Vertex[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			vertices = new Vertex[N];
			
			for (int i = 0; i < N; i++) {
				vertices[i] = new Vertex();

				vertices[i].idx = i;
				vertices[i].x = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				vertices[i].y = sc.nextInt();
			}

			edges = new ArrayList[N];
			
			for(int i = 0; i < N; i++) {
				edges[i] = new ArrayList<>();
			}
			
			double cost = sc.nextDouble();
			
			checked = new boolean[N];
			selected = new Vertex[2];
			
			com(0, 0);
			
			boolean[] visited = new boolean[N];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			visited[0] = true;
			pq.addAll(edges[0]);
			
			double answer = 0;
			
			while(!pq.isEmpty()) {
				Edge current = pq.poll();
				Vertex currentEnd = current.end;
				
				if(visited[currentEnd.idx]) continue;
				
				answer += cost * Math.pow(current.distance, 2);
				visited[currentEnd.idx] = true;
				
				for(Edge edge: edges[currentEnd.idx]) {
					if(!visited[edge.end.idx]) {
						pq.add(edge);
					}
				}
			}
			
			System.out.printf("#%d %.0f\n", t, answer);
		}
	}
	
	private static void com(int start, int depth) {
		if (depth == 2) {
			Vertex A = selected[0];
			Vertex B = selected[1];
			
			edges[A.idx].add(new Edge(A, B));
			edges[B.idx].add(new Edge(B, A));
			
			return;
		}

		for (int i = start; i < N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				selected[depth] = vertices[i];
				com(i + 1, depth + 1);
				checked[i] = false;
			}
		}
	}
}