package com.user.model;

public class Student extends User {

    private String fullName;
    private String department;
    private String course;
    private int year;
    private int points;

    public Student() {
        super();
    }

    public Student(String clgID, String fullName, String department, String course, int year, int points, String password, String profileImage) {
        super(clgID, "student", password, profileImage);
        this.fullName = fullName;
        this.department = department;
        this.course = course;
        this.year = year;
        this.points = points;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Student [clgID=" + getClgID() + ", fullName=" + fullName + ", department=" + department + ", course=" + course + ", year=" + year + ", points=" + points + "]";
    }
}
