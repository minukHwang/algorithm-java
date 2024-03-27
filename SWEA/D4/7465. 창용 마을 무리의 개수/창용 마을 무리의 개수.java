/*
 * [문제 풀이 과정]
 * *union-find로 풀어보기*
 * 1. 마을에 N명이 산다고 했으니 각각의 Vertex로 지정
 * 2. N명간의 관계는 간선으로 표현할 수 있다.
 * 3. 처음부터 간선끼리 연결하지 않고, 어짜피 서로 연관이 타고타고 있으면 그룹으로 보기로 했으니, 
 * 	  union-find 알고리즘에서 union 메소드를 활용하여 상호 배타 집합을 만든다.
 * 	  (어짜피 대표(부모 노드)가 최종적으로 같다면 하나의 그룹, 서로 연관있는 집단이라고 할 수 있으니)
 * 4. 카운트 배열을 만들어서, 각각의 Vertex들의 union된 집합(대표)을 찾고 count.
 * 5. count 배열을 탐색하여 집합(대표)들이 몇 개 있는지 확인한다. (집단의 개수로 체크 가능)
 * 6. 출력하면 끝.
 */

import java.util.Scanner;

public class Solution {
	static int T, N, M;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 정점의 수 
			int M = sc.nextInt(); // 간선의 수

			// 대표 배열을 만들어서 각각의 정점들의 대표를 지정한다. (처음에는 본인)
			parent = new int[N + 1];

			for (int i = 0; i < N + 1; i++) {
				makeSet(i);
			}

			// union을 통해서 상호 배타 집합으로 만들고 대표 지정.
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				union(x, y);
			}

			// 카운트 배열을 만들고, 각각의 정점을 findset을 통해 집합(대표)를 구분하여 찾고 count
			int[] count = new int[N + 1];
			int groups = 0;

			for (int i = 1; i < N + 1; i++) {
				count[findset(i)]++;
			}
			
			for(int i = 1; i < N + 1; i++) {
				// count가 0 이상이면 집합이 존재하는 것이니 집합 개수++;
				if(count[i] > 0) {
					groups++;
				}
			}
			
			System.out.println("#" + t + " " + groups);
		}
	}

	// x, y를 포함하는 두 집합을 통합하는 연산.
	// 우항의 대표를 좌항의 대표로 만들어준다.
	private static void union(int x, int y) {
		parent[findset(y)] = findset(x);
	}
	
	// x를 포함하는 집합을 찾는 연산
	// 최종 부모 노드(대표)를 찾는다.
	private static int findset(int x) {
//		if (x == p[x])
//			return x; // 만약 본인 자신이면 본인 리턴
//		return p[x] = findset(p[x]); // 만약 본인이 아닌 다른 부분이라면 찾기
		
		// Path Compression
		// x가 본인이 아니라면 최종 부모 노드를 찾아서 대표 배열에 저장시켜준다. 
		// (나중에 찾기 편하게 하기 위해서, 노드 자체를 최종 부모 노드에 바로 연결하는 방식)
		if (x != parent[x]) {
			parent[x] = findset(parent[x]);
		}
		
		return parent[x];
	}

	// 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산.
	private static void makeSet(int x) {
		parent[x] = x;

	}
}