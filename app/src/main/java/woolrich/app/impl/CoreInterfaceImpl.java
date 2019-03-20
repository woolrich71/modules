package woolrich.app.impl;

import woolrich.boot.impl.BootUtil;
import woolrich.core.api.CoreInterface;
import woolrich.core.api.DoStuff;

public class CoreInterfaceImpl implements CoreInterface {
	@Override
	public int getInt() {
		return BootUtil.getSingletonsSize();
	}

	@Override
	public void function(DoStuff doStuff) {
		doStuff.doIt();
	}
}
