package com.elevator.elevatormonitor.api;

import com.elevator.elevatormonitor.beans.BaseResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/api/v1/sso/user/login")
    Call<BaseResponse> login(@Body RequestBody requestBody);
}
