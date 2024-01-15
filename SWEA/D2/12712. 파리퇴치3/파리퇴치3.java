import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int [][] flies = new int[n][n];
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int count = 0;
					int perpendicular = 0;
					int diagonal = 0;
					
					for(int d = 1; d <= (m-1); d++) {
						int[] dx = {-d, d, 0, 0};
						int[] dy = {0, 0, -d, d};
						
						int[] ddx = {-d, +d, -d, +d};
						int[] ddy = {-d, -d, +d, +d};
						
						for(int r = 0; r < 4; r++) {
							int indexPX = i + dx[r];
							int indexPY = j + dy[r];
							 
							int indexDX = i + ddx[r];
							int indexDY = j + ddy[r];
							
							if(indexPX >= 0 && indexPX < n && indexPY >=0 && indexPY <n) {								
								perpendicular += flies[indexPX][indexPY];
							}
							
							if(indexDX >= 0 && indexDX < n && indexDY >=0 && indexDY <n) {								
								diagonal += flies[indexDX][indexDY];
							}
							
							 
						}
					}
					
					count += Math.max(perpendicular, diagonal);
					count += flies[i][j];
					if(count > max) {
						max = count;
					}
				}
				
			}
			System.out.printf("#%d %d%n",t,max);
		}
		sc.close();
	}
}