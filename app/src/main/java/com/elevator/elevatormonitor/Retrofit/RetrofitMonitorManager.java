package com.elevator.elevatormonitor.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMonitorManager {
    private static RetrofitMonitorManager mInstance;
    private static String baseUrl="http://172.20.17.57:8081";
    private static String publicBaseUrl="http://112.74.63.8:8081";

    public static RetrofitMonitorManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitMonitorManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitMonitorManager();
                }
            }
        }
        return mInstance;
    }


    public Retrofit getRetrofit(){
        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(publicBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

}
