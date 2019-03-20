package woolrich.core.boot;

import woolrich.boot.ModuleBoot;
import woolrich.core.api.CoreInterface;
import woolrich.core.api.CoreManager;
import woolrich.core.impl.CoreMangerImpl;
import woolrich.singleton.Singleton;
import woolrich.singleton.SingletonWrapper;

import java.util.Optional;
import java.util.stream.Stream;

public class CoreModuleBoot implements ModuleBoot {

	private static final CoreModuleBoot CORE_MODULE_BOOT = new CoreModuleBoot();

	private CoreModuleBoot() {}

	public static CoreModuleBoot provider() {
		return CORE_MODULE_BOOT;
	}

	@Override
	public Stream<SingletonWrapper> getSingeltonsForModule() {
		return Stream.of(
				new SingletonWrapper<>(CoreManager.class, () -> CoreMangerImpl.getInstance())
		);
	}

	@Override
	public void verify() {
		Optional
				.ofNullable(Singleton.get(CoreInterface.class))
				.orElseThrow(() -> new RuntimeException("no impementation for CoreInterface found" ));

	}
}
