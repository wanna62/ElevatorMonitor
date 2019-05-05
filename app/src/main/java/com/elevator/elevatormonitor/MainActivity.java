package com.elevator.elevatormonitor;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.elevator.elevatormonitor.view.Fragment.AccountFragment;
import com.elevator.elevatormonitor.view.Fragment.HomeFragment;
import com.elevator.elevatormonitor.view.Fragment.InformationFragment;
import com.elevator.elevatormonitor.view.Fragment.NoticeFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    private BottomNavigationView mBottomNavigationView;

    private int lastIndex;
    List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();
        initData();
    }

    public void initData(){
        mFragments=new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new NoticeFragment());
        mFragments.add(new InformationFragment());
        mFragments.add(new AccountFragment());
        setFragmentPosition(0);
    }
    public void initBottomNavigation(){
        mBottomNavigationView=findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        setFragmentPosition(0);
                        break;
                    case R.id.navigation_notice:
                        setFragmentPosition(1);
                        break;
                    case R.id.navigation_information:
                        setFragmentPosition(2);
                        break;
                    case R.id.navigation_account:
                        setFragmentPosition(3);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
    private void setFragmentPosition(int position){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        Fragment currentFragment=mFragments.get(position);
        Fragment lastFragment=mFragments.get(lastIndex);
        lastIndex=position;
        transaction.hide(lastFragment);
        if(!currentFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            transaction.add(R.id.mframelayout,currentFragment);
        }
        transaction.show(currentFragment);
        transaction.commitAllowingStateLoss();
    }

}
