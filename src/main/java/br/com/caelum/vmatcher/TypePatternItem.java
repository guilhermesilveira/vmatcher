package br.com.caelum.vmatcher;


import java.util.function.Consumer;

public class TypePatternItem<T> implements PatternItem<T> {

	private final Class<T> type;
	private final Consumer<T> consumer;

	public TypePatternItem(Class<T> type, Consumer<T> consumer) {
		this.type = type;
		this.consumer = consumer;
	}

	@Override
	public boolean call(T x) {
		if (!(type.isAssignableFrom(x.getClass())))
			return false;
		consumer.accept(x);
		return true;
	}

}
