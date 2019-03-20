package woolrich.a.impl.boot;

import woolrich.a.api.TheAService;
import woolrich.a.impl.TheAServiceImpl;
import woolrich.a.spi.RequiredInterfaceForA;
import woolrich.boot.ModuleBoot;
import woolrich.singleton.Singleton;
import woolrich.singleton.SingletonWrapper;

import java.util.Optional;
import java.util.stream.Stream;

public class AImplModuleBoot implements ModuleBoot {

	static final AImplModuleBoot instance = new AImplModuleBoot();

	private AImplModuleBoot() {
	}

	public static AImplModuleBoot provider() {
		return instance;
	}

	@Override
	public Stream<SingletonWrapper> getSingeltonsForModule() {
		return Stream.of(
				new SingletonWrapper<>(TheAService.class, () -> new TheAServiceImpl())
		);
	}

	@Override
	public void verify() {
	Optional
			.ofNullable(Singleton.get(RequiredInterfaceForA.class))
			.orElseThrow(() -> new RuntimeException("no impementation for RequiredInterfaceForA found" ));
	}
}
