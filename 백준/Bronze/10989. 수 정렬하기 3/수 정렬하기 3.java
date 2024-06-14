import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] count = new int[10001];
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i < count.length; i++) {
			if(count[i] > 0) {
				while(count[i] > 0) {					
					bw.write(i + "\n");
					count[i]--;
				}
			}
		}
		
		
		bw.flush();
	}
}
