
package com.example.teacher.Models;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class ProfileModel {

    @SerializedName("Result")
    private String mResult;
    @SerializedName("TeacherDetails")
    private List<TeacherDetail> mTeacherDetails;

    public String getResult() {
        return mResult;
    }

    public void setResult(String result) {
        mResult = result;
    }

    public List<TeacherDetail> getTeacherDetails() {
        return mTeacherDetails;
    }

    public void setTeacherDetails(List<TeacherDetail> teacherDetails) {
        mTeacherDetails = teacherDetails;
    }

}
