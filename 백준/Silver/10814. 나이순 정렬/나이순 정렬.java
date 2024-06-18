import java.util.*;
import java.io.*;

public class Main {
	public static class Person implements Comparable<Person>{
		int age;
		String name;
		
		Person(){
			
		}
		
		Person(int age, String name){
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Person[] people = new Person[N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			Person person = new Person(Integer.parseInt(str[0]), str[1]);
			people[i] = person;
		}
		
		
		Arrays.sort(people);
		
		for(int i = 0; i < N; i++) {
			bw.write(people[i].age + " " + people[i].name + "\n");
		}
		
		bw.flush();
	}
}
