import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int win;
	static int lose;
	static int[] countCard;
	static int[] myCard;
	static int[] yourCard;
	static int[] permCard;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			countCard = new int[19];
			myCard = new int[9];
			yourCard = new int[9];
			permCard = new int[9];
			visited = new boolean[9];
			
			int cardIndex = 0;

			for (int i = 0; i < 9; i++) {
				int idx = sc.nextInt();
				myCard[i] = idx;
				countCard[idx]++;
			}

			for (int i = 1; i < 19; i++) {
				if (countCard[i] == 0) {
					yourCard[cardIndex++] = i;
				}
			}

			perm(0);
			System.out.printf("#%d %d %d\n", t, win, lose);
		}
	}

	public static void perm(int depth) {
		if(depth == 9) {
			int scoreA = 0;
			int scoreB = 0;
			for(int i = 0; i < 9; i++) {
				if(myCard[i] > permCard[i]) {
					scoreA += myCard[i] + permCard[i];
				} else {
					scoreB += myCard[i] + permCard[i];
				}
			}
			
			if(scoreA > scoreB) {
				win++;
			} else {
				lose++;
			}
			
			return;
		}
		
		
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permCard[depth] = yourCard[i];
				perm(depth+1);
				visited[i] = false;
			}
		}
		
		
	}
}