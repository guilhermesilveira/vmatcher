package br.com.caelum.vmatcher;


import static java.util.Arrays.stream;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PartComparison<T> {

	private Object[] params;

	public PartComparison(Object... params) {
		this.params = params;
	}

	public PatternItem<T> then(Consumer<T> consumer) {
		return new PatternItem<T>() {
			@Override
			public boolean call(T x) {
				// finds a compareMethod, could be used with a constructor.
				// could be cached if received the type earlier on and
				// everything cacheable
				Optional<Method> possible = stream(allMethodsOf(x))
						.filter(compareMethods())
						.filter(sameParameterCount())
						.filter(m -> {
					// hummmm
					Class<?>[] types = m.getParameterTypes();
					for (int i = 0; i < types.length; i++) {
						if (!types[i].isAssignableFrom(params[i].getClass()))
							return false;
					}
					return true;
				}).findFirst();
				
				// feio
				Method method = possible.orElseThrow(MethodCompareNotFoundException::new);
				try {
					boolean result = (boolean) method.invoke(x, params);
					return result;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			private Method[] allMethodsOf(T x) {
				return x.getClass().getMethods();
			}

			private Predicate<? super Method> sameParameterCount() {
				return m -> m.getParameterTypes().length == params.length;
			}

			private Predicate<? super Method> compareMethods() {
				return m -> m.getName().equals("compareTo");
			}

		};
	}
	public static class MethodCompareNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}

}
