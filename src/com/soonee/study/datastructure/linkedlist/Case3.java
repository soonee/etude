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
	}
}
