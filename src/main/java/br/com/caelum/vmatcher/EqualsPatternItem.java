package br.com.caelum.vmatcher;


import java.util.function.Consumer;

public class EqualsPatternItem<T> implements PatternItem<T> {

	private T t;
	private Consumer<T> consumer;

	public EqualsPatternItem(T t, Consumer<T> consumer) {
		this.t = t;
		this.consumer = consumer;
	}

	@Override
	public boolean call(T x) {
		if(t.equals(x)) {
			consumer.accept(x);
			return true;
		}
		return false;
	}

}
