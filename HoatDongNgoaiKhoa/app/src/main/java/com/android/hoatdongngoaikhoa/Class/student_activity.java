package com.android.hoatdongngoaikhoa.Class;

import java.io.Serializable;

public class student_activity implements Serializable {
    private Long id;
    private String student_id;
    private String activity_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }
}
