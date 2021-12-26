package com.android.hoatdongngoaikhoa;


import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.android.hoatdongngoaikhoa.Class.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UpcomingActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private Student account=null;
    private String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        getSupportActionBar().hide();
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            Student student=new Student();
            Log.e("User not null", "User not null");
            student= (Student) bundle.get("objectUser");
            password= (String) bundle.get("password");
            if (student!=null){
                account=student;
                Log.e("Account transfer", account.getMsv()+" "+ account.getPassword());
            }
        }
        else{
            Log.e("User null", "User null");
        }

        viewPager = (ViewPager)findViewById(R.id.fragmentContainerView);
        ViewPagerAdapter vpAdapter;
//        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        if (account==null) {
            vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }
        else {
            vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, account, password);
        }
        viewPager.setAdapter(vpAdapter);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.upComingFragment4:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.registerFragment:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.historyFragment:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.notificationFragment:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.profileFragment:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }
}