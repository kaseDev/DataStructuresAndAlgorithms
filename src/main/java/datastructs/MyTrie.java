package datastructs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyTrie {

	private Node root;
	private Node curNode;

	public MyTrie() {
		root = new Node('\0');
		curNode = root;
	}

	/**
	 * TODO error check to make sure argument is always a word
	 * @param word
	 */
	public void insertWord(String word) {
		Node curInsertNode = root;
		for (char character : word.toLowerCase().toCharArray()) {
			if (!curInsertNode.hasChild(character))
				curInsertNode.addChild(character);
			curInsertNode = curInsertNode.children.get(character);
		}
		curInsertNode.terminate = true;
	}

	public void toRoot() {
		curNode = root;
	}

	public boolean toParent() {
		if (curNode.parent == null)
			return false;
		curNode = curNode.parent;
		return true;
	}

	public boolean toChild(char character) {
		if (!curNode.children.containsKey(character))
			return false;
		curNode = curNode.children.get(character);
		return true;
	}

	public boolean goToString(String string) {
		curNode = root;
		for (char chr : string.toCharArray()) {
			if (!toChild(chr))
				return false;
		}
		return true;
	}

	private String getStringFrom(Node node) {
		LinkedList<Character> charList = new LinkedList<>();
		Node curStringNode = node;
		while (curStringNode.parent != null) {
			charList.offerFirst(curStringNode.character);
			curStringNode = curStringNode.parent;
		}
		StringBuilder build = new StringBuilder();
		for (char chr : charList)
			build.append(chr);
		return build.toString();
	}

	public String[] getPossibleWords() {
		List<String> words = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		stack.push(curNode);
		while (!stack.isEmpty()) {
			Node progress = stack.pop();
			for (Node child : progress.children.values())
				stack.push(child);
			if (progress.terminate)
				words.add(getStringFrom(progress));
		}
		return words.toArray(new String[0]);
	}

	public String[] getPossibleWords(int length) {
		List<String> words = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		stack.push(curNode);
		while (!stack.isEmpty() && words.size() < length) {
			Node progress = stack.pop();
			for (Node child : progress.children.values())
				stack.push(child);
			if (progress.terminate)
				words.add(getStringFrom(progress));
		}
		return words.toArray(new String[0]);
	}

	private class Node {
		private boolean terminate;
		private char character;
		private Node parent;
		private Map<Character, Node> children;

		public Node(char character) {
			terminate = false;
			this.character = character;
			children = new HashMap<>();
			parent = null;
		}

		public boolean hasChild(char character) {
			return this.children.containsKey(character);
		}

		public void addChild(char character) {
			Node child = new Node(character);
			this.children.put(character, child);
			child.parent = this;
		}
	}
}
