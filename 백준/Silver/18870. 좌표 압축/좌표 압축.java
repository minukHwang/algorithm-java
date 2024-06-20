import java.util.*;
import java.io.*;

public class Main {
	static class Coord implements Comparable<Coord> {
		int number;
		int index;
		
		Coord(){
			
		}
		
		Coord(int number, int index){
			this.number = number;
			this.index = index;
		}

		@Override
		public String toString() {
			return "[" + number + ", " + index + "]";
		}

		@Override
		public int compareTo(Coord o) {
			return Integer.compare(this.number, o.number);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Coord[] coords = new Coord[N];
		
		for(int i = 0; i < N; i++) {
			coords[i] = new Coord(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(coords);
		
		int[] answer = new int[N];
		int count = 0;
		
		answer[0] = count;
		
		for(int i = 1; i < N; i++) {
			if(coords[i].number != coords[i-1].number) {
				count++;
			}
			
			answer[coords[i].index] = count;
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(answer[i] + " ");
		}
		
		bw.flush();
		
	}
}
