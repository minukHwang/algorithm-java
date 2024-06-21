import java.util.*;
import java.io.*;

public class Main {
	
	static class Time implements Comparable<Time> {
		int start;
		int end;
		int interval;
		
		Time(){
			
		}
		
		Time(int start, int end){
			this.start = start;
			this.end = end;
			this.interval = end - start;
		}
		
		@Override
		public String toString() {
			return "(" + start + ", " + end + ")";
		}
		
		@Override
		public int compareTo(Time o) {
			if(this.end == o.end) {
				return Integer.compare(this.start, o.start);
			}
			return Integer.compare(this.end, o.end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Time[] meetings = new Time[N];
		
		for(int i = 0; i < N ; i++) {
			String[] str = br.readLine().split(" ");
			
			meetings[i] = new Time(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		Arrays.sort(meetings);
		
		
		int count = 0;
		int end = -1;
		
		for(int i = 0; i < N; i++) {
			if(meetings[i].start >= end) {
				count++;
				end = meetings[i].end;
			}
		}
		
		System.out.println(count);
	}
	
}
