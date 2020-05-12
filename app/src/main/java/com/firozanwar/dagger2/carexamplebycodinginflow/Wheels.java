package com.firozanwar.dagger2.carexamplebycodinginflow;

import javax.inject.Inject;

// Case #4 - Let us suppose Wheel is part of any library
public class Wheels {

    private Rims rims;
    private Tires tires;

    // Case #1,2,3
    /*@Inject
    Wheels(){

    }*/

    // Case #4 - Let us suppose Wheels, Rims and Tires is part of any library
    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
