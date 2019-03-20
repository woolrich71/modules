package woolrich.app.boot;

import woolrich.a.spi.RequiredInterfaceForA;
import woolrich.app.impl.CoreInterfaceImpl;
import woolrich.app.impl.RequiredInterfaceForAImpl;
import woolrich.boot.ModuleBoot;
import woolrich.core.api.CoreInterface;
import woolrich.singleton.SingletonWrapper;

import java.util.stream.Stream;

public class AppModuleBoot implements ModuleBoot {

	static final AppModuleBoot instance = new AppModuleBoot();

	private AppModuleBoot() {}

	public static AppModuleBoot provider() {
		return instance;
	}

	@Override
	public Stream<SingletonWrapper> getSingeltonsForModule() {
		return Stream.of(
				new SingletonWrapper<>(CoreInterface.class, CoreInterfaceImpl::new),
				new SingletonWrapper<>(RequiredInterfaceForA.class, RequiredInterfaceForAImpl::new)
		);
	}


}
