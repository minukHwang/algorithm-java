import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		bw.write(words[0] + "\n");
		for(int i = 1; i < words.length; i++) {
			if(!words[i].equals(words[i-1])) {
				bw.write(words[i] + "\n");
			}
		}
		
		
		bw.flush();
	}
}
