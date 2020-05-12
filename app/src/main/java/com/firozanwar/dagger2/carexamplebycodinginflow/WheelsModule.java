package com.firozanwar.dagger2.carexamplebycodinginflow;

import dagger.Module;
import dagger.Provides;

/**
 * provideWheels will get rims and tire automatically.
 * static can be added if the method is not part of any object.
 * We can use it as a class name.
 */
@Module
public class WheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
