package com.elevator.elevatormonitor.beans;

public class ElevatorBo2 {
    private String id;

    private String name;

    private String residentialId;

    private String buddingId;

    private String maintenanceId;

    private String mac;

    private String productionId;

    private String brandId;

    //接收token信息
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidentialId() {
        return residentialId;
    }

    public void setResidentialId(String residentialId) {
        this.residentialId = residentialId;
    }

    public String getBuddingId() {
        return buddingId;
    }

    public void setBuddingId(String buddingId) {
        this.buddingId = buddingId;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
