package com.firozanwar.dagger2.carexamplebycodinginflow;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

@Module
public class DieselEngine implements Engine {

    private static final String TAG = "Car";

    int horsePower;

    @Inject
    public DieselEngine(int horsepoer) {
        this.horsePower = horsepoer;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: DieselEngine"+horsePower);
    }
}
