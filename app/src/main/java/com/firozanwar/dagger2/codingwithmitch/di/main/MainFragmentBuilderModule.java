package com.firozanwar.dagger2.codingwithmitch.di.main;

import com.firozanwar.dagger2.codingwithmitch.ui.main.post.PostFragment;
import com.firozanwar.dagger2.codingwithmitch.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostFragment contributePostFragment();
}
