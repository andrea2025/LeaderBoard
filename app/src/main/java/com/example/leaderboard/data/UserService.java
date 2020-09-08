package com.example.leaderboard.data;


import com.example.leaderboard.data.Api.LearnerResponse;
import com.example.leaderboard.data.Api.Skills;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;



public interface UserService {

    @GET("api/hours")
    Call <List<LearnerResponse>> learner();

    @GET("api/skilliq")
    Call<List<Skills>> skill();


}
