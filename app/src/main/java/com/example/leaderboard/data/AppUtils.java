package com.example.leaderboard.data;

public class AppUtils {


    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    public static UserService mService(){
        return RetrofitBuilder.getRetrofit(BASE_URL).create(UserService.class);
    }
}


