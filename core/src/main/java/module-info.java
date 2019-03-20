module core {
    requires boot;
    requires singleton;

    exports woolrich.core.api;
    uses woolrich.core.api.CoreInterface;
    provides woolrich.boot.ModuleBoot with woolrich.core.boot.CoreModuleBoot;


}