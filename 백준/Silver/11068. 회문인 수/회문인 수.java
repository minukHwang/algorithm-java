import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int num = sc.nextInt();
			int answer = 0;
			
			for(int i = 2; i <= 64; i++) { 
				List<Integer> list = new ArrayList<>();
				
				int decimal = num;
				
				while(decimal > 0) {
					list.add(decimal % i);
					decimal /= i;
				}
				
				
				// 회문 검사
				int left = 0;
				int right = list.size() - 1;
				
				boolean isAvailable = true;
				
				while(left <= right) {
					if(list.get(left) != list.get(right)) {
						// 해당 진법에 대해서는 회문 아님.
						isAvailable = false;
						break;
					}
					
					left++;
					right--;
				}
				
				
				if(isAvailable) {
					answer = 1;
					break;
				}
			}
			
			System.out.println(answer);
		}
	}
}
