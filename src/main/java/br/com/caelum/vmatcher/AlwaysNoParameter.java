package br.com.caelum.vmatcher;


public class AlwaysNoParameter<T> implements PatternItem<T> {

	private Runnable consumer;

	public AlwaysNoParameter(Runnable consumer) {
		this.consumer = consumer;
	}

	@Override
	public boolean call(T x) {
		consumer.run();
		return true;
	}

}
