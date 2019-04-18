package com.elevator.elevatormonitor.beans;

public class LoginBean extends BaseResponse{
        private String token;
        private String username;
        public void setToken(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }
}