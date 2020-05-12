package com.firozanwar.dagger2.codingwithmitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.firozanwar.dagger2.R;
import com.firozanwar.dagger2.codingwithmitch.viewmodels.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    @Inject
    String myString;

    @Inject
    boolean isApp;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProvidersFactory providersFactory;

    AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.d(TAG, "onCreate: " + myString);
        Log.d(TAG, "onCreate, App is : " + isApp);

        authViewModel = ViewModelProviders.of(this, providersFactory).get(AuthViewModel.class);

        // Loading logo with Glide library into imageview by injected RequestManager
        loadLogo();
    }

    private void loadLogo() {
        requestManager.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }
}
