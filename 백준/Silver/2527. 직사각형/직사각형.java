import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 4; t++) {
			int[] x = new int[4];
			int[] y = new int[4];
			int[] compareX = new int[4];
			int[] compareY = new int[4];

			char[] type = { 'a', 'b', 'c', 'd' };

			int ans = 0;
			int zeroX = 0;
			int zeroY = 0;
			int plusX = 0;
			int plusY = 0;

			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) {
					x[i / 2] = sc.nextInt();
				} else {
					y[i / 2] = sc.nextInt();
				}
			}
			

			for (int i = 0; i < 2; i++) {
				compareX[i * 2] = x[i] - x[2];
				compareX[i * 2 + 1] = x[i] - x[3];

				compareY[i * 2] = y[i] - y[2];
				compareY[i * 2 + 1] = y[i] - y[3];
			}

			for (int i = 0; i < 4; i++) {
				
				if (compareX[i] > 0) {
					plusX++;
				}

				if (compareY[i] > 0) {
					plusY++;
				}
				
				if(i==1||i==2) {
					if (compareX[i] == 0) {
						zeroX++;
					}

					if (compareY[i] == 0) {
						zeroY++;
					}
				}
			}
			
			if(plusX == 4 || plusX == 0 || plusY == 0 || plusY == 4) {
				ans = 3;
			}

			if(zeroX + zeroY == 2) {
				ans = 2;
			} else if (zeroX + zeroY == 1) {
				if(zeroX == 1 && plusY != 4 && plusY != 0) {
					ans = 1;
				} 
				
				if (zeroY == 1 && plusX != 4 && plusX != 0) {
					ans = 1;
				}
			}
			
			System.out.println(type[ans]);
		}
	}
}