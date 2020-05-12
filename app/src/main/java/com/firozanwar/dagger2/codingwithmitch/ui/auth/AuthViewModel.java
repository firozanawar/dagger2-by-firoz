package com.firozanwar.dagger2.codingwithmitch.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthActivity";

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel is working like a charm..");
    }
}
