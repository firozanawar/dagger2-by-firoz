package com.firozanwar.dagger2.carexamplebycodinginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firozanwar.dagger2.R;

public class MainActivity extends AppCompatActivity {

    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent = DaggerCarComponent.create();
        car = carComponent.getCar();
        car.drive();
    }
}
