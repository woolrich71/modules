import woolrich.app.boot.AppModuleBoot;

module app {
	requires core;
	requires boot;
	requires singleton;
	requires a.spi;
	requires a.api;

	provides woolrich.boot.ModuleBoot with AppModuleBoot;

}