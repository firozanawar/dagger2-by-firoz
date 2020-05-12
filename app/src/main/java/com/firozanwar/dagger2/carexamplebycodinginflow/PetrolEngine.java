package com.firozanwar.dagger2.carexamplebycodinginflow;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

@Module
public class PetrolEngine implements Engine {

    private static final String TAG = "Car";

    int horsePower;

    //@Inject
    public PetrolEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: PetrolEngine: horsePower: "+horsePower);
    }
}
