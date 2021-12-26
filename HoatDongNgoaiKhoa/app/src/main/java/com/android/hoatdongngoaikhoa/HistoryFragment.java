package com.android.hoatdongngoaikhoa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.Class.Activity;
import com.android.hoatdongngoaikhoa.Class.ActivityAdapter;
import com.android.hoatdongngoaikhoa.Class.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    ListView lvActivity;
    List<Activity> listActivity;
    ActivityAdapter adapterActivity;
    Student student;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);
        listActivity=new ArrayList<>();
        lvActivity=view.findViewById(R.id.lvHistory);
        AnhXa(lvActivity);
        return view;
    }
    public void AnhXa(ListView lvActivity)
    {
        listActivity=new ArrayList<>();
        Bundle bundle=getArguments();
        if (bundle!=null) {
            student = (Student) bundle.get("object");
            Log.e("Student Register", student.getMsv()+"");
        }
        Student GetStudent=student;
        ApiService.apiService.historyActivittyOfStudent(GetStudent).enqueue(new Callback<List<Activity>>() {
            @Override
            public void onResponse(Call<List<Activity>> call, Response<List<Activity>> response) {
                listActivity =  response.body();
                if (listActivity!=null)
                {
                    adapterActivity=new ActivityAdapter(HistoryFragment.this.getContext(), R.layout.line_activity, listActivity, "Lịch sử", GetStudent);
                    lvActivity.setAdapter(adapterActivity);
                }
            }

            @Override
            public void onFailure(Call<List<Activity>> call, Throwable t) {
                Log.e("Call API", "Call API Error");
                Toast.makeText(HistoryFragment.this.getContext(), "Call API Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}