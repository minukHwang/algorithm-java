import java.util.*;

public class Main {
	static class Code implements Comparable<Code>{
		int number;
		int count;
		
		Code(){
			
		}
		
		Code(int number, int count){
			this.number = number;
			this.count = count;
		}
		
		@Override 
		public String toString() {
			return "[" + number + "," + count + "]";
		}
		
		@Override
		public int compareTo(Code o) {
			return Integer.compare(o.count, this.count);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		List<Code> message = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			boolean isNew = true;
			int number = sc.nextInt();
			
			for(int j = 0; j < message.size(); j++) {
				if(message.get(j).number == number) {
					isNew = false;
					message.get(j).count++;
					break;
				}
			}
			
			if(isNew) {				
				message.add(new Code(number, 1));
			}
		}
		
		Collections.sort(message);
		
		for(int i = 0; i < message.size(); i++) {
			int number = message.get(i).number;
			int count = message.get(i).count;
			
			while(count > 0) {
				sb.append(number).append(" ");
				count--;
			}
		}
		
		System.out.println(sb);
	}
}
