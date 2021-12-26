package com.android.hoatdongngoaikhoa;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.android.hoatdongngoaikhoa.Class.Student;

import java.util.HashMap;
import java.util.Map;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    Student student;
    String password;
//    private Map<Integer, String> mFragmentTags;
//    private FragmentManager mFragmentManager;
//    private Context mContext;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Student student, String password) {
        super(fm, behavior);
//        mFragmentManager=fm;
//        mFragmentTags=new HashMap<Integer, String>();
//        mContext=context;
        this.student = student;
        this.password=password;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                UpComingFragment upc= new UpComingFragment();
            if (student!=null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", student);
                bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                upc.setArguments(bundle);
            }
            return upc;
            case 1:
                RegisterFragment reg= new RegisterFragment();
            if (student!=null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", student);
                bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                reg.setArguments(bundle);
            }
            return reg;
            case 2:
                HistoryFragment his= new HistoryFragment();
            if (student!=null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", student);
                bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                his.setArguments(bundle);
            }
            return his;
            case 3:
                NotificationFragment noti= new NotificationFragment();
            if (student!=null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", student);
                bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                noti.setArguments(bundle);
            }
            return noti;
            case 4:
                ProfileFragment profile= new ProfileFragment();
                if (student!=null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object", student);
                    bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                    profile.setArguments(bundle);
                }
                return profile;
            default:
                UpComingFragment upc1= new UpComingFragment();
                if (student!=null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object", student);
                    bundle.putString("password", password);
//                bundle.putString("name", "Pham Van Dong");
                    upc1.setArguments(bundle);
                }
                return upc1;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position){
//        Object obj=super.instantiateItem(container, position);
//        if (obj instanceof Fragment){
//            Fragment f=(Fragment) obj;
//            String tag= f.getTag();
//            mFragmentTags.put(position, tag);
//        }
//        return obj;
//    }
//    public Fragment getFragment(int position){
//        String tag=mFragmentTags.get(position);
//        if (tag==null){
//            return null;
//        }
//        return mFragmentManager.findFragmentByTag(tag);
//    }
}
