package com.elevator.elevatormonitor.beans;

public class LoginBean extends BaseResponse{
    private String id;
    private String name;
    private String userId;
    private String companyId;
    private String roleName;
    private int code;
    private String token;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getCompanyId() {
        return companyId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}