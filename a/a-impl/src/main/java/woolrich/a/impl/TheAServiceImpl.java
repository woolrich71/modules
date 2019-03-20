package woolrich.a.impl;

import woolrich.a.api.TheAService;
import woolrich.a.spi.RequiredInterfaceForA;
import woolrich.singleton.Singleton;

import java.util.Optional;

public class TheAServiceImpl implements TheAService {
	@Override
	public Optional<Integer> getOptionalString() {
		Integer intFromCore = Singleton.get(RequiredInterfaceForA.class).getIntFromCore();
		return Optional.ofNullable(intFromCore);
	}
}
