package com.example.teacher.Retrofit;

import com.example.teacher.Models.Loginmodel;
import com.example.teacher.Models.ProfileModel;
import com.example.teacher.Models.Regmodel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {
    @GET("register.php?")
    Call<Regmodel> register(@Query("teacher_regno")String tregno, @Query("name")String tname, @Query("branch")String tbranch, @Query("password") String tpassword, @Query("desigination") String tdesig, @Query("phonenumber")String tphone, @Query("email") String temail);
    @GET("login.php?")
    Call<Loginmodel>login(@Query("teacher_regno") String treg, @Query("password")String tpass);
    @GET("viewprofile.php?")
    Call<ProfileModel>profile(@Query("teacher_regno")String registerno);
}
