package com.user.model;

public class User {
    
    private String clgID;   // Unique college ID
    private String role;    // Role can be 'admin' or 'student'
    private String password; // User's password
    private String profileImage; // Optional profile image URL or path
    
    public User() {
        super();
    }

    public User(String clgID, String role, String password, String profileImage) {
        this.clgID = clgID;
        this.role = role;
        this.password = password;
        this.profileImage = profileImage;
    }

    // Getters and setters
    public String getClgID() {
        return clgID;
    }

    public void setClgID(String clgID) {
        this.clgID = clgID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "User [clgID=" + clgID + ", role=" + role + ", password=" + password + ", profileImage=" + profileImage + "]";
    }
}
