package com.elevator.elevatormonitor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.elevator.elevatormonitor.Fragment.NoticeFragment;

public class NoticeContentActivity extends Activity {
    public static void actionStart(Context context,String noticeTitle,String noticeContent){
        Intent intent=new Intent(context,NoticeContentActivity.class);
        intent.putExtra("notice_title",noticeTitle);
        intent.putExtra("notice_content",noticeContent);
        context.startActivity(intent);
    }

  /* @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notice_content);
        String noticeTitle=getIntent().getStringExtra("notice_title");
        String noticeContent=getIntent().getStringExtra("notice_content");
        NoticeFragment noticeFragment=(NoticeFragment) getFragmentManager().findFragmentById(R.id.notice_content_fragment);
        noticeFragment.refresh(noticeTitle,noticeContent);
    }*/
}
