package com.firozanwar.dagger2.codingwithmitch.di;

import com.firozanwar.dagger2.codingwithmitch.di.auth.AuthModule;
import com.firozanwar.dagger2.codingwithmitch.di.auth.AuthViewModelModule;
import com.firozanwar.dagger2.codingwithmitch.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    // Using this we can directly get the string  @Inject String myString in AuthActivity;
    /*@Provides
    static String someString() {
        return "Hi this string is getting injected from ActivityBuilderModule";
    }*/
}
