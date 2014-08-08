package br.com.caelum.vmatcher;


import java.util.function.Consumer;

public class Always<T> implements PatternItem<T> {

	private Consumer<T> consumer;

	public Always(Consumer<T> consumer) {
		this.consumer = consumer;
	}

	@Override
	public boolean call(T x) {
		consumer.accept(x);
		return true;
	}

}
