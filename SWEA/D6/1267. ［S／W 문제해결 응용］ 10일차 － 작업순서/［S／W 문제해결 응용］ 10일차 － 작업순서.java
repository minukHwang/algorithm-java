/*
 * [문제 풀이 과정]
 * 1. 그래프 정보를 입력 받는다. (인접 행렬, 인접 리스트 등)
 * 2. 진입 차수 배열을 만들어서 그래프의 정보를 입력 받으면서 정리한다.
 * 3. 큐를 만들고 큐에 진입 차수가 0인 정점들을 넣는다.
 * 4. 큐에서 하나씩 꺼내면서, 각각의 정점이 이어지는 정점들의 진입 차수를 깎아준다.
 * 5. 만약 진입 차수가 0이된다면 큐에 넣어주며, 큐가 비워질 때까지 반복한다.
 * 6. 최종적으로 큐에서 poll한 순서를 출력해주면 끝.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int V, E;
	static List<Integer>[] adjList;
	static int[] inDegree;
	static Queue<Integer> queue;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			V = sc.nextInt();
			E = sc.nextInt();
			
			adjList = new ArrayList[V+1];
			
			for(int i = 1; i < V+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			inDegree = new int[V+1]; // 1부터 V까지
			
			for(int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adjList[A].add(B);
				inDegree[B]++;
			}
			
			queue = new LinkedList<>();
			
			for(int i = 1; i < V+1; i++) {
				if(inDegree[i] == 0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr + " ");
				
				for(int node: adjList[curr]) {
					inDegree[node]--;
					
					if(inDegree[node] == 0) {
						queue.add(node);
					}
				}
			}
			
			System.out.println(sb);
		}
		
		sc.close();
	}
}