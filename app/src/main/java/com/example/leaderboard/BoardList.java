package com.example.leaderboard;

public class BoardList {

    private String userName;
    private String userHours;
    private String userCountry;
    private String badgeUrl;

    public BoardList(String userName, String userHours, String userCountry, String badgeUrl) {
        this.userName = userName;
        this.userHours = userHours;
        this.userCountry = userCountry;
        this.badgeUrl = badgeUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHours() {
        return userHours;
    }

    public void setUserHours(String userHours) {
        this.userHours = userHours;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
