package br.com.caelum.vmatcher;


import java.util.function.Consumer;
import java.util.function.Function;

public class ComparatorCheck<T> implements PatternItem<T> {

	private Function<T, Boolean> check;
	private Consumer<T> consumer;

	public ComparatorCheck(Function<T, Boolean> check, Consumer<T> consumer) {
		this.check = check;
		this.consumer = consumer;
	}

	@Override
	public boolean call(T x) {
		if(check.apply(x)) {
			consumer.accept(x);
			return true;
		}
		return false;
	}

}
