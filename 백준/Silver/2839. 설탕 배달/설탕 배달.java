import java.util.Scanner;

/*
 * 풀이 방법
 * 1. 그리디 알고리즘이랑 비슷함. 일단 5를 최대로 할 수 있는 경우가 있는지 탐색하는 것이 관건
 * 2. 일단 5로 최대한 채우고 3을 더해서 수를 완성할 수 있는지 확인. 
 * 3. 만약에 안되면 5를 줄이고 3을 넣고.
 * 4. 만약에 안되면 3을 넣고... 이런식으로 반복하기!
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int maxFive = n / 5;
		int total = 0;

		for (int i = maxFive; i >= 0; i--) {
			int withOutFive = n - i * 5;
			total = i;
			if(withOutFive % 3 == 0) {
				total += withOutFive / 3;
				break;
			}
		}
		
		System.out.println(total==0?-1:total);

	}
}
