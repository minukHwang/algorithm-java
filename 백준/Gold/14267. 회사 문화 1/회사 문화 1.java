import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 데이터를 어떻게 가공하는 것이 좋을까?

// 리스트를 쓸 것인가? 네
// 그러면 리스트에서 어떻게 하는 것이 좋을까?
// 1. 일단 입력을 받으면, 본인의 직속 상사에 연결되도록 트리를 구성해야함.
// 2. 문제에서 직속 상사가 꼭 바로 본인 전이라고 말한 적도 없고, 직속 상사가 겹칠 수도 있음.
// 3. 일단 트리 형태를 구성하자.
// - 재귀로 들어가려면 아무래도 자식 요소를 만들어야겠죠?
// 4. 트리를 구성하고 칭찬 받은 정도를 출력할 수 있도록 한다.
// - 각각의 요소들을 클래스로 구성하자 
// 5. 입력 받을 때마다 재귀를 돌리면 -> 시간 초과남.
// - 그냥 처음에 일단 저장해두고 나중에 위에서 폭포처럼 연쇄적으로 다 더해주는 것이 맞다.

class Employee {
	int idx;
	int grant;
	List<Employee> child = new ArrayList<>();

	@Override
	public String toString() {
		return "{#" + idx + ", grant=" + grant + ", child=" + child + "}";
	}
}

public class Main {
	static int N, M;
	static Employee[] organization;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		// 사장은 1번 노드
		organization = new Employee[N + 1];

		for (int i = 0; i < organization.length; i++) {
			organization[i] = new Employee();
			organization[i].idx = i;
		}

		for (int i = 1; i < organization.length; i++) {
			int parent = sc.nextInt();
			int child = i;

			if (parent == -1) {
				continue;
			}

			organization[parent].child.add(organization[child]);
		}

//		System.out.println(Arrays.toString(organization));

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int grant = sc.nextInt();

			Employee employee = organization[start];
			employee.grant += grant;
		}

		giveGrant(organization[1]);

		for (int i = 1; i < organization.length; i++) {
			Employee employee = organization[i];
			sb.append(employee.grant).append(" ");
		}

		System.out.println(sb);
	}

	public static void giveGrant(Employee employee) {
		for (int i = 0; i < employee.child.size(); i++) {
			Employee child = employee.child.get(i);
			child.grant += employee.grant;

			giveGrant(child);
		}
	}
}
