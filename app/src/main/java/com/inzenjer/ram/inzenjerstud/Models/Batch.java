package com.inzenjer.ram.inzenjerstud.Models;

/**
 * Created by ram on 07-02-2018.
 */

public class Batch  {
    String batch_name,batch_no,batch_id,college_name,project_name;

    public Batch(String batch_name, String batch_no, String batch_id, String college_name, String project_name) {
        this.batch_name = batch_name;
        this.batch_no = batch_no;
        this.batch_id = batch_id;
        this.college_name = college_name;
        this.project_name = project_name;
    }

    public Batch() {

    }

    public String getBatch_name() {

        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
