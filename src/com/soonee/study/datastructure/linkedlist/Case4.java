package com.soonee.study.datastructure.linkedlist;

/**
 * 분할
 * 값 x가 주어졌을 때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다 앞에 오도록 하는 코드를 작성하라.
 * 만약 x가 리스트에 있다면 x는 그보다 작은 원소들보다 뒤에 나오기만 하면 된다.
 * 즉, 원소는 '오른쪽 그룹' 어딘가에만 존재하면 된다.
 * 왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
 */
public class Case4 extends SimplexLinkedList {

	// 연결리스트의 헤드와 분할할 값을 인자로 넘겨준다
	SimplexLinkedList.Node partition(SimplexLinkedList.Node node, int x) {
		SimplexLinkedList.Node beforeStart = null;
		SimplexLinkedList.Node beforeEnd = null;
		SimplexLinkedList.Node afterStart = null;
		SimplexLinkedList.Node afterEnd = null;
		// 리스트를 분할한다
		while(node != null) {
			SimplexLinkedList.Node next = node.next;
			node.next = null;
			if(node.data < x) {
				// before 리스트 끝에 원소를 삽입
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				// after 리스트 끝에 원소를 삽입
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if(beforeStart == null) {
			return beforeStart;
		}
		// before와 after를 병합
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public static void main(String[] args) {
		Case4 c4 = new Case4();
		c4.init(c4);
		c4.print();
		c4.partition(c4.head, 5);
		c4.print();
	}
}
