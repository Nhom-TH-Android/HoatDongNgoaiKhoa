package com.android.hoatdongngoaikhoa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.Class.Activity;
import com.android.hoatdongngoaikhoa.Class.ActivityAdapter;
import com.android.hoatdongngoaikhoa.Class.Student;
import com.android.hoatdongngoaikhoa.Class.student_activity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    ListView lvActivity;
    List<Activity> listActivity;
    ActivityAdapter adapterActivity;
    Button btnSignUp;
    Student student;
    student_activity stu_act;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        listActivity=new ArrayList<>();
        lvActivity=view.findViewById(R.id.lvRegister);
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
        ApiService.apiService.getListActivityInFuture().enqueue(new Callback<List<Activity>>() {
            @Override
            public void onResponse(Call<List<Activity>> call, Response<List<Activity>> response) {
                listActivity =  response.body();
                if (listActivity!=null)
                {
                    adapterActivity=new ActivityAdapter(RegisterFragment.this.getContext(), R.layout.line_activity, listActivity, "Đăng ký", GetStudent);
                    lvActivity.setAdapter(adapterActivity);
//                    lvActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Activity activity = (Activity) parent.getAdapter().getItem(position);
//                            String msv=student.getMsv();
//                            String code=activity.getCode();
//                            stu_act.setActivity_id(code);
//                            stu_act.setStudent_id(msv);
//                            ApiService.apiService.registerActivity(stu_act).enqueue(new Callback<student_activity>() {
//                                @Override
//                                public void onResponse(Call<student_activity> call, Response<student_activity> response) {
//                                    if (response.isSuccessful()){
//                                        Toast.makeText(RegisterFragment.this.getContext(), "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                @Override
//                                public void onFailure(Call<student_activity> call, Throwable t) {
//                                    Toast.makeText(RegisterFragment.this.getContext(), "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        }
//                    });
                }
            }

            @Override
            public void onFailure(Call<List<Activity>> call, Throwable t) {
                Log.e("Call API", "Call API Error");
                Toast.makeText(RegisterFragment.this.getContext(), "Call API Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}