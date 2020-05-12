package com.firozanwar.dagger2.carexamplebycodinginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firozanwar.dagger2.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // Case #1 - Constructor injection
    //private Car car;

    // Case #2 - Field injection
    // Benefit of Field injection is you can add multiple member variables and just call methods.
    @Inject Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Case #1 - Constructor injection
        //CarComponent carComponent = DaggerCarComponent.create();
        //car = carComponent.getCar();
        //car.drive();

        // Case #2 - Field injection
        CarComponent carComponent = DaggerCarComponent.builder()
                .horsePower(150)
                //.petrolEngineModule(new PetrolEngineModule(100))
                .build();
        // By calling inject we tell dagger to take activity and inject the member variable which are
        // annotated to @Inject.
        carComponent.inject(this);
        car.drive();
    }
}
