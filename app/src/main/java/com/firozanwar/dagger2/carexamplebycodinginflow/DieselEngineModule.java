package com.firozanwar.dagger2.carexamplebycodinginflow;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

//    @Provides
//    Engine provideEngine(PetrolEngine engine) {
//        return engine;
//    }

    // or
    @Binds
    abstract Engine provideEngine(DieselEngine engine);

}
