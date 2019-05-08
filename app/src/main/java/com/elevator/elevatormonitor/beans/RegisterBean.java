package com.elevator.elevatormonitor.beans;

public class RegisterBean extends BaseResponse{
    private String name;
    private String phone;
    private String companyId;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getCompanyId() {
        return companyId;
    }
}
