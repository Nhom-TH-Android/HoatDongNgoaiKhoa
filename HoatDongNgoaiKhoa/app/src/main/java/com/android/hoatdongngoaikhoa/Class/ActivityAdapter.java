package com.android.hoatdongngoaikhoa.Class;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.DetailActivity;
import com.android.hoatdongngoaikhoa.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Activity>activityList;
    String title;
    Student student;
    Integer countStudentInActivity;
    public static student_activity delete;

    public ActivityAdapter(Context context, int layout, List<Activity> activityList, String title, Student student) {
        this.context = context;
        this.layout = layout;
        this.activityList = activityList;
        this.title=title;
        this.student=student;
    }

    @Override
    public int getCount() {
        return activityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout, null);
        TextView vTitle=(TextView) convertView.findViewById(R.id.vTilte);
        TextView vTime=(TextView) convertView.findViewById(R.id.vTime);
        TextView vAddress=(TextView) convertView.findViewById(R.id.vAddress);
        TextView vPoint=(TextView) convertView.findViewById(R.id.vPoint);
        Button btnSignUp=(Button) convertView.findViewById(R.id.btnSignUp);
        RelativeLayout lineActivity=(RelativeLayout) convertView.findViewById(R.id.lineActivity);
        Activity activity=activityList.get(position);
        vTitle.setText(activity.getName());
        String stringDate=activity.getThoiGian();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm yyyy-MM-dd");
        String date = formatter.format(jsonDateToUtilDateConverter(stringDate));
        vTime.setText("Th???i gian: "+date);
        vAddress.setText("?????a ??i???m: "+activity.getDiaDiem());
        vPoint.setText("??i???m ho???t ?????ng: "+activity.getDiem()+"");
        String msv;
        String code;
        msv=student.getMsv();
        Log.e("msv", msv+"");
        code=activity.getCode();
        Log.e("code", code+"");
        student_activity checkExistStudentActivity = new student_activity();
        checkExistStudentActivity.setActivity_id(code.toString());
        checkExistStudentActivity.setStudent_id(msv.toString());
        if (title.equals("L???ch s???")){
            btnSignUp.setText("???? ho??n th??nh");
            btnSignUp.setClickable(false);
        }
        else {
            ApiService.apiService.checkExistStudentInActivity(checkExistStudentActivity).enqueue(new Callback<student_activity>() {
                @Override
                public void onResponse(Call<student_activity> call, Response<student_activity> response) {
                    student_activity exist = response.body();
                    if (exist != null) {
                        delete = exist;
                        btnSignUp.setText("Hu???");
                    } else {
                        btnSignUp.setText("????ng k??");
                    }
                }

                @Override
                public void onFailure(Call<student_activity> call, Throwable t) {
                }
            });
        }
        Log.e("count4", activity.getCode()+"");
        ApiService.apiService.listStudentOfActivity(activity).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                countStudentInActivity= response.body();

                Log.e("count", countStudentInActivity+"");
                Log.e("count2", activity.getSoLuong()+"");
                Log.e("count3", activity.getCode()+"");
                if (countStudentInActivity==activity.getSoLuong() && btnSignUp.getText().equals("????ng k??")){
                    btnSignUp.setClickable(false);
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        if (btnSignUp.getText().equals("Hu???")){
            btnSignUp.setClickable(true);
        }
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Student Register", student.getMsv() + "");
                    Log.e("item", code + "");
                    student_activity stu_act = new student_activity();
                    stu_act.setActivity_id(code);
                    stu_act.setStudent_id(msv);

                    if (btnSignUp.getText().equals("????ng k??")) {
                        ApiService.apiService.registerActivity(stu_act).enqueue(new Callback<student_activity>() {
                            @Override
                            public void onResponse(Call<student_activity> call, Response<student_activity> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(ActivityAdapter.this.context, "????ng k?? th??nh c??ng", Toast.LENGTH_SHORT).show();
                                    btnSignUp.setText("Hu???");
                                }
                            }

                            @Override
                            public void onFailure(Call<student_activity> call, Throwable t) {
                                Toast.makeText(ActivityAdapter.this.context, "????ng k?? kh??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if (btnSignUp.getText().equals("Hu???")) {
//                    ApiService.apiService.checkExistStudentInActivity(checkExistStudentActivity).enqueue(new Callback<student_activity>() {
//                        @Override
//                        public void onResponse(Call<student_activity> call, Response<student_activity> response) {
//                            student_activity cancel= response.body();
//                            id=cancel.getId();
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<student_activity> call, Throwable t) {
//
//                        }
//                    });
                        ApiService.apiService.CancelRegisterActivity(delete.getId()).enqueue(new Callback<student_activity>() {
                            @Override
                            public void onResponse(Call<student_activity> call, Response<student_activity> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(ActivityAdapter.this.context, "Hu??? th??nh c??ng", Toast.LENGTH_SHORT).show();
                                    btnSignUp.setText("????ng k??");
                                }
                            }

                            @Override
                            public void onFailure(Call<student_activity> call, Throwable t) {
                                Toast.makeText(ActivityAdapter.this.context, "Hu??? kh??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });
            lineActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnSignUp.getText().equals("????ng k??") && btnSignUp.isClickable()==false)
                    {
                        Toast.makeText(ActivityAdapter.this.context, "???? ????? s??? l?????ng ????ng k??", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(ActivityAdapter.this.context, DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("objectActivity", activity);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        return convertView;
    }
    private static Date jsonDateToUtilDateConverter(String jsonDate) {
        String epochDate = jsonDate.replaceAll("[^0-9]", "");

        Date date = new Date(Long.parseLong(epochDate));
        return date;
    }
}
