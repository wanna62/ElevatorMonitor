package com.elevator.elevatormonitor.Fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.elevator.elevatormonitor.MainActivity;
import com.elevator.elevatormonitor.R;
import com.elevator.elevatormonitor.adapter.NoticeAdapter;
import com.elevator.elevatormonitor.basic.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends Fragment {
    private List<Notice> noticeList=new ArrayList<Notice>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.notice_content_frag,container,false);
        return view;
    }
    public void refresh(String noticeTitle,String newsContent){
        View visibilityLayout= getView().findViewById(R.id.visible_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText=(TextView) getView().findViewById(R.id.notice_title);
        TextView newsContentText=(TextView) getView().findViewById(R.id.notice_content);
        newsTitleText.setText(noticeTitle);
        newsContentText.setText(newsContent);
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        NoticeAdapter adapter = new NoticeAdapter(this.getActivity(), R.layout.fragment_notice, noticeList);
//        ListView listView = view.findViewById(R.id.listNotice);
//        listView.setAdapter(adapter);
//    }
}
