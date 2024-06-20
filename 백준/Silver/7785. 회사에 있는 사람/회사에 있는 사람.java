import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, String> logs = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			
			String name = str[0];
			String action = str[1];
			
			if(action.equals("leave") && logs.containsKey(name)) {
				logs.remove(name);
				continue;
			}
			
			logs.put(name, action);
		}
		
		List<String> keySet = new ArrayList<>(logs.keySet());
		Collections.sort(keySet);
		
		for(int i = keySet.size() - 1; i >= 0; i--) {
			bw.write(keySet.get(i) + "\n");
		}
		
		bw.flush();
	}
}
