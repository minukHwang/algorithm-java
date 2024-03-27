/*
 * [문제 풀이 과정]
 * *union-find 구현*
 * 1. 서로소 집합을 만들기 위해서 parent배열 생성(대표 배열)
 * 2. 대표 배열에 초기에는 본인 자신을 넣기
 * 3. 입력 값에 따라 메소드 구현 (0 -> union, 1 -> 대표가 같은지 판별)
 * 	- union: 우항의 대표를 좌항의 대표로 만들어주기
 * 	- findset: 대표가 누구인지 찾는 메소드 (즉, 최종 부모 노드 리턴)
 * 4. 출력 기준에 따라서 출력.
 */

import java.util.Scanner;

public class Solution {
	static int T, N, M;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			N = sc.nextInt();
			M = sc.nextInt();

			parent = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < M; i++) {
				int cal = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();

				if (cal == 0) {
					union(x, y);
				}

				if (cal == 1) {
					// 만약 같은 집합이라면 1, 아니라면 0
					sb.append(isSameSet(x, y)? "1" : "0");
				}
			}
			
			System.out.println(sb);
		}
	}

	public static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}

	public static int findSet(int x) {
		if(x != parent[x]) {
			parent[x] = findSet(parent[x]);
		}
		
		return parent[x];
	}

	// 같은 집합인지 아닌지 판별 -> 최종 대표가 같은지
	public static boolean isSameSet(int x, int y) {
		return findSet(x) == findSet(y);
	}
}