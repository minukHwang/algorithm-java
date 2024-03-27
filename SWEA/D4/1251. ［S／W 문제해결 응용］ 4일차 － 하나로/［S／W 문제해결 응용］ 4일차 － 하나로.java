/*
 * [문제 풀이 과정]
 * *크루스칼 알고리즘 구현*
 * 1. 정점의 정보들을 먼저 입력 받는다.
 * 2. 순열을 활용하여 간선들을 구하고 이를 리스트에 넣는다.
 * 
 * -------크루스칼---------
 * 3. 리스트를 간선의 정보 중 거리를 기준으로 정렬한다.
 * 4. 정렬된 간선을 탐색하면서, 만약 간선의 정점이 동일한 집합에 존재하는지 union-find 알고리즘으로 확인
 * 5. 동일한 집합에 존재한다면 -> 사이클을 형성, 존재하지 않다면 사이클을 형성하지 않으므로
 * 	  distance에 따른 전체 환경 부담금을 더해나간다.
 * 6. 최종적으로 출력하면 끝.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 정점 클래스
class Vertex {
	int idx;
	int x;
	int y;

	@Override
	public String toString() {
		return "#" + idx + " (" + x + ", " + y + ")";
	}
}

// 간선 클래스
class Edge implements Comparable<Edge> {
	Vertex A;
	Vertex B;
	double distance;

	Edge() {

	}

	Edge(Vertex A, Vertex B) {
		this.A = A;
		this.B = B;
		this.distance = getDistance(A, B);
	}

	private double getDistance(Vertex A, Vertex B) {
		int dx = A.x - B.x;
		int dy = A.y - B.y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	@Override
	public String toString() {
		return "Edge [A= " + A + ", B= " + B + ", distance=" + distance + "]";
	}

	// 간선을 정렬하는 기준은 distance
	@Override
	public int compareTo(Edge o) {
		// distance가 double이라 Double.compare 사용
		return Double.compare(this.distance, o.distance);
	}
}

public class Solution {
	static int T, N;
	static double cost;

	// 순열을 위한 정보
	static boolean[] visited;
	static Vertex[] selected;

	// 정점 배열, 간선 리스트
	static Vertex[] vertices;
	static List<Edge> edges;

	// union-find를 위한 parent 배열ㄴ
	static int p[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			vertices = new Vertex[N];

			for (int i = 0; i < N; i++) {
				vertices[i] = new Vertex();
				
				// 정점 넘버링 (추후 union-find를 위해서)ㄴ
				vertices[i].idx = i;

				// x좌표 설정
				int x = sc.nextInt();
				vertices[i].x = x;
			}

			for (int i = 0; i < N; i++) {
				// y좌표 설정ㄴ
				int y = sc.nextInt();
				vertices[i].y = y;
			}

			// 2차원 배열써도 무방하지만, 순열로 2개 정점 구해서 간선 리스트에 추가하기
			visited = new boolean[N];
			selected = new Vertex[2];
			edges = new ArrayList<>();

			perm(0, 0);

			cost = sc.nextDouble();

			// 크루스칼 1. 리스트 정렬 (방법 2개)
				// 1) Comparator
//				Collections.sort(edges, new Comparator<Edge>() {
//	
//					@Override
//					public int compare(Edge o1, Edge o2) {
//						return Double.compare(o1.distance, o2.distance);
//					}
//				});

				// 2) class내에 Comparable 사용 상단 참고
			Collections.sort(edges);

			// 크루스칼 2. 사이클이 발생안하게 간선 뽑기

			// 대표 배열 만들기
			p = new int[N];

			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			
			double answer = 0;
			int pick = 0;

			// 정렬된 간선 탐색
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);
				
				Vertex A = edge.A;
				Vertex B = edge.B;

				int pA = findSet(A.idx);
				int pB = findSet(B.idx);

				// 만약 다른 집합이라면
				if (pA != pB) {
					// 합치고, 환경 부담금 계산
					union(pA, pB);
					answer += cost * Math.pow(edge.distance, 2);
					pick++;
				}
				
				// 간선을 개수만큼 다 뽑았다면 끝내기 (시간 절약)
				if(pick == (N - 1)) {
					break;
				}
			}

			System.out.printf("#%d %.0f\n", t, answer);
		}
	}

	private static void union(int x, int y) {
		p[y] = x;

	}

	private static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}

		return p[x];
	}

	public static void perm(int start, int depth) {
		if (depth == 2) {
			Edge edge = new Edge(selected[0], selected[1]);
			edges.add(edge);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = vertices[i];
				perm(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}