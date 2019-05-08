package com.elevator.elevatormonitor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.elevator.elevatormonitor.R;
import com.elevator.elevatormonitor.basic.Notice;

import java.util.List;

public class NoticeAdapter extends ArrayAdapter<Notice> {
    private int resourceId;
    public NoticeAdapter(Context context, int noticeViewResourceId, List<Notice> objects){
        super(context,noticeViewResourceId,objects);
        resourceId=noticeViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Notice notice=getItem(position);
        View view;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else
        {
            view=convertView;
        }
        TextView noticeItem=(TextView)view.findViewById(R.id.noticeTitle);
        noticeItem.setText(notice.getTitle());
        return view;
    }
}
