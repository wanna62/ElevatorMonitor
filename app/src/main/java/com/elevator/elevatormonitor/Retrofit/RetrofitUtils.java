package com.elevator.elevatormonitor.Retrofit;

import com.elevator.elevatormonitor.beans.BaseResponse;
import com.elevator.elevatormonitor.api.UserApi;

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
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("password", password);

        StringBuffer data = new StringBuffer();
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append("&");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), jso);
        RetrofitManager.getInstance().getRetrofit().create(UserApi.class).login(requestBody).enqueue(new Callback<BaseResponse>() {
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
}
