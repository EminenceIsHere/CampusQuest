package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.user.model.User;
import com.user.model.Admin;
import com.user.model.Student;

public class UserDAO {
    
    private String jdbcURL = "jdbc:mysql://localhost:30006/campusquestdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "151104";
    
    // SQL Queries for User (admin and student)
    private static final String INSERT_USER_SQL = "INSERT INTO users (clgID, role, password, profileImage) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE clgID=?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE clgID=?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET clgID=?, role=?, password=?, profileImage=? WHERE clgID=?;";
    
    // SQL Queries for Admin (additional fields)
    private static final String INSERT_ADMIN_SQL = "INSERT INTO admins (clgID, fullName, department, designation) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ADMIN_BY_ID = "SELECT * FROM admins WHERE clgID=?;";
    
    // SQL Queries for Student (additional fields)
    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (clgID, fullName, department, course, year, points) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE clgID=?;";

    public UserDAO() {
        super();
    }
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    // Insert user (admin or student)
    public void insertUser(User user) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getClgID());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getProfileImage());
            
            preparedStatement.executeUpdate();
            
            if (user instanceof Admin) {
                insertAdmin((Admin) user, connection);
            } else if (user instanceof Student) {
                insertStudent((Student) user, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Insert Admin-specific info
    private void insertAdmin(Admin admin, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL);
            preparedStatement.setString(1, admin.getClgID());
            preparedStatement.setString(2, admin.getFullName());
            preparedStatement.setString(3, admin.getDepartment());
            preparedStatement.setString(4, admin.getDesignation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Insert Student-specific info
    private void insertStudent(Student student, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
            preparedStatement.setString(1, student.getClgID());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getDepartment());
            preparedStatement.setString(4, student.getCourse());
            preparedStatement.setInt(5, student.getYear());
            preparedStatement.setInt(6, student.getPoints());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select user (admin or student) by ID
    public User selectUser(String clgID) {
        User user = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1, clgID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                if ("admin".equals(role)) {
                    user = selectAdmin(clgID, connection);
                } else if ("student".equals(role)) {
                    user = selectStudent(clgID, connection);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Select Admin-specific info
    private Admin selectAdmin(String clgID, Connection connection) {
        Admin admin = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);
            preparedStatement.setString(1, clgID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin();
                admin.setClgID(clgID);
                admin.setFullName(resultSet.getString("fullName"));
                admin.setDepartment(resultSet.getString("department"));
                admin.setDesignation(resultSet.getString("designation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    // Select Student-specific info
    private Student selectStudent(String clgID, Connection connection) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setString(1, clgID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setClgID(clgID);
                student.setFullName(resultSet.getString("fullName"));
                student.setDepartment(resultSet.getString("department"));
                student.setCourse(resultSet.getString("course"));
                student.setYear(resultSet.getInt("year"));
                student.setPoints(resultSet.getInt("points"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Select all users (admins and students)
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String clgID = resultSet.getString("clgID");
                String role = resultSet.getString("role");
                User user = ("admin".equals(role)) ? selectAdmin(clgID, connection) : selectStudent(clgID, connection);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Delete user by ID
    public boolean deleteUser(String clgID) {
        boolean status = false;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setString(1, clgID);
            status = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Update user info
    public boolean updateUser(User user) {
        boolean status = false;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getClgID());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getProfileImage());
            preparedStatement.setString(5, user.getClgID());
            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
