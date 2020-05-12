package com.firozanwar.dagger2.codingwithmitch.di.auth;

import androidx.lifecycle.ViewModel;

import com.firozanwar.dagger2.codingwithmitch.di.ViewModelKey;
import com.firozanwar.dagger2.codingwithmitch.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);
}
