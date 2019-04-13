package com.example.teacher.Activities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.teacher.R;

public class MainActivity extends AppCompatActivity {

    Button teacher,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacher=findViewById(R.id.teacherbtn);
        student=findViewById(R.id.studentbtn);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflat=LayoutInflater.from(MainActivity.this);
                View cuslay=inflat.inflate(R.layout.teacher_login_reg,null);

                Button tech_reg=cuslay.findViewById(R.id.teacherregbtn);
                Button tech_login=cuslay.findViewById(R.id.teacherloginbtn);

                AlertDialog.Builder AB=new AlertDialog.Builder(MainActivity.this);
                AB.setView(cuslay);
                final AlertDialog A=AB.create();
                A.show();
                tech_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent b=new Intent(MainActivity.this,Teacher_signin.class);
                        startActivity(b);
                    }
                });

                tech_reg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i=new Intent(MainActivity.this,Teacher_reg.class);
                        startActivity(i);

                    }
                });


            }
        });



    }
}
