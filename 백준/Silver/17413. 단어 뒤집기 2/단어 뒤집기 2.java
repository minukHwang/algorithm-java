import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String lines = sc.nextLine();
		lines = lines.replace("<", "@<");
		lines = lines.replace(">", ">@");

//		System.out.println(lines);

		String[] arr = lines.split("@");
//		System.out.println(Arrays.toString(arr));

		List<String> words = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("")) {
				continue;
			}

			if (arr[i].charAt(0) != '<') {
				arr[i] = arr[i].replace(" ", "@ @");
				String[] temp = arr[i].split("@");
				for (int j = 0; j < temp.length; j++) {
					words.add(temp[j]);
				}
			} else {
				words.add(arr[i]);
			}
		}

//		System.out.println(words);

		String answer = "";

		for (String word : words) {
			if (word.charAt(0) == '<') {
				answer += word;
			} else {
				String[] temp = word.split("");
				for (int i = temp.length - 1; i >= 0; i--) {
					answer += temp[i];
				}
			}
		}

		System.out.println(answer);
	}
}
