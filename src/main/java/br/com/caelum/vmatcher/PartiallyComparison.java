package br.com.caelum.vmatcher;


import java.util.function.Consumer;

public class PartiallyComparison<T extends PartiallyComparable> {

	private Object[] params;

	public PartiallyComparison(Object... params) {
		this.params = params;
	}

	public PatternItem<T> then(Consumer<T> consumer) {
		return new PatternItem<T>() {
			@Override
			public boolean call(T x) {
				if(x.compareTo(params)) return true;
				return false;
			}
		};
	}

}
