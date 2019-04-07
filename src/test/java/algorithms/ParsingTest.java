package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParsingTest {

	@Test
	public void testSingleBracketTypeWellFormed() {
		Assertions.assertTrue(Parsing.validateParentheses("(()((()))())"));
	}

	@Test
	public void testMultipleBracketTypesWellFormed() {
		Assertions.assertTrue(Parsing.validateParentheses("{[{}([]{})[]]{}}"));
	}

	@Test
	public void testMultipleBracketTypesMisFormed() {
		Assertions.assertFalse(Parsing.validateParentheses("((()){}})"));
	}

	@Test
	public void testMultipleBracketTypesMisMatched() {
		Assertions.assertFalse(Parsing.validateParentheses("(()){}[][}"));
	}
}
