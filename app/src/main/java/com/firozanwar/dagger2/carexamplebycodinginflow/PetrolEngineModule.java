package com.firozanwar.dagger2.carexamplebycodinginflow;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class PetrolEngineModule {

    private int horsePower;

    public PetrolEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine provideEngine() {
        return new PetrolEngine(horsePower);
    }


    // or
//    @Binds
//    abstract Engine provideEngine(PetrolEngine engine);

}
