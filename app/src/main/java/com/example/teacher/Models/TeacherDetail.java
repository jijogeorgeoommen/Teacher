
package com.example.teacher.Models;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TeacherDetail {

    @SerializedName("TeacherBranch")
    private String mTeacherBranch;
    @SerializedName("TeacherDesigination")
    private String mTeacherDesigination;
    @SerializedName("TeacherEmail")
    private String mTeacherEmail;
    @SerializedName("TeacherName")
    private String mTeacherName;
    @SerializedName("TeacherPhoneNumber")
    private String mTeacherPhoneNumber;
    @SerializedName("TeacherRegNo")
    private String mTeacherRegNo;

    public String getTeacherBranch() {
        return mTeacherBranch;
    }

    public void setTeacherBranch(String teacherBranch) {
        mTeacherBranch = teacherBranch;
    }

    public String getTeacherDesigination() {
        return mTeacherDesigination;
    }

    public void setTeacherDesigination(String teacherDesigination) {
        mTeacherDesigination = teacherDesigination;
    }

    public String getTeacherEmail() {
        return mTeacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        mTeacherEmail = teacherEmail;
    }

    public String getTeacherName() {
        return mTeacherName;
    }

    public void setTeacherName(String teacherName) {
        mTeacherName = teacherName;
    }

    public String getTeacherPhoneNumber() {
        return mTeacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        mTeacherPhoneNumber = teacherPhoneNumber;
    }

    public String getTeacherRegNo() {
        return mTeacherRegNo;
    }

    public void setTeacherRegNo(String teacherRegNo) {
        mTeacherRegNo = teacherRegNo;
    }

}
