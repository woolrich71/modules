package woolrich.app;

import woolrich.a.api.TheAService;
import woolrich.boot.impl.BootUtil;
import woolrich.core.api.CoreInterface;
import woolrich.core.api.CoreManager;
import woolrich.singleton.Singleton;

import java.util.Optional;
import java.util.Set;

public class Main {

    private Main() {
        BootUtil.boot();
        System.out.println(Singleton.get(CoreManager.class).getInt());
        Singleton.get(CoreInterface.class).function(this::doFunctionStuff);
        Optional<Integer> optionalString = Singleton.get((TheAService.class)).getOptionalString();
        System.out.println("optionalString = " + optionalString);


    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    private void doFunctionStuff() {
        System.out.println("test");
    }


}
