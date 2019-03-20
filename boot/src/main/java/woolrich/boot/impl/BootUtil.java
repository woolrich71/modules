package woolrich.boot.impl;

import woolrich.boot.ModuleBoot;
import woolrich.singleton.Singleton;
import woolrich.singleton.SingletonWrapper;

import java.util.ServiceLoader;
import java.util.stream.Stream;

public class BootUtil {

	public static int getSingletonsSize() {
		return Singleton.getSize();
	}

	private BootUtil init() {
		Stream<SingletonWrapper> singletonWrappers = ServiceLoader.load(ModuleBoot.class)
				.stream()
				.map(ServiceLoader.Provider::get)
				.flatMap(ModuleBoot::getSingeltonsForModule);
		Singleton.init(singletonWrappers);
		return this;
	}

	private BootUtil verify() {
		ServiceLoader.load(ModuleBoot.class)
				.stream()
				.map(ServiceLoader.Provider::get)
				.forEach(ModuleBoot::verify);
		return this;
	}

	public static void boot() {
		new BootUtil()
				.init()
				.verify();

	}

}
