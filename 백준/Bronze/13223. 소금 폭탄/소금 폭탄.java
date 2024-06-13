import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] time1 = sc.next().split(":");
		String[] time2 = sc.next().split(":");
		
		int hour = Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]);
		int minute = Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
		int second = Integer.parseInt(time2[2]) - Integer.parseInt(time1[2]);
		
		
		if(second < 0) {
			second += 60;
			minute--;
		}
		
		if(minute < 0) {
			minute += 60;
			hour--;
		}
		
		if(hour < 0) {
			hour += 24;
		}
		
		if(hour == 0 && minute == 0 && second == 0) {
			hour = 24;
		}
		
		System.out.printf("%02d:%02d:%02d", hour, minute, second);
		
	}
}
