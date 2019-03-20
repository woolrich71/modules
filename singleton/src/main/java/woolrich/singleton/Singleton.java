package woolrich.singleton;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Singleton<T, IMPL extends T> {

	private Map<Class<T>, Supplier<IMPL>> singletons;

	private static Singleton instance = new Singleton();

	private Singleton() {}

	public static int getSize() {
		return instance.singletons.size();
	}

	private IMPL getInternal(Class<T> t) {
		Supplier<IMPL> implSupplier = singletons.get(t);
		if (implSupplier == null)
			return null;
		return implSupplier.get();
	}


	private void initInternal(Stream<SingletonWrapper> singletonWrappers) {
		if (instance.singletons != null)
			throw new RuntimeException("singletons already loaded");

		instance.singletons = singletonWrappers
				.collect(Collectors.toMap(SingletonWrapper::getaClass, SingletonWrapper::getImplSupplier));
	}

	public static <T, IMPL extends T> IMPL get(Class<T> t) {
		return (IMPL) instance.getInternal(t);
	}

	public static void init(Stream<SingletonWrapper> singletonWrappers) {
		instance.initInternal(singletonWrappers);
	}

}
