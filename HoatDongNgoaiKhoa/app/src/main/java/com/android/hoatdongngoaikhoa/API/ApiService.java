package com.android.hoatdongngoaikhoa.API;

import com.android.hoatdongngoaikhoa.Class.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.6:8081/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    //Call API
    @POST("student/login")
    Call<Student> login(@Body Student student);

    @GET("student/")
    Call<String> getStudentInfor(@Query("msv") String msv);

    @POST("student/register")
    Call<Student> register(@Body Student student);
}
