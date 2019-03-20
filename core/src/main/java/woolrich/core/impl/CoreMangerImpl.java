package woolrich.core.impl;

import woolrich.core.api.CoreInterface;
import woolrich.core.api.CoreManager;
import woolrich.singleton.Singleton;

public class CoreMangerImpl implements CoreManager {

	private static final CoreMangerImpl CORE_MANGER = new CoreMangerImpl();

	public static CoreMangerImpl getInstance() {
        return CORE_MANGER;
    }

	@Override
	public int getInt() {
		return Singleton.get(CoreInterface.class).getInt();

	}
}
