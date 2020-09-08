package com.example.leaderboard.data.Api;

import com.google.gson.annotations.SerializedName;

public class Skills {

    @SerializedName("name")
    private String Username;

    @SerializedName("score")
    private String Score;

    @SerializedName("country")
    private String Country;

    @SerializedName("badgeUrl")
    private String Badge;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getBadge() {
        return Badge;
    }

    public void setBadge(String badge) {
        Badge = badge;
    }
}
