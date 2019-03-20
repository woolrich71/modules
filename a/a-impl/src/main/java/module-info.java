import woolrich.a.impl.boot.AImplModuleBoot;

module a.impl {
	requires boot;
	requires singleton;
	requires a.api;
	requires a.spi;

	provides woolrich.boot.ModuleBoot with AImplModuleBoot;
  uses woolrich.a.spi.RequiredInterfaceForA;

}