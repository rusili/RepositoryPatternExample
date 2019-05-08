package com.example.repositorypatternpractice.data;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface someApi {

    @GET("")
    Single<ResponseBody> getStuff();
}
