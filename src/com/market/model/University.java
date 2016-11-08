package com.market.model;

public class University {
    private Integer id;

    private String universityname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname == null ? null : universityname.trim();
    }
}