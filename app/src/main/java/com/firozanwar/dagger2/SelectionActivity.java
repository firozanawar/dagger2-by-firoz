package com.firozanwar.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firozanwar.dagger2.carexamplebycodinginflow.MainActivity;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button btn = findViewById(R.id.btn_dagger2_car_example);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectionActivity.this.startActivity(new Intent(SelectionActivity.this, MainActivity.class));
            }
        });
//
//        btn = findViewById(R.id.btn_mvp_retrofit);
//        btn.setOnClickListener(v -> {
//            startActivity(new Intent(SelectionActivity.this, MVPwithRetrofitActivity.class));
//        });
    }
}
