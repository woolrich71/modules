package woolrich.app.impl;

import woolrich.a.spi.RequiredInterfaceForA;
import woolrich.core.api.CoreInterface;
import woolrich.singleton.Singleton;

public class RequiredInterfaceForAImpl implements RequiredInterfaceForA {
	@Override
	public Integer getIntFromCore() {
		return Singleton.get(CoreInterface.class).getInt();
	}
}
