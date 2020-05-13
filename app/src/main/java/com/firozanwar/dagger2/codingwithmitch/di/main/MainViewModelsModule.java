package com.firozanwar.dagger2.codingwithmitch.di.main;

import androidx.lifecycle.ViewModel;

import com.firozanwar.dagger2.codingwithmitch.di.ViewModelKey;
import com.firozanwar.dagger2.codingwithmitch.ui.auth.AuthViewModel;
import com.firozanwar.dagger2.codingwithmitch.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindMainViewModel(ProfileViewModel profileViewModel);
}
