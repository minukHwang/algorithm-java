import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			String word = br.readLine();
			
			if(isExist(arr, word)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isExist(String[] arr, String word) {
		int left = 0, right = arr.length - 1;
		
		while(right >= left) {
			int mid = (left + right) / 2;
			int compareResult = arr[mid].compareTo(word);
			if(compareResult < 0) {
				left = mid + 1;
			} else if (compareResult > 0) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
