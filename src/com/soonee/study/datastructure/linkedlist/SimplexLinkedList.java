package com.soonee.study.datastructure.linkedlist;

/**
 * 중복 없애기
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때
 * 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라
 */
public class SimplexLinkedList {

	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void init(SimplexLinkedList List) {
		List.add(9);
		List.add(1);
		List.add(1);
		List.add(3);
		List.add(4);
		List.add(8);
		List.add(2);
		List.add(1);
	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void print() {
		Node current = head;
		if (head == null) {
			System.out.println("연결리스트가 비어있습니다");
			return;
		}
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

}
