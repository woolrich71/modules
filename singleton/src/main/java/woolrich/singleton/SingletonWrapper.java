package woolrich.singleton;

import java.util.function.Supplier;

public class SingletonWrapper<T, IMPL extends T> {

    private final Class<T> aClass;
    private final Supplier<IMPL> implSupplier;

    public SingletonWrapper(Class<T> aClass, Supplier<IMPL> implSupplier) {
        this.aClass = aClass;
        this.implSupplier = implSupplier;
    }

    public Class<T> getaClass() {
        return aClass;
    }

    public Supplier<IMPL> getImplSupplier() {
        return implSupplier;
    }
}
