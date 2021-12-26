package com.android.hoatdongngoaikhoa.API;

import com.android.hoatdongngoaikhoa.Class.Activity;
import com.android.hoatdongngoaikhoa.Class.Student;
import com.android.hoatdongngoaikhoa.Class.student_activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
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

    @PUT("student/{id}")
    Call<Student> updateStudent(@Body Student student, @Path("id") long id);

    @GET("activity/list")
    Call<List<Activity>> getListActivity();

    @GET("activity/listInFuture")
    Call<List<Activity>> getListActivityInFuture();

    @POST("student_activity")
    Call<student_activity> registerActivity(@Body student_activity stu_act);

    @DELETE("student_activity")
    Call<student_activity> CancelRegisterActivity(@Query("id") Long id);

    @POST("student_activity/listActivityOfStudent")
    Call<List<Activity>> listActivittyOfStudent(@Body Student student);

    @POST("student_activity/listActivityOfStudentFuture")
    Call<List<Activity>> listActivittyOfStudentFuture(@Body Student student);

    @POST("student_activity/listStudentOfActivity")
    Call<Integer> listStudentOfActivity(@Body Activity Activity);

    @POST("student_activity/check")
    Call<student_activity> checkExistStudentInActivity(@Body student_activity stu_act);

    @POST("student_activity/historyActivityOfStudent")
    Call<List<Activity>> historyActivittyOfStudent(@Body Student student);

    @GET("activity")
    Call<Activity> getDetailActivity(@Query("code") String code);
}
