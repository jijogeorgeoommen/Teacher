package com.example.teacher.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teacher.Models.ProfileModel;
import com.example.teacher.Models.TeacherDetail;
import com.example.teacher.R;
import com.example.teacher.Retrofit.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherViewProfileScroll extends AppCompatActivity {

    TextView t_profile_reg,t_profile_name,t_profile_branch,t_profile_desig,t_profile_phone,t_profile_email,teachername;
    private ArrayList<ProfileModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view_profile_scroll);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getApplicationContext(), fab);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(),"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();







                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });





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
//                    //  showOption(R.id.action_info);
//                } else if (isShow) {
//                    isShow = false;
//                    // hideOption(R.id.action_info);
//                }
//            }
//        });
//

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pre",MODE_PRIVATE);
        String t_regno=sharedPreferences.getString("teacher_reg",null);

        final Utils utils=new Utils();
        Call<ProfileModel> profileModelCall=utils.getApi().profile("qwerty");
        profileModelCall.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {



                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response success", Toast.LENGTH_SHORT).show();
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
                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
                        collapsingToolbarLayout.setTitleEnabled(false);
                        toolbar.collapseActionView();
                        toolbar.setTitle("title");
                        toolbar.setTitle(ls.get(i).getTeacherName());


                    }

                    // Toast.makeText(View_teacherprofile.this, ""+ls.size(), Toast.LENGTH_SHORT).show();




                }
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

            }
        });








    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher_view_profile_scroll, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.updatepro:
                Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG).show();
                return true;
            case R.id.updatepass:
                Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
