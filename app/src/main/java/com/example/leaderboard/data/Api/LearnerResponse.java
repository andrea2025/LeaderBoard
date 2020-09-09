package com.example.leaderboard.data.Api;

import com.google.gson.annotations.SerializedName;

public class LearnerResponse {

    @SerializedName("name")
    private String Username;

    @SerializedName("hours")
    private String Hours;

    @SerializedName("country")
    private String Country;

    @SerializedName("badgeUrl")
    private String Badge;

    public LearnerResponse(String username, String hours, String country, String badge) {
        Username = username;
        Hours = hours;
        Country = country;
        Badge = badge;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
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
