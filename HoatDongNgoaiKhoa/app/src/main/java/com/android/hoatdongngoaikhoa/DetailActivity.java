package com.android.hoatdongngoaikhoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.Class.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private Activity detailActivity;
    TextView vTitle, vTime, vDescription, vAddress, vPoint, vQuantity, vQuantityRegister;
    static Integer countStudentInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        vTitle=(TextView) findViewById(R.id.name);
        vTime=(TextView) findViewById(R.id.time);
        vDescription=(TextView) findViewById(R.id.detail);
        vAddress=(TextView) findViewById(R.id.address);
        vPoint=(TextView) findViewById(R.id.point);
        vQuantity=(TextView) findViewById(R.id.quantity);
        vQuantityRegister=(TextView) findViewById(R.id.quantityRegister);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            Activity activity=new Activity();
            Log.e("Activity", "Activity not null");
            activity= (Activity) bundle.get("objectActivity");
            if (activity!=null){
                detailActivity=activity;
                Log.e("Activity transfer", detailActivity.getCode()+" "+ detailActivity.getName());
//                Date date=new Date(detailActivity.getThoiGian());
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                String DATE = formatter.format(date);
                ApiService.apiService.listStudentOfActivity(detailActivity).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        countStudentInActivity= response.body();
                        Log.e("count", countStudentInActivity+"");
                        Log.e("count2", detailActivity.getSoLuong()+"");
                        Log.e("count3", detailActivity.getCode()+"");
                        String stringDate=detailActivity.getThoiGian();
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm yyyy-MM-dd");
                        String date = formatter.format(jsonDateToUtilDateConverter(stringDate));
                        vTitle.setText(detailActivity.getName().toString());
                        vTime.setText("Thời gian: "+ date);
                        vDescription.setText("Thông tin chi tiết: "+detailActivity.getDescription().toString());
                        vAddress.setText("Địa điểm: "+detailActivity.getDiaDiem().toString());
                        vPoint.setText("Điểm hoạt động: "+detailActivity.getDiem());
                        vQuantity.setText("Số lượng: "+ detailActivity.getSoLuong());
                        vQuantityRegister.setText("Số lượng đã đăng ký: "+countStudentInActivity);
                    }
                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {

                    }
                });

            }
        }
        else{
            Log.e("User null", "User null");
        }
    }
    private static Date jsonDateToUtilDateConverter(String jsonDate) {
        String epochDate = jsonDate.replaceAll("[^0-9]", "");

        Date date = new Date(Long.parseLong(epochDate));
        return date;
    }
}