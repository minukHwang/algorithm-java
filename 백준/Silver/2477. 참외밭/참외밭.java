import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] lengths = new int[6][2];
		int maxW = 0;
		int maxL = 0;

		int mwIndex = 0;
		int mlIndex = 0;

		int minusW = 0;
		int minusL = 0;

		for (int i = 0; i < 6; i++) {
			lengths[i][0] = sc.nextInt();
			lengths[i][1] = sc.nextInt();

			if (lengths[i][0] == 1 || lengths[i][0] == 2) {
				if (maxW < lengths[i][1]) {
					maxW = lengths[i][1];
					mwIndex = i;
				}
			} else if (lengths[i][0] == 3 || lengths[i][0] == 4) {
				if (maxL < lengths[i][1]) {
					maxL = lengths[i][1];
					mlIndex = i;
				}
			}
		}

		int[] wIndex = { mwIndex == 0 ? 5 : mwIndex - 1, mwIndex == 5 ? 0 : mwIndex + 1 };
		int[] lIndex = { mlIndex == 0 ? 5 : mlIndex - 1, mlIndex == 5 ? 0 : mlIndex + 1 };
		
		for(int i = 0; i < 2; i++) {
			if(lengths[wIndex[i]][1] != maxL) {
				minusL = lengths[wIndex[i]][1];
			}
			
			if(lengths[lIndex[i]][1] != maxW) {
				minusW = lengths[lIndex[i]][1];
			}
		}
		
		int area = maxW * maxL - (maxW-minusW)*(maxL-minusL);
		System.out.println(area*n);

	}

}
