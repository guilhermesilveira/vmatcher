package br.com.caelum.vmatcher;

import static br.com.caelum.vmatcher.PatternMatcher.match;
import static br.com.caelum.vmatcher.PatternMatcher.otherwise;
import static br.com.caelum.vmatcher.PatternMatcher.part;
import static br.com.caelum.vmatcher.PatternMatcher.partial;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class PartialPatternMatchTest {


	@Test
	public void match_partial() {
		Student guilherme = new Student("guilherme", 33);
		match(guilherme,
			partial("guilherme").then(i -> assertEquals(guilherme, i)),
			otherwise(i -> fail())
		);
	}

	@Test
	public void match_partial_without_enforcing_method() {
		Student guilherme = new Student("guilherme", 33);
		match(guilherme,
			part("guilherme").then(i -> assertEquals(guilherme, i)),
			otherwise(i -> fail())
		);
	}

}
