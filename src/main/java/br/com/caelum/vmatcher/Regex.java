package br.com.caelum.vmatcher;


import java.util.function.Consumer;

public class Regex implements PatternItem<String> {

	private Consumer<String> consumer;
	private String s;

	public Regex(String s, Consumer<String> consumer) {
		this.s = s;
		this.consumer = consumer;
	}

	@Override
	public boolean call(String x) {
		if(x.matches(s)) {
			consumer.accept(x);
			return true;
		}
		return false;
	}

}
