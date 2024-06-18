import java.util.*;

public class Main {
	static int X, N;
	
	static class Score implements Comparable<Score>{
		char name;
		int num;
		
		Score(){
			
		}
		
		Score(char name, int count){
			this.name = name;
			this.num = count;
		}

		@Override
		public String toString() {
			return "[" + name + ": " + num + "]";
		}

		@Override
		public int compareTo(Score o) {
			return - Integer.compare(this.num, o.num);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		X = sc.nextInt();
		N = sc.nextInt();
		
		Map<Character, Integer> chips = new HashMap<>();
		List<Score> scores = new ArrayList<>();
		
		double limit = X * 0.05;
		
		for(int i = 0; i < N; i++) {
			char name = sc.next().charAt(0);
			int count = sc.nextInt();
			
			if(count < limit) {
				continue;
			}
			
			chips.put(name, 0);
			
			for(int n = 1; n <= 14; n++) {
				int num = count / n;
				
				Score score = new Score(name, num);
				scores.add(score);
			}
		}
		
		
		Collections.sort(scores);
		
		for(int i = 0; i < 14; i++) {
			Score score = scores.get(i);
			int count = chips.get(score.name);
			
			chips.replace(score.name, ++count);
		}
		
		List<Character> keySet = new ArrayList<>(chips.keySet());
		
		for(int i = 0; i < keySet.size(); i++) {
			char name = keySet.get(i);
			int count = chips.get(name);
			
			sb.append(name).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}
