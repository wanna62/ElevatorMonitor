package com.elevator.elevatormonitor.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elevator.elevatormonitor.R;
import com.elevator.elevatormonitor.Retrofit.RetrofitUtils;
import com.elevator.elevatormonitor.beans.BaseResponse;

import retrofit2.Response;

public class HomeFragment extends Fragment {

    private ImageView elevatorIV,upTV,downIV;
    private TextView timeIV,dataIV,floorIV;
    private TextView mQueryTv,mActionTv;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        elevatorIV = view.findViewById(R.id.elevator);
        upTV = view.findViewById(R.id.diret_up);
        downIV = view.findViewById(R.id.diret_down);
        timeIV = view.findViewById(R.id.time);
        dataIV = view.findViewById(R.id.date);
        floorIV = view.findViewById(R.id.message_floor);
        mQueryTv = view.findViewById(R.id.query);
        mActionTv = view.findViewById(R.id.query_action);

        mActionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMonitor("0026F04BF80");
            }
        });
        floorIV.setText("3");
    }


    private void getMonitor(String id){

        RetrofitUtils.getAllMonitor(new MonitorBack());
    }


    private class MonitorBack implements RetrofitUtils.CallBack{
        public void onSuccess(Response<BaseResponse> baseResponse){
            Log.e("111111--->>>","onSuccess:");
        }

        @Override
        public void onFail(Throwable t) {
            Log.e("111111--->>>","onFail:");
        }
    }
}
