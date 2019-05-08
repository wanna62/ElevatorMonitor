package com.elevator.elevatormonitor.api;

import com.elevator.elevatormonitor.beans.BaseResponse;
import com.elevator.elevatormonitor.beans.ElevatorBo2;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("/account/login")
    Call<BaseResponse> login(@Body RequestBody requestBody);

    @POST("/user/create/createUser")
    Call<BaseResponse> register(@Query("name") String name, @Query("phone") String phone, @Query("companyId") String companyId);

    @GET("/floorDisplay/get/getFloorDisplayById/{id}")
    Call<BaseResponse> getElevatorStatus(@Path("id") String id);

    @POST("/elevator/get/getAllElevators")
    Call<BaseResponse> getAllMonitor(@Query("elevatorBo2")ElevatorBo2 elevatorBo2);
}
