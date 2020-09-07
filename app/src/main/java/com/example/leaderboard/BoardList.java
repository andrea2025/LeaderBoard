package com.example.leaderboard;

public class BoardList {
    private String UserName;
    private String UserInfo;

    public BoardList(String userName, String userInfo) {
        UserName = userName;
        UserInfo = userInfo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        UserInfo = userInfo;
    }
}
