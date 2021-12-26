package com.android.hoatdongngoaikhoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.hoatdongngoaikhoa.API.ApiService;
import com.android.hoatdongngoaikhoa.Class.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btnSignIn;
    private EditText txtUser;
    private EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnSignIn = (Button) findViewById(R.id.btnLogin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUser.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty()) {
                    Student loginStudent = new Student();
                    loginStudent.setMsv(username);
                    loginStudent.setPassword(password);
                    Log.e("User", " " + loginStudent.getPassword());
                    clickLogin(loginStudent, password);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
                    Log.e("API Error", "username or password null");
                    return;
                }
            }
        });
    }
    private void clickLogin(Student studentLogin, String password){
        ApiService.apiService.login(studentLogin).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                Student student = response.body();
                if (student == null) {
                    Toast.makeText(MainActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    Log.e("No User", "User is null");
                    return;
                }
                    Log.e("User", student.getMsv() + " " +student.getPassword());
                    Intent intent = new Intent(MainActivity.this, UpcomingActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("objectUser", student);
                    bundle.putString("password", password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                Log.e("Password", password+"");

            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                Log.e("API Error", "Call API Error. Mật khẩu k hợp lệ");
            }
        });
    }
}