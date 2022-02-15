package com.soonee.study.datastructure.linkedlist;

/**
 * 중복 없애기
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때
 * 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라
 */
public class Case1 extends SimplexLinkedList {

	public void removeDuplicates() {
		SimplexLinkedList.Node current = head;
		SimplexLinkedList.Node index;
		SimplexLinkedList.Node temp;
		if (head == null) {
			return;
		}
		while (current != null) {
			temp = current;
			index = current.next;
			while (index != null) {
				if (current.data == index.data) {
					temp.next = index.next;
				} else {
					temp = index;
				}
				index = index.next;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		Case1 List = new Case1();
		List.init(List);
		List.print();

		List.removeDuplicates();
		List.print();
	}
}
