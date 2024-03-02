
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 부분 집합 구하기
// 연결 되어있는지 확인하기

public class Main {
	static int N;
	static List<Integer>[] graph;
	static int[] population;
	static boolean[] selection;
	static int sizeA;
	static int sizeB;
	static List<Integer>[] selectionA;
	static List<Integer>[] selectionB;
	static boolean visited[];
	static int[] link;
	static int populationA;
	static int populationB;
	static int minDiff;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		population = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			population[i] = sc.nextInt();
		}

		graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i < N + 1; i++) {
			int nodeCount = sc.nextInt();
			graph[i].add(i);
			for (int j = 0; j < nodeCount; j++) {
				int node = sc.nextInt();
				graph[i].add(node);
			}
		}

//		System.out.println(Arrays.toString(graph));

		selection = new boolean[N + 1];
		minDiff = 999999;
		getSubset(1);

		if (minDiff == 999999) {
			minDiff = -1;
		}

		System.out.println(minDiff);

	}

	public static void getSubset(int index) {
		if (index == N + 1) {
			sizeA = 0;
			sizeB = 0;

			for (int i = 1; i < N + 1; i++) {
				if (selection[i]) {
					sizeA++;
				} else {
					sizeB++;
				}
			}

			// 만약 2개로 안 나눠진다면
			if (sizeA == N || sizeA == 0) {
				return;
			}

			selectionA = new ArrayList[N + 1];
			selectionB = new ArrayList[N + 1];

			// 그래프 정리
			for (int i = 0; i < N + 1; i++) {
				selectionA[i] = new ArrayList<>();
				selectionB[i] = new ArrayList<>();
				if (selection[i]) {
					selectionA[i] = graph[i];
				} else {
					selectionB[i] = graph[i];
				}
			}

			link = new int[2];
//			System.out.println(Arrays.toString(selectionA));
//			System.out.println(Arrays.toString(selectionB));

			for (int i = 0; i < N + 1; i++) {
				if (selectionA[i].size() != 0) {
					visited = new boolean[N + 1];
					dfs(i, selectionA, 0);
					break;
				}
			}

			for (int i = 0; i < N + 1; i++) {
				if (selectionB[i].size() != 0) {
					visited = new boolean[N + 1];
					dfs(i, selectionB, 1);
					break;
				}
			}

			if (sizeA == link[0] && sizeB == link[1]) {
				// 두 그룹으로 나누어진다면.
				populationA = 0;
				populationB = 0;

				for (int i = 1; i < N + 1; i++) {
					if (selection[i]) {
						populationA += population[i];
					} else {
						populationB += population[i];
					}
				}

				int diff = Math.abs(populationA - populationB);

				if (diff < minDiff) {
					minDiff = diff;
				}
			}

//			System.out.println("sizeA: " + sizeA + " " + "sizeB: " + sizeB + " " + Arrays.toString(link));
//			System.out.println(minDiff);
//			System.out.println();
			return;
		}

		selection[index] = true;
		getSubset(index + 1);
		selection[index] = false;
		getSubset(index + 1);

	}

	public static void dfs(int node, List<Integer>[] group, int num) {
//		System.out.println(node + " " + link[num]);
		visited[node] = true;

		if (group[node].size() == 0) {
			return;
		}

		link[num]++;

		for (int i = 0; i < group[node].size(); i++) {
			int next = group[node].get(i);
			if (!visited[next]) {
				dfs(next, group, num);

			}
		}

	}

}
