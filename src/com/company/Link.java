package com.company;

import java.util.Date;

public class Link {
    private long id;
    private long courseId;
    private long personId;
    private Date dateEnrolled;

    public Link() {
    }

    public Link(long courseId, long personId, long id) {
        this.courseId = courseId;
        this.personId = personId;
        this.id = id;
        this.dateEnrolled = new Date();
    }

    public Link(long id, long courseId, long personId, Date dateEnrolled) {
        this.id = id;
        this.courseId = courseId;
        this.personId = personId;
        this.dateEnrolled = dateEnrolled;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
