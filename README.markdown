VMatcher
========

A simple pattern matching library for Java 8.

Simple examples
===============

```
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
```


Examples on partials
====================


```
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
```




Missing
=======

Recursive partial
Cache partial structure