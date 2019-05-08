package com.elevator.elevatormonitor.Contens;

import com.elevator.elevatormonitor.beans.LoginBean;

public class AccountInfo {
    private static LoginBean UserInfo;

    public static LoginBean getUserInfo() {
        return UserInfo;
    }

    public static void setUserInfo(LoginBean userInfo) {
        UserInfo = userInfo;
    }
}
