public class MyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public T getHead() {

	}

	public T getTail() {

	}

	public void setHead() {

	}

	public void setTail() {

	}

	public void insertHead() {

	}

	public void insertTail() {

	}

	public void add(T element) {
		if (head == null) {
			head = new Node<T>(element);
			tail = head;
		} else {
			tail.next = new Node<T>(element);
			this.tail = tail.next;
		}
	}

	public void add(int index, T element) {

	}

	public void set(int index, T element) {

	}

	public T get(int index) {

	}

	public int indexOf(T element) {

	}

	public T remove(int i) {

	}

	public boolean remove(T element) {
		if (head == null)
			return false;
		Node<T> curNode = head;
		if (curNode.value.equals(element)) {
			head = curNode.next;
			return true;
		}
		while (curNode.next != null) {
			if (curNode.next.value.equals(element)) {
				curNode.next = curNode.next.next;
				return true;
			}
			curNode = curNode.next;
		}
		return false;
	}

	public boolean contains(T element) {
		if (head == null)
			return false;
		Node<T> curNode = head;
		while (curNode != null) {
			if (curNode.value.equals(element))
				return true;
			curNode = curNode.next;
		}
		return false;
	}

	public int size() {

	}

	public T[] toArray(T[] arrayType) {

	}

	private class Node<K> {

		private K value;
		private Node<K> next;

		private Node(K value) {
			this.value = value;
		}
	}
}
