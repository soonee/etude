package com.soonee.study.datastructure.linkedlist;

/**
 * 중간 노드 삭제
 * 단방향 연결리스트가 주어졌을 때 중간(정확히 가운데 노드일 필요는 없고 처음과 끝 노드만 아니면 된다)에
 * 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
 * 단, 삭제할 노드에만 접근할 수 있다.
 */
public class Case3 extends SimplexLinkedList {
	boolean deleteNode(SimplexLinkedList.Node target) {
		if(target == null || target.next == null) return false;
		SimplexLinkedList.Node next = target.next;
		target.data = next.data;
		target.next = next.next;
		return true;
	}
	public static void main(String[] args) {
		// 연결리스트 초기화
		Case3 c3 = new Case3();
		c3.init(c3);
		c3.print();

		// 연결리스트 k번쨰 찾기
		Case2 c2 = new Case2();
		SimplexLinkedList.Node node = c2.kthToLast(c3.head, 3);

		// 중간 노드 삭제
		c3.deleteNode(node);
		c3.print();
	}
}
