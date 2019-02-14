public class MyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	/**
	 * Returns the head element
	 * @return
	 */
	public T getHead() {
		return head.value;
	}

	/**
	 * Returns the tail element
	 * @return
	 */
	public T getTail() {
		return tail.value;
	}

	/**
	 * Sets the value of the first element to the argument by override the
	 * previous first element.
	 * @param element
	 */
	public void setHead(T element) {
		this.head.value = element;
	}

	/**
	 * Sets the value of the last element to the argument by overriding the
	 * previous last element.
	 * @param element
	 */
	public void setTail(T element) {
		this.tail.value = element;
	}

	/**
	 * Inserts the argument element to the front of the list, pushing all other
	 * elements back by one.
	 * @param element
	 */
	public void insertHead(T element) {
		if (size == 0)
			add(element);
		Node<T> newHead = new Node<>(element);
		newHead.next = this.head;
		this.head = newHead;
		size++;
	}

	/**
	 * Inserts the argument element to the back of this list.
	 * @param element
	 */
	public void insertTail(T element) {
		if (size == 0)
			add(element);
		Node<T> newTail = new Node<>(element);
		tail.next = newTail;
		tail = newTail;
		size++;
	}

	/**
	 * Inserts the argument element to the back of this list.
	 * @param element
	 */
	public void add(T element) {
		if (size == 0) {
			head = new Node<>(element);
			tail = head;
		} else {
			tail.next = new Node<>(element);
			this.tail = tail.next;
		}
		size++;
	}

	/**
	 * Inserts the argument element into the index specified.
	 * @param index
	 * @param element
	 */
	public void add(int index, T element) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		if (index == 0) {
			insertHead(element);
			return;
		}
		if (index == size) {
			insertTail(element);
		}
		Node<T> curNode = head;
		while (index != 1) {
			curNode = curNode.next;
			index--;
		}
		Node<T> temp = curNode.next;
		curNode.next = new Node<>(element);
		curNode.next.next = temp;
		size++;
	}

	/**
	 * Sets the specified index to the element specified by the
	 * second argument by overriding the previous element at that
	 * location.
	 * @param index
	 * @param element
	 */
	public void set(int index, T element) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		Node<T> curNode = head;
		while (index != -1) {
			if (index == 0) {
				curNode.value = element;
				return;
			}
			curNode = curNode.next;
			index--;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Returns the element that is stored at the specified index
	 * location.
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		Node<T> curNode = head;
		while (index != -1) {
			if (index == 0) {
				return curNode.value;
			}
			curNode = curNode.next;
			index--;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Returns the index location of the first element to match the
	 * value provided as an argument.
	 * @param element
	 * @return
	 */
	public int indexOf(T element) {
		int i = 0;
		Node<T> curNode = head;
		while (curNode != null) {
			if (curNode.value.equals(element))
				return i;
			curNode = curNode.next;
			i++;
		}
		return -1;
	}

	/**
	 * Removes the element at the specified index from the list and
	 * returns it.
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		Node<T> curNode = head;
		if (index == 0) {
			head = head.next;
			size--;
			return curNode.value;
		}
		while (index != 1) {
			curNode = curNode.next;
			index--;
		}
		Node<T> temp = curNode.next;
		curNode.next = curNode.next.next;
		size--;
		return temp.value;
	}

	/**
	 * removes the element specified by the argument and true if
	 * the item was successfully removed, false otherwise.
	 * @param element
	 * @return
	 */
	public boolean remove(T element) {
		if (head == null)
			return false;
		Node<T> curNode = head;
		if (curNode.value.equals(element)) {
			head = curNode.next;
			size--;
			return true;
		}
		while (curNode.next != null) {
			if (curNode.next.value.equals(element)) {
				curNode.next = curNode.next.next;
				size--;
				return true;
			}
			curNode = curNode.next;
		}
		return false;
	}

	/**
	 * Returns true if the specified element is contained in this
	 * list; returns false otherwise.
	 * @param element
	 * @return
	 */
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

	/**
	 * returns the current size of this list.
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * returns the contents of this LinkedList in the form of an
	 * Array.
	 * @param array
	 * @return
	 */
	public T[] toArray(T[] array) {
		if (array.length < size)
			array = (T[]) java.lang.reflect.Array.newInstance(
					array.getClass().getComponentType(), size);
		Node<T> curNode = head;
		for (int i = 0; i < size; i++) {
			array[i] = curNode.value;
			curNode = curNode.next;
		}
		return array;
	}

	/**
	 * private inner class that represents that Node object used
	 * to store the elements and point to the next element in the
	 * list
	 * @param <K>
	 */
	private class Node<K> {
		private K value;
		private Node<K> next;

		private Node(K value) {
			this.value = value;
		}
	}
}
