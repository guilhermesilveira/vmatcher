package br.com.caelum.vmatcher;


import java.util.function.Consumer;
import java.util.function.Function;

public class PatternMatcher {

	public static <T> PartComparison<T> part(Object... s) {
		return new PartComparison<T>(s);
	}

	public static <T extends PartiallyComparable> PartiallyComparison<T> partial(Object... s) {
		return new PartiallyComparison<T>(s);
	}

	public static PatternItem<String> regex(String s, Consumer<String> consumer) {
		return new Regex(s, consumer);
	}

	public static <T> PatternItem<T> when(Function<T, Boolean> check, Consumer<T> consumer) {
		return new ComparatorCheck<T>(check, consumer);
	}

	public static <T> PatternItem<T> otherwise(Consumer<T> consumer) {
		return new Always<T>(consumer);
	}

	public static <T> PatternItem<T> otherwise(Runnable consumer) {
		return new AlwaysNoParameter<T>(consumer);
	}

	public static <T> PatternItem<T> type(Class<T> type, Consumer<T> consumer) {
		return new TypePatternItem<T>(type, consumer);
	}

	public static <T> PatternItem<T> value(T t, Consumer<T> consumer) {
		return new EqualsPatternItem<T>(t, consumer);
	}

	public static <T> void match(T x, PatternItem<T>... items) {
		for (PatternItem<T> item : items) {
			if(item.call(x)) {
				return;
			}
		}
	}

}
