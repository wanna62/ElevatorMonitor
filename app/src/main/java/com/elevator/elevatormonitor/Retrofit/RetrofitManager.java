package com.elevator.elevatormonitor.Retrofit;

public class RetrofitManager {
    private static RetrofitManager mInstance;

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }


    private void getRetrofit(){

    }

}
