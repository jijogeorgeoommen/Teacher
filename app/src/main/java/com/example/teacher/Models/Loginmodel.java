package com.example.teacher.Models;

public class Loginmodel {
    public String Status;
    public String RegNo;

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public Loginmodel(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
