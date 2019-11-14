package com.company;

public class Course {
    private long id;
    private String name;
    private String description;
    private long fid;

    public Course(long id, String name, String description, long fid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fid = fid;
    }

    public Course(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return ("Class ID: " + id + "\n" +
                "Class Name: " + name + "\n" +
                "Class Description: " + description +"\n");
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
