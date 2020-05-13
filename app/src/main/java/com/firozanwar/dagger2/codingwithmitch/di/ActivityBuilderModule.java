package com.firozanwar.dagger2.codingwithmitch.di;

import com.firozanwar.dagger2.codingwithmitch.di.auth.AuthModule;
import com.firozanwar.dagger2.codingwithmitch.di.auth.AuthViewModelModule;
import com.firozanwar.dagger2.codingwithmitch.di.main.MainFragmentBuilderModule;
import com.firozanwar.dagger2.codingwithmitch.di.main.MainModule;
import com.firozanwar.dagger2.codingwithmitch.di.main.MainViewModelsModule;
import com.firozanwar.dagger2.codingwithmitch.ui.auth.AuthActivity;
import com.firozanwar.dagger2.codingwithmitch.ui.main.MainLandingActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    // This behave like a subComponent
    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    // Using this we can directly get the string  @Inject String myString in AuthActivity;
    /*@Provides
    static String someString() {
        return "Hi this string is getting injected from ActivityBuilderModule";
    }*/

    // This behave like a subComponent
    // MainFragmentBuilderModule will only be availble to MainLandingActivity
    @ContributesAndroidInjector(
            modules = {MainFragmentBuilderModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainLandingActivity contributeMainLandingActivity();
}
