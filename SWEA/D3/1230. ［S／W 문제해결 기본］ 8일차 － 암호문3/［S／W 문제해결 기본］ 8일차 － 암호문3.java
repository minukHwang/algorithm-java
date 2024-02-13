import java.util.Scanner;

/*
 * [문제 풀이 과정]
 * *링크드 리스트 구현해서 문제 해결*
 * - insert() -> 링크드 리스트의 중간 삽입
 * - delete() -> 링크드 리스트의 삭제
 * - add() -> 링크드 리스트의 맨 뒤에 삽입
 * 
 * 1. 처음에 암호문을 받아서 Add를 반복하여 리스트에 연결한다.
 * 2. 명령어를 확인하여 다음과 같이 해결한다.
 * 	- I -> insert()를 y번 반복하여 y개의 암호문 삽입 (주의 -> x번째 이후로 뒤에 달고 또 뒤에 달고 해야함)
 *  - D -> delete()를 y번 반복하여 y개의 암호문을 삭제
 *  - A -> add()를 y번 반복하여 y개의 압호문 맨 뒤에 삽입.
 * 3. 명령어를 적용시킨 링크드리스트를 다시 순회하여 0~9까지의 암호문을 출력한다. (메소드 구현)
 */

class Node {
	int data;
	Node link;

	Node() {

	}

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;
	int size = 0;

	LinkedList() {
		head = new Node();
	}

	// 삽입 x번째 노드 다음으로 추가.
	void insert(int idx, int data) {
		if (idx < 0 || idx > size) {
			return;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}

		Node newNode = new Node(data);

		newNode.link = curr.link;
		curr.link = newNode;

		size++;
	}

	// 삽입 x번째 노드 다음으로 삭제.
	void delete(int idx) {
		if (idx < 0 || idx >= size) {
			return;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}

		curr.link = curr.link.link;

		size--;
	}

	// 삽입 맨 뒤 삽입.
	void add(int data) {
		Node newNode = new Node(data);

		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		// 반복문을 끝나면 가장 마지막 노드로 오게 된다.

		curr.link = newNode;

		size++;
	}

	void printList() {
		Node curr = head.link;

		for (int i = 0; i < 10; i++) {
			System.out.printf(" %d", curr.data);
			curr = curr.link;
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();

			LinkedList linkedList = new LinkedList();

			for (int i = 0; i < N; i++) {
				linkedList.add(sc.nextInt());
			}

			int M = sc.nextInt();

			for (int i = 0; i < M; i++) {
				String mission = sc.next();

					// Insert
				if (mission.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						// x번째 이후로 x+1, x+2 이런식으로 삽입되어야 하므로 x+j
						linkedList.insert(x+j, sc.nextInt());
					}
					
					// Delete
				} else if (mission.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						linkedList.delete(x);
					}
					
					// Add
				} else if (mission.equals("A")) {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						linkedList.add(sc.nextInt());
					}
				}
			}
			
			System.out.printf("#%d",t);
			linkedList.printList();
			System.out.println();

		}
	}
}