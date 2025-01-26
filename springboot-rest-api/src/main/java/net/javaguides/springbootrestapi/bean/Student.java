package net.javaguides.springbootrestapi.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    int id;
    String first_name;
    String last_name;
    public Student(int id,String fname,String lname)
    {
        this.id = id;
        this.first_name = fname;
        this.last_name = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
