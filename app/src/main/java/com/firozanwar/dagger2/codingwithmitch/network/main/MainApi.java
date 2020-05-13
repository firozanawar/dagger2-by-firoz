package com.firozanwar.dagger2.codingwithmitch.network.main;

import com.firozanwar.dagger2.codingwithmitch.model.Post;
import com.firozanwar.dagger2.codingwithmitch.model.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    // /posts?userId=1/
    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(
            @Query("userId") int id
    );
}
