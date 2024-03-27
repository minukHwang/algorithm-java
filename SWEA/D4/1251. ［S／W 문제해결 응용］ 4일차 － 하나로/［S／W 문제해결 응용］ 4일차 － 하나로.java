import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Vertex {
	int idx;
	int x;
	int y;

	Vertex() {

	}

	Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "#" + idx + " (" + x + ", " + y + ")";
	}
}

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

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.distance, o.distance);
	}
}

public class Solution {
	static int T, N;
	static Vertex[] vertices;

	static boolean[] visited;
	static Vertex[] selected;

	static List<Edge> edges;

	static double cost;

	static int p[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			vertices = new Vertex[N];

			for (int i = 0; i < N; i++) {
				vertices[i] = new Vertex();
				vertices[i].idx = i;

				int x = sc.nextInt();
				vertices[i].x = x;
			}

			for (int i = 0; i < N; i++) {
				int y = sc.nextInt();
				vertices[i].y = y;
			}

			visited = new boolean[N];
			selected = new Vertex[2];
			edges = new ArrayList<>();

			cost = sc.nextDouble();

			perm(0, 0);

//			System.out.println(edges);

			// 1. 정렬 방법 2개
			// 1) Comparator
//			Collections.sort(edges, new Comparator<Edge>() {
//
//				@Override
//				public int compare(Edge o1, Edge o2) {
//					// TODO Auto-generated method stub
//					return Double.compare(o1.distance, o2.distance);
//				}
//			});

			// 2) class내에 Comparable 사용 상단 참고
			Collections.sort(edges);

			p = new int[N];

			// 2. makeSet
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			double answer = 0;
			int pick = 0;

			// 3. 정렬된 간선 탐색
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);
				
				Vertex A = edge.A;
				Vertex B = edge.B;

				int pA = findSet(A.idx);
				int pB = findSet(B.idx);

				if (pA != pB) {
					union(pA, pB);
					answer += cost * Math.pow(edge.distance, 2);
					pick++;
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