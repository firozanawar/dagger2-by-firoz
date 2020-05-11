package com.firozanwar.dagger2.carexamplebycodinginflow;

import android.util.Log;

import javax.inject.Inject;

/**
 * If a class had contructor injection, field injection and method injection all 3 then..
 * first constructor injection will get called then field and then method automatically.
 */
public class Car {

    private static final String TAG = "Car";

    // Case #1,2
    //private Engine engine;

    @Inject
    Engine engine;
    private Wheels wheels;

    // Case #1,2
   /* @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }*/

    @Inject
    public Car(Wheels wheels) {
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "drive...");
    }

    // Case #3 - method injection - rarely used.
    // method can't be private.
    // Automatically called after constructor and field injection
    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}
