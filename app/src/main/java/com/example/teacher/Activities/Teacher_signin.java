package com.example.teacher.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teacher.Models.Loginmodel;
import com.example.teacher.R;
import com.example.teacher.Retrofit.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teacher_signin extends AppCompatActivity {

    EditText regno,pass;
    Button signinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_signin);

        regno=(EditText)findViewById(R.id.teacherregno);
        pass=(EditText)findViewById(R.id.teacherpass);

        signinbtn=(Button)findViewById(R.id.submitlogin);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String t_reg=regno.getText().toString();
                String t_pass=pass.getText().toString();

                Utils utils=new Utils();
                Call<Loginmodel>loginmodelCall=utils.getApi().login(t_reg,t_pass);
                loginmodelCall.enqueue(new Callback<Loginmodel>() {
                    @Override
                    public void onResponse(Call<Loginmodel> call, Response<Loginmodel> response) {
                        Toast.makeText(Teacher_signin.this, "response success", Toast.LENGTH_SHORT).show();
                        Intent a=new Intent(Teacher_signin.this,View_teacherprofile.class);
                        String p=response.body().Status;
                        String reg=response.body().RegNo;

                        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pre",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("teacher_reg",reg);
                        editor.apply();

                        if (p.equalsIgnoreCase("success")){

                            if (reg.equals(t_reg)) {


                                Toast.makeText(Teacher_signin.this, "signin success", Toast.LENGTH_SHORT).show();
                                startActivity(a);
                            } else
                            {
                                Toast.makeText(Teacher_signin.this, "invalid Register No.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Teacher_signin.this, "invalid credentials..", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Loginmodel> call, Throwable t) {

                    }
                });

            }
        });



    }
}
