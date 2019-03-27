package algorithms;

import datastructs.MyStack;

public class Parsing {


	///// VALIDATE BRACKETS START /////
	/**
	 * This algorithm will accept a string made up of any kind of bracket
	 * and return true if all the strings are well formed or not.
	 */
	public static boolean validateParentesis(String brackets) {
		MyStack<Integer> brackstack = new MyStack<>();
		for (char bracket : brackets.toCharArray()) {
			BracketType type = getBracketType(bracket);
			if (type.openBracket)
				brackstack.push(type.type);
			else {
				if (brackstack.pop() != type.type)
					return false;
			}
		}
		return brackstack.isEmpty();
	}

	private static BracketType getBracketType(char bracket) {
		switch (bracket) {
			case '(':
				return new BracketType(1, true);
			case ')':
				return new BracketType(1, false);
			case '[':
				return new BracketType(2, true);
			case ']':
				return new BracketType(2, false);
			case '{':
				return new BracketType(3, true);
			case '}':
				return new BracketType(3, false);
		}
		throw new IllegalStateException("This is not a bracket");
	}

	private static class BracketType {
		/**
		 * 1 - ()
		 * 2 - []
		 * 3 - {}
		 */
		int type;
		boolean openBracket;

		private BracketType(int type, boolean openBracket) {
			this.type = type;
			this.openBracket = openBracket;
		}
	}

	///// VALIDATE BRACKETS END /////
}
