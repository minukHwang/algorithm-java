import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> cards = new TreeMap<>();
		
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(cards.containsKey(number)) {
				int count = cards.get(number);
				cards.put(number, count + 1);
			} else {
				cards.put(number, 1);
			}
		}
		
		List<Integer> arr = new ArrayList<>(cards.keySet());
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			int count = getCount(arr, number, cards);
			
			bw.write(count + " ");
		}
		
		bw.flush();
	}
	
	public static int getCount(List<Integer> arr, int number, Map<Integer, Integer> cards) {
		int left = 0;
		int right = arr.size() - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(number > arr.get(mid)) {
				left = mid + 1;
			}
			
			else if (number < arr.get(mid)) {
				right = mid - 1;
			}
			
			else {
				return cards.get(arr.get(mid));
			}
		}
		
		return 0;
	}
}
