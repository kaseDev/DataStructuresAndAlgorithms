import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MyLinkedListTest {

	@Test
	public void addTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		Assertions.assertArrayEquals(expected, myList.toArray(new String[0]));
		Assertions.assertEquals(expected.length, myList.size());
	}

	@Test
	public void addAtIndexTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		myList.add(1, "Rick");
		Assertions.assertEquals("Rick", myList.get(1));
		Assertions.assertEquals("Jane", myList.get(2));
	}

	@Test
	public void setInnerValuesTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		myList.set(1, "Anyone else");
		Assertions.assertEquals("Anyone else", myList.get(1));
	}

	@Test
	public void insertHeadAndTailTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		myList.insertHead(expected[1]);
		myList.insertTail(expected[2]);
		myList.insertHead(expected[0]);
		myList.insertTail(expected[3]);
		System.out.println(Arrays.toString(myList.toArray(new String[0])));
		Assertions.assertArrayEquals(expected, myList.toArray(new String[0]));
	}

	@Test
	public void indexOfTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		Assertions.assertEquals(2, myList.indexOf("Mary"));
	}

	@Test
	public void containsTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		Assertions.assertTrue(myList.contains(expected[2]));
	}

	@Test
	public void throwOutOfBoundsExceptionsTest() {
		String[] expected = {"William", "Jane", "Mary", "John"};
		MyLinkedList<String> myList = new MyLinkedList<>();
		for (String ele : expected)
			myList.add(ele);
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(12));
	}
}
