import java.util.*;
import java.io.*;

public class Main {
	static int N, C;
	static int[] coords;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		coords = new int[N];
		
		for(int i = 0; i < N; i++) {
			int coord = Integer.parseInt(br.readLine());
			coords[i] = coord;	
		}
		
		Arrays.sort(coords);
		
		System.out.println(getMaxDistance());
	}
	
	// 1. 첫 좌표 찍기
	// 2. 해당 좌표에서 이분 탐색으로 인접 거리의 최대 값 구하기
	// 3. 회대의 값을 구할 때 해당 거리 만큼 떨어진 위치에 집이 있는지 없는지 확인 (set으로)
	
	// NlogN
	public static int getMaxDistance() {
		int left = 0;
		int right = coords[N-1] - coords[0];
		int maxDistance = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(getCount(mid) >= C) {
				maxDistance = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return maxDistance;
	}
	
	public static int getCount(int distance) {
		int prevCoord = coords[0];
		int count = 1;
		
		for(int i = 1; i < coords.length; i++) {
			if((coords[i] - prevCoord) >= distance) {
				prevCoord = coords[i];
				count++;
			}
		}

		return count;
	}
}
