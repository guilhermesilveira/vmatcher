package br.com.caelum.vmatcher;

import static org.junit.Assert.assertEquals;
import static br.com.caelum.vmatcher.PatternMatcher.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class PatternMatcherTest {
	
	@Test
	public void match_type() {
		match(new Integer(1),
			type(Integer.class, i -> assertEquals(new Integer(1), i)),
			otherwise(i -> fail())
		);
	}

	@Test
	public void match_value() {
		match(new Integer(1),
			value(new Integer(1), i -> assertEquals(new Integer(1), i)),
			otherwise(i -> fail())
		);
	}

	@Test
	public void match_regex() {
		match("guilherme",
			regex(".*lhe.*", i -> assertEquals("guilherme", i)),
			otherwise(i -> fail())
		);
	}

	@Test
	public void match_otherwise() {
		match("guilherme",
			regex(".*lha.*", i -> fail()),
			otherwise(i -> assertEquals("guilherme", i))
		);
	}

	@Test
	public void match_otherwise_with_no_param() {
		match("guilherme",
			regex(".*lha.*", i -> fail()),
			otherwise(() -> assertTrue(true)) //hummm
		);
	}

	@Test
	public void match_comparator() {
		match(new Integer(15),
			when(i -> i > 10, i -> assertEquals(new Integer(15), i)),
			otherwise(i -> fail())
		);
	}
}
