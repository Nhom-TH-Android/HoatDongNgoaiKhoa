package com.android.hoatdongngoaikhoa;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.Class.Student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    EditText vDiemHD, vMsv, vHoTen, vLop, vSDT, vEmail, vGioiTinh;
    TextView vNgSinh;
    Button btnUpdate;
    Student student;
    String password;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        vDiemHD=(EditText) view.findViewById(R.id.vDiemHD);
        vMsv=(EditText) view.findViewById(R.id.vMsv);
        vHoTen=(EditText) view.findViewById(R.id.vHoTen);
        vLop=(EditText) view.findViewById(R.id.vLop);
        vSDT=(EditText) view.findViewById(R.id.vSDT);
        vNgSinh=(TextView) view.findViewById(R.id.vNgSinh);
        vEmail=(EditText) view.findViewById(R.id.vEmail);
        Bundle bundle=getArguments();
        if (bundle!=null) {
//            vMsv.setText(bundle.getString("name"));
//            Log.e("Test transfer", bundle.getString("name"));
            student = (Student) bundle.get("object");
            password = (String) bundle.getString("password");
            Log.e("Profile transfer", student.getMsv() + " " + student.getPassword() + " " + student.getDiemHD() + " " + student.getTen() + " " + student.getLop() + " " + student.getSDT() + " " + student.getEmail() + " " + student.getPassword());
            Log.e("Password", password+"");
        }
        vNgSinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickDate();
            }
        });
        btnUpdate=(Button) view.findViewById(R.id.button);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen=vHoTen.getText().toString();
                String lop=vLop.getText().toString();
                String sdt= vSDT.getText().toString();
                String ngSinh=vNgSinh.getText().toString();
                Log.e("NgSinh", ngSinh+" ");
                String email=vEmail.getText().toString();
                student.setPassword(password);
                student.setTen(hoTen);
                student.setLop(lop);
                student.setSDT(sdt);
                student.setNgSinh(ngSinh);
                Log.e("NgSinh", student.getNgSinh()+" ");
                student.setEmail(email);
                long id=student.getId();
                Log.e("Profile transfer", id+" "+student.getMsv()+" "+ student.getPassword()+" "+ student.getDiemHD()+" "+ student.getTen()+" "+ student.getLop()+" "+ student.getSDT()+" "+ student.getEmail()+" "+ student.getPassword());
                if (!hoTen.isEmpty() && !lop.isEmpty() && !sdt.isEmpty() && !ngSinh.isEmpty() && !email.isEmpty()) {
                    ApiService.apiService.updateStudent(student, id).enqueue(new Callback<Student>() {
                        @Override
                        public void onResponse(Call<Student> call, Response<Student> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(ProfileFragment.this.getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<Student> call, Throwable t) {
                            Toast.makeText(ProfileFragment.this.getContext(), "Cập nhật không thành công", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ProfileFragment.this.getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        Bundle bundle=getArguments();
//        if (bundle!=null){
////            vMsv.setText(bundle.getString("name"));
////            Log.e("Test transfer", bundle.getString("name"));
//            student=(Student) bundle.get("object");
//            password=(String) bundle.getString("password");
//            Log.e("Profile transfer", student.getMsv()+" "+ student.getPassword()+" "+ student.getDiemHD()+" "+ student.getTen()+" "+ student.getLop()+" "+ student.getSDT()+" "+ student.getEmail()+" "+ student.getPassword());
//            if (student!=null){
            int diemHD=student.getDiemHD();
            String msv=student.getMsv();
            String hoTen=student.getTen();
            String lop=student.getLop();
            String sdt=student.getSDT();
            String ngSinh=student.getNgSinh();
            Log.e("Date", jsonDateToUtilDateConverter(ngSinh)+"");
//            Date dob=new Date(txtdob);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String Dob = formatter.format(jsonDateToUtilDateConverter(ngSinh));
        Log.e("Date", Dob+"");
            String email=student.getEmail();
//            String jsonDate = "\"+"/Date(1008090000000)" + "/" + "\";
//            jsonDateToUtilDateConverter(jsonDate);
                vDiemHD.setText(String.valueOf(diemHD).trim());
                vMsv.setText(msv.toString().trim());
                vHoTen.setText(hoTen.toString());
                vLop.setText(lop.toString().trim());
                vSDT.setText(sdt.toString().trim());
                vNgSinh.setText(Dob.toString());
                vEmail.setText(email.toString().trim());
//        }
        return view;
    }
    private void PickDate(){
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePick=new DatePickerDialog(this.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                vNgSinh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePick.show();
    }
    private static Date jsonDateToUtilDateConverter(String jsonDate) {
        String epochDate = jsonDate.replaceAll("[^0-9]", "");

        Date date = new Date(Long.parseLong(epochDate));
        return date;
    }

}