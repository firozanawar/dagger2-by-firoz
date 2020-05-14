package com.firozanwar.dagger2.codingwithmitch.di.main;

import com.firozanwar.dagger2.codingwithmitch.network.main.MainApi;
import com.firozanwar.dagger2.codingwithmitch.ui.main.post.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static PostsRecyclerAdapter provideAdapter(){
        return new PostsRecyclerAdapter();
    }

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
