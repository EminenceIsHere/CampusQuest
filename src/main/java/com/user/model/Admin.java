package com.user.model;

public class Admin extends User {
    
    private String fullName;
    private String department;
    private String designation;

    public Admin() {
        super();
    }

    public Admin(String clgID, String fullName, String department, String designation, String password, String profileImage) {
        super(clgID, "admin", password, profileImage);
        this.fullName = fullName;
        this.department = department;
        this.designation = designation;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Admin [clgID=" + getClgID() + ", fullName=" + fullName + ", department=" + department + ", designation=" + designation + "]";
    }
}
