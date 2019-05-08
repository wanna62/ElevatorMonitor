package com.elevator.elevatormonitor.Retrofit;

import com.elevator.elevatormonitor.Contens.AccountInfo;
import com.elevator.elevatormonitor.beans.Account;
import com.elevator.elevatormonitor.beans.BaseResponse;
import com.elevator.elevatormonitor.api.UserApi;
import com.elevator.elevatormonitor.beans.ElevatorBo2;
import com.google.gson.Gson;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitUtils {
    public static void login(String username, String password, final CallBack callBack) {
        Account account = new Account();
        account.setAccount(username);
        account.setPassword(password);

        Gson gson = new Gson();
        String postInfoStr = gson.toJson(account);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postInfoStr);

        RetrofitManager.getInstance().getRetrofit().create(UserApi.class).login(body).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                callBack.onSuccess(response);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callBack.onFail(t);
            }
        });
    }

    public static void register(String name, String phone, final CallBack callBack) {
        RetrofitManager.getInstance().getRetrofit().create(UserApi.class).register(name, phone, "cugb").enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                callBack.onSuccess(response);

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callBack.onFail(t);

            }
        });
    }


    public interface CallBack {
        void onSuccess(Response<BaseResponse> baseResponse);

        void onFail(Throwable t);
    }


    public static void getElevatorStatus(String id, final CallBack callBack) {
        RetrofitMonitorManager.getInstance().getRetrofit().create(UserApi.class).getElevatorStatus(id).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                callBack.onSuccess(response);

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callBack.onFail(t);

            }
        });
    }


    public static void getAllMonitor(final CallBack callBack) {

        ElevatorBo2 elevatorBo2 = new ElevatorBo2();
        elevatorBo2.setToken(AccountInfo.getUserInfo().getToken());

        Gson gson = new Gson();
        String postInfoStr = gson.toJson(elevatorBo2);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postInfoStr);

        RetrofitMonitorManager.getInstance().getRetrofit().create(UserApi.class).getAllMonitor(elevatorBo2).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                callBack.onSuccess(response);

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callBack.onFail(t);

            }
        });
    }
}
