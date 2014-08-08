package br.com.caelum.vmatcher;


public interface PatternItem<T> {
	
	boolean call(T x);

}
