package com.android.hoatdongngoaikhoa;


import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UpcomingActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        getSupportActionBar().hide();

        viewPager = (ViewPager)findViewById(R.id.fragmentContainerView);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
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