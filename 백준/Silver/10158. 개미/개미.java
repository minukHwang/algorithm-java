import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());

		if (time > width - x) {

			int xCount = (time - (width - x)) / width;
			int xLeft = (time - (width - x)) % width;

			x = xCount % 2 == 1 ? xLeft : width - xLeft;

		} else {

			x = x + time;

		}

		if (time > height - y) {

			int yCount = (time - (height - y)) / height;
			int yLeft = (time - (height - y)) % height;

			y = yCount % 2 == 1 ? yLeft : height - yLeft;

		} else {

			y = y + time;

		}

		StringBuilder answer = new StringBuilder();
		answer.append(x + " " + y);

		System.out.print(answer);
	}

}
