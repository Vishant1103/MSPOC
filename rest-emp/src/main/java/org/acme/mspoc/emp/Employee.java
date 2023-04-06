package org.acme.mspoc.emp;

import javax.json.bind.annotation.JsonbProperty;

public class Employee {
    @JsonbProperty("name")
    private String name;
    @JsonbProperty("title")
    private String title;
    @JsonbProperty("yoj")
    private int yoj;

    @JsonbProperty("tid")
    private String tid;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYoj() {
        return yoj;
    }

    public void setYoj(int yoj) {
        this.yoj = yoj;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
