package datastructs;

import java.util.Arrays;

public class MyArrayList<T> {

	private static final int DEFAULT_SIZE = 10;

	private Object[] data;
	private int size;

	public MyArrayList() {
		data = new Object[DEFAULT_SIZE];
		size = 0;
	}

	public void add(T value) {
		if (size == data.length)
			resize();
		data[size] = value;
		size++;
	}

	public void add(int index, T value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		if (size == data.length)
			resize();
		for (int i = size; i > index; i--)
			data[i] = data[i-1];
		data[index] = value;
		size++;
	}

	public T set(int index, T value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		T oldVal = (T) data[index];
		data[index] = value;
		return oldVal;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return (T) data[index];
	}

	public int indexOf(T value) {
		for (int i = 0; i < size; i++)
			if (data[i].equals(value))
				return i;
		return -1;
	}

	public boolean contains(T value) {
		for (int i = 0; i < size; i++)
			if (data[i].equals(value))
				return true;
		return false;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		T value = (T) data[index];
		for (int i = index; i < size-1; i++)
			data[i] = data[i+1];
		size--;
		return value;
	}

	public int remove(T value) {
		int index = indexOf(value);
		if (index == -1)
			return index;
		for (int i = index; i < size-1; i++)
			data[i] = data[i+1];
		size--;
		return index;
	}

	public T[] toArray(T[] arrayType) {
		Object[] copy = new Object[size];
		System.arraycopy(data, 0, copy, 0, data.length);
		return (T[]) copy;
	}

	private void resize() {
		Object[] newArray = Arrays.copyOf(data, data.length * 2);
		data = newArray;
	}
}