package datastructs;

public class MyQueue<T> {

	private Node<T> head;
	private Node<T> tail;

	public void enqueue(T element) {
		if (head == null) {
			head = new Node<>(element);
			tail = head;
			return;
		}
		tail.next = new Node<>(element);
		tail = tail.next;
	}

	public T dequeue() {
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
