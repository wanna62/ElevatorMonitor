package com.elevator.elevatormonitor.beans;

public class BaseResponse<T> {
    private int status;
    private String msg;
    private T data;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

}
