package com.example.pratikassignment1;

public class Admission {
    private int sub_id;
    private String sub_title;
    private String sub_instructor;
    private String sub_grade;

    public Admission(int sub_id, String sub_title, String sub_instructor, String sub_grade) {
        this.sub_title = sub_title;
        this.sub_id = sub_id;
        this.sub_instructor = sub_instructor;
        this.sub_grade = sub_grade;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getSub_instructor() {
        return sub_instructor;
    }

    public void setSub_instructor(String sub_instructor) {
        this.sub_instructor = sub_instructor;
    }

    public String getSub_grade() {
        return sub_grade;
    }

    public void setSub_grade(String sub_grade) {
        this.sub_grade = sub_grade;
    }
}
