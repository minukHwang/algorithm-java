import java.util.*;
import java.io.*;

public class Main {
	
	static class Book implements Comparable<Book> {
		String name;
		int count;
		
		Book() {
			
		}
		
		Book(String name, int count) {
			this.name = name;
			this.count = count;
		}

		@Override
		public String toString() {
			return "book [name=" + name + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Book o) {
			if(this.count == o.count) {
				return this.name.compareTo(o.name);
			}
			return Integer.compare(o.count, this.count);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Book> books = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			boolean isNew = true;
			String name = br.readLine();
			
			for(int b = 0; b < books.size(); b++) {
				if(name.equals(books.get(b).name)) {
					books.get(b).count++;
					isNew = false;
					break;
				}
			}
			
			if(isNew) {
				books.add(new Book(name, 1));
			}
		}
		
		Collections.sort(books);

		System.out.println(books.get(0).name);
	}
}
