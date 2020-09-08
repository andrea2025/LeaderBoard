package com.example.leaderboard.data;


import com.example.leaderboard.data.Api.LearnerResponse;
import com.example.leaderboard.data.Api.Skills;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface UserService {

    @GET("api/hours")
    Call <List<LearnerResponse>> learner();

    @GET("api/skilliq")
    Call<List<Skills>> skill();

    @POST()
    @FormUrlEncoded
    Call<Void> submitProject(@Field("entry.1877115667") String name,
                             @Field("entry.2006916086") String lastName,
                             @Field("entry.1824927963") String email,
                             @Field("entry.284483984") String link, @Url String url);


}
