package datastructs;

public class MyStack<T> {

	private Node<T> head;

	public void push(T value) {
		if (head == null) {
			head = new Node<>(value);
			return;
		}
		Node<T> newHead = new Node<>(value);
		newHead.next = head;
		head = newHead;
	}

	public T pop() {
		if (head == null)
			return null;
		T value = head.value;
		head = head.next;
		return value;
	}

	public T peek() {
		if (head == null)
			return null;
		return head.value;
	}

	public boolean isEmpty() {
		return head == null;
	}

	private class Node<K> {
		private K value;
		private Node<K> next;

		private Node(K value) {
			this.value = value;
		}
	}
}
