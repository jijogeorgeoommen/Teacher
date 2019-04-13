package com.example.teacher.Activities;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.teacher.Models.ProfileModel;
import com.example.teacher.Models.TeacherDetail;
import com.example.teacher.R;
import com.example.teacher.Retrofit.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_teacherprofile extends AppCompatActivity {

    TextView t_profile_reg,t_profile_name,t_profile_branch,t_profile_desig,t_profile_phone,t_profile_email,teachername;
    private ArrayList<ProfileModel>data;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teacherprofile);






     //   teachername=(TextView)findViewById(R.id//.profileholder);

        t_profile_reg=(TextView)findViewById(R.id.tprofilereg);
        t_profile_name=(TextView)findViewById(R.id.tprofilename);
        t_profile_branch=(TextView)findViewById(R.id.tprofilebranch);
        t_profile_desig=(TextView)findViewById(R.id.tprofiledesig);
        t_profile_phone=(TextView)findViewById(R.id.tprofilephone);
        t_profile_email=(TextView)findViewById(R.id.tprofileemail);

//        final android.support.v7.widget.Toolbar mToolbar =  findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
//        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    isShow = true;
//                  //  showOption(R.id.action_info);
//                } else if (isShow) {
//                    isShow = false;
//                   // hideOption(R.id.action_info);
//                }
//            }
//        });
//

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pre",MODE_PRIVATE);
        String t_regno=sharedPreferences.getString("teacher_reg",null);

    final Utils utils=new Utils();
        Call<ProfileModel>profileModelCall=utils.getApi().profile("qwerty");
        profileModelCall.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {



                if (response.isSuccessful()){
                    Toast.makeText(View_teacherprofile.this, "response success", Toast.LENGTH_SHORT).show();
                    String s=response.body().getResult();


                    List<TeacherDetail> ls= (List<TeacherDetail>) response.body().getTeacherDetails();



                    String result = TextUtils.join(", ",  response.body().getTeacherDetails());


                    for(int i=0;i<ls.size();i++){
                        t_profile_name.setText(ls.get(i).getTeacherName());
                        t_profile_reg.setText(ls.get(i).getTeacherRegNo());
                        t_profile_branch.setText(ls.get(i).getTeacherRegNo());
                        t_profile_desig.setText(ls.get(i).getTeacherDesigination());
                        t_profile_phone.setText(ls.get(i).getTeacherPhoneNumber());
                        t_profile_email.setText(ls.get(i).getTeacherEmail());
                        teachername.setText(ls.get(i).getTeacherName());


                    }

                   // Toast.makeText(View_teacherprofile.this, ""+ls.size(), Toast.LENGTH_SHORT).show();




                }
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

            }
        });





    }
//
//    private void hideOption(int id) {
//        MenuItem item = menu.findItem(id);
//        item.setVisible(false);
//    }
//
//    private void showOption(int id) {
//        MenuItem item = menu.findItem(id);
//        item.setVisible(true);
//    }
}
