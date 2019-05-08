package com.elevator.elevatormonitor.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtils {

    private JsonUtils() {

    }

    public static <T>T fromJson(String json,Class<T> type){
        Gson gson = new Gson();
        return gson.fromJson(json,type);

    }

    public static <T> List<T> listFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
    }

}
