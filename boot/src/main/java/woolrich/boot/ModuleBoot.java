package woolrich.boot;

import woolrich.singleton.SingletonWrapper;

import java.util.stream.Stream;

public interface ModuleBoot {

	Stream<SingletonWrapper> getSingeltonsForModule();

	default void verify() {}
}
