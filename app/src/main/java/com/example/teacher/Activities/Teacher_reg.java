package com.example.teacher.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teacher.Models.Regmodel;
import com.example.teacher.R;
import com.example.teacher.Retrofit.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teacher_reg extends AppCompatActivity {

    EditText teacher_regno,teacher_name,teacher_branch,teacher_desig,teacher_pass,teacher_phone,teacher_email;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        teacher_regno=(EditText)findViewById(R.id.teacherregregno);
        teacher_name=(EditText)findViewById(R.id.teacherregname);
        teacher_branch=(EditText)findViewById(R.id.teacherregbranch);
        teacher_desig=(EditText)findViewById(R.id.teacherregdesig);
        teacher_pass=(EditText)findViewById(R.id.teacherregpass);
        teacher_phone=(EditText)findViewById(R.id.teacherregphn);
        teacher_email=(EditText)findViewById(R.id.teacherregemail);

        submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String t_regno=teacher_regno.getText().toString();
                final String t_name=teacher_name.getText().toString();
                final String t_branch=teacher_branch.getText().toString();
                final String t_desig=teacher_desig.getText().toString();
                final String t_pass=teacher_pass.getText().toString();
                final String t_phone=teacher_phone.getText().toString();
                final String t_email=teacher_email.getText().toString();






                Utils utils=new Utils();
                Call<Regmodel>regmodelCall=utils.getApi().register(t_regno,t_name,t_branch,t_desig,t_pass,t_phone,t_email);
                regmodelCall.enqueue(new Callback<Regmodel>() {
                    @Override
                    public void onResponse(Call<Regmodel> call, Response<Regmodel> response) {
                        Toast.makeText(Teacher_reg.this, "Respone success", Toast.LENGTH_SHORT).show();

                        String s=response.body().Status;

                        if (s.equalsIgnoreCase("success")){
                            Toast.makeText(Teacher_reg.this, "Registeration Success...", Toast.LENGTH_SHORT).show();

                            Intent reg=new Intent(Teacher_reg.this,Teacher_signin.class);
                            startActivity(reg);
                        }
                    }

                    @Override
                    public void onFailure(Call<Regmodel> call, Throwable t) {

                    }
                });

            }
        });
    }
}
