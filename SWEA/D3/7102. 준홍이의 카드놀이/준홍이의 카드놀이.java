/*
 * [문제 풀이 과정]
 * *Tree 구조로 풀어보기*
 * 1. 카운팅 배열을 만들어서 초기화해둔다.
 * 2. Tree 자료구조를 구현하여 root노드에 N개의 노드 자식들이 
 * 	  그 자식으로 M개의 노드 자식들이 존재하도록 하여 최종 노드에 1~N 1~M까지 더한 값을 넣는다.
 * 3. Tree를 순회하며 카운팅 배열에 노드의 값 카운트해준다.
 * 4. 최대로 많이 나온 값을 출력하면 끝.
 */

import java.util.Scanner;

class Node {
	int data;
	Node[] children;
	int level;

	Node() {

	}

	Node(int data, int length, int level) {
		this.data = data;
		children = new Node[length + 1];
		for (int i = 1; i < length + 1; i++) {
			children[i] = new Node();
		}
		this.level = level;
	}
}

public class Solution {
	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			count = new int[41];
			int N = sc.nextInt();
			int M = sc.nextInt();
			Node root = new Node(0, N, 0);

			for (int i = 1; i <= N; i++) {
				root.children[i] = new Node(i, M, 1);
				for (int j = 1; j <= M; j++) {
					root.children[i].children[j] = new Node(i + j, 1, 2);
				}
			}

			countNode(root);

			int max = 0;
			for (int i = 2; i <= M + N; i++) {
				if(max < count[i]) {
					max = count[i];
				}
			}
			
			System.out.printf("#%d", t);
			for (int i = 2; i <= M + N; i++) {
				if(count[i]==max) {
					System.out.printf(" %d", i);
				}
			}
			System.out.println();
		}
	}

	public static void countNode(Node node) {
		if (node.children == null) {
			return;
		}

		for (int i = 1; i < node.children.length; i++) {
			countNode(node.children[i]);
			if (node.level == 2) {
				count[node.data]++;
			}
		}
	}
}