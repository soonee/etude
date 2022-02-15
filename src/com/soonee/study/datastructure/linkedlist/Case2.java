package com.soonee.study.datastructure.linkedlist;

/**
 * 뒤에서 k번째 원소 구하기
 * 단방향 연결리스트가 주어졌을 때
 * 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라
 *
 * 연결리스트의 전체 길이를 모른다고 쳐야하나??
 *
 */
public class Case2 extends SimplexLinkedList {

	// 재귀식
	private int printKthToLast(SimplexLinkedList.Node current, int k) {
		if(current == null) return 0;
		int index = printKthToLast(current.next, k) + 1;
		if(index == k) {
			System.out.println("뒤에서 " + k + "번째 원소 값은 " + current.data);
		}
		return index;
	}

	// 비재귀식
	private SimplexLinkedList.Node kthToLast(SimplexLinkedList.Node head, int k) {
		SimplexLinkedList.Node p1 = head;
		SimplexLinkedList.Node p2 = head;

		// 연결리스트를 k만큼 이동한다
		for(int i = 0; i < k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}

		// p1은 k번만큼 이동해있다
		// p1을 끝까지 이동시킨다
		// p1와 p2를 같은 횟수만큼 움직인다
		// p2는 뒤에서 k번째 원소이다?
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("뒤에서 " + k + "번째 원소 값은 " + p2.data);
		return p2;
	}

	public static void main(String[] args) {
		int number = 3;
		Case2 c2 = new Case2();
		c2.init(c2);
		c2.print();
		c2.printKthToLast(c2.head, number);
		c2.kthToLast(c2.head, number);
	}
}
