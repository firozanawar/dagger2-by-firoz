package com.firozanwar.dagger2.codingwithmitch.network.auth;

import com.firozanwar.dagger2.codingwithmitch.model.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

//    @GET
//    Call<ResponseBody> getUsers();

    // We can use Flowable here from Rx Java by using below depndency becuase retrofit itself doesnt have
    @GET("users/{id}")
    Flowable<User> getUsers(
            @Path("id") int id

    );
}
