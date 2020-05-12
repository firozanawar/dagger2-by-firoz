package com.firozanwar.dagger2.carexamplebycodinginflow;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    // Note - inject() parameter can't take a super class i.e AppCompat 'll not work here.
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(int horsepower);

        CarComponent build();

    }
}
