package com.firozanwar.dagger2.codingwithmitch.di.auth;

import com.firozanwar.dagger2.codingwithmitch.model.User;
import com.firozanwar.dagger2.codingwithmitch.network.auth.AuthApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

    // Rotation will not give the same user1 because of AuthScope scope not singlton
    @AuthScope
    @Provides
    @Named("auth_user")
    static User someUser(){
        return new User();
    }
}
