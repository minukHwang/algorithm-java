import java.util.Scanner;

public class Solution {

	// 백트래킹을 위한 static 변수.
	static int N, M;
	static int[] selected;
	static boolean[] visited;
	
	// 깃발 색깔을 위한 static 변수.
	static int[][] colorCount;
	static int row;
	static int col;
	static int minCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			row = sc.nextInt();
			col = sc.nextInt();

			// 깃발 데이터 받기
			char[][] flag = new char[row+1][col];
			colorCount = new int[row+1][3];

			for (int i = 1; i < row+1; i++) {
				flag[i] = sc.next().toCharArray();
			}

			// 각 줄의 색깔 갯수 카운트하기
			for (int i = 1; i < row+1; i++) {
				for (int j = 0; j < col; j++) {
					switch (flag[i][j]) {
					case 'W':
						colorCount[i][0]++;
						break;

					case 'B':
						colorCount[i][1]++;
						break;

					case 'R':
						colorCount[i][2]++;
						break;
					}
				}
			}
			
			
			// 최소를 구하는 문제이므로 처음에 큰 값을 넣어주어야한다.
			// 문제의 최악의 케이스는 모든 색을 바꾸는 것이니, row*col+1로 설정
			minCount = row*col+1; 
			
			// 1~ row까지를 2가지 숫자를 선택한다. (분절점)
			M = 2;
			N = row;
			
			// 선택된 숫자들을 담을 배열
			selected = new int[M];
			// 이미 방문한 요소인지 아닌지를 체크하기 위한 배열
			visited = new boolean[N + 1];
			

			// 백트래킹 재귀.
			backtrack(2, 0);
			System.out.printf("#%d %d\n",t,minCount);
		}
	}

	static void backtrack(int start, int depth) {
		if (depth == M) {
			// 깃발 갯수 탐색을 위한 변수
			// 이렇게 진행하면 1~ row까지를 2가지 숫자를 선택하여 1세트 완성
			// [2,3] -> white는 1번줄만, blue는 2번줄, red는 3~끝까지
			// [4,7] -> white는 1~3번줄, blue는 4~6, red는 7~끝까지
			
			int count = 0;
			
			// 흰색 칠해야하는 부분 카운트
			for(int w = 1; w < selected[0]; w++) {
				count += col - colorCount[w][0];
			}
			
			// 파란색 칠해야하는 부분 카운트
			for(int b = selected[0]; b < selected[1]; b++) {
				
				count += col - colorCount[b][1];
			}
			
			// 빨간색 칠해야하는 부분 카운트
			for(int r = selected[1]; r <= row; r++) {
				count += col - colorCount[r][2];
			}
			
			// 최소값 구하기
			if(count < minCount) {
				minCount = count;
			}
			
			return;
		}

		// 시작부터 숫자 전체 크기까지 탐색
		for (int i = start; i <= N; i++) {
			// 만약 방문하지 않은 숫자(노드)라면,
			if (!visited[i]) {
				// 해당 숫자 방문 처리
				visited[i] = true;
				// 해당 숫자 선택 배열에 추가
				selected[depth] = i;
				// 다음으로 넘어가기 (트리로 구상하면, 자식으로 가면서, 방문한 숫자 외의 숫자로.)
				backtrack(i + 1, depth + 1);
				// 다시 부모로 올라오면, 방문 false
				visited[i] = false;
			}
		}
	}
}