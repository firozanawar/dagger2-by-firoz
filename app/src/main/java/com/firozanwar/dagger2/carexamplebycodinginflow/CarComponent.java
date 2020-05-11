package com.firozanwar.dagger2.carexamplebycodinginflow;

import dagger.Component;

@Component
public interface CarComponent {

    Car getCar();

    // Note - inject() paramter can't take a super class i.e AppCompat 'll not work here.
    void inject(MainActivity mainActivity);
}
