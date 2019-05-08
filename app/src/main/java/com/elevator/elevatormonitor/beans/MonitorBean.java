package com.elevator.elevatormonitor.beans;

public class MonitorBean {


    private MonitorInfo monitorInfo;
    private Elevator elevator;
    public void setMonitorInfo(MonitorInfo monitorInfo) {
        this.monitorInfo = monitorInfo;
    }
    public MonitorInfo getMonitorInfo() {
        return monitorInfo;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
    public Elevator getElevator() {
        return elevator;
    }

}
