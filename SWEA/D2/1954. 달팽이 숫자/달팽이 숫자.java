import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
 
            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };
             
            int nr = 0;
            int nc = 0;
            int cnt = 1;
            int d = 0;
             
            while(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0 ) {
                int fr = nr + dr[d];
                int fc = nc + dc[d];
                 
                map[nr][nc] = cnt;
                 
                if(fr < 0 || fr >= n || fc < 0 || fc >= n || map[fr][fc] != 0) {
                    d++;
                    if(d == 4) {
                        d = 0;
                    }
                }
                 
                nr += dr[d];
                nc += dc[d];
                 
                cnt++;
            }
 
            System.out.printf("#%d%n", t);
             
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j]);
                    if (j != n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
 
    }
}