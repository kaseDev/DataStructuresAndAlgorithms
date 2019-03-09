package datastructs;

import java.util.Arrays;

public class MyHeap {

	private int[] data;
	private int size;

	public MyHeap() {
		data = new int[3];
		size = 0;
	}

	public void insert(int value) {
		if (size >= data.length)
			resize();
		data[size] = value;
		swim();
		size++;
	}

	private void swim() {
		int curIndex = size;
		while ((getParentIndex(curIndex) != -1)
				&& (data[curIndex] < data[getParentIndex(curIndex)])) {
			int swap = data[curIndex];
			data[curIndex] = data[getParentIndex(curIndex)];
			data[getParentIndex(curIndex)] = swap;
			curIndex = getParentIndex(curIndex);
		}
	}

	public int findMin() {
		if (size == 0)
			return -1;
		return data[0];
	}

	public int removeMin() {
		int value = findMin();
		size--;
		data[0] = data[size];
		data[size] = 0;
		int curIndex = 0;
		while ((getLeftChildIndex(curIndex) != -1)
				&& (hasSmallerChild(curIndex))) {
			int smallerChildIndex = (data[getLeftChildIndex(curIndex)]
					< data[getRightChildIndex(curIndex)])
					? data[getLeftChildIndex(curIndex)]
					: data[getRightChildIndex(curIndex)];
			int swap = data[curIndex];
			data[curIndex] = data[smallerChildIndex];
			data[smallerChildIndex] = swap;
			curIndex = smallerChildIndex;
		}
		return value;
	}

	public int size() {
		return size;
	}

	private void resize() {
		data = Arrays.copyOf(data, (data.length * 2) + 1);
	}

	private int getParentIndex(int index) {
		if (index == 0)
			return -1;
		else
			return ((index + 1) / 2) - 1;
	}

	private int getLeftChildIndex(int index) {
		if (index > data.length / 2)
			return -1;
		else
			return (index * 2) + 1;
	}

	private int getRightChildIndex(int index) {
		if (index > data.length / 2)
			return -1;
		else
			return (index * 2) + 2;
	}

	private boolean hasSmallerChild(int index) {
		if (index > data.length / 2)
			return false;
		return (data[index] > data[getLeftChildIndex(index)]
				|| data[index] > data[getRightChildIndex(index)]);
	}
}
