-- Database Schema for CampusQuest

-- Create the `users` table
CREATE TABLE users (
    college_id VARCHAR(20) PRIMARY KEY,
    role ENUM('student', 'admin') NOT NULL
);

-- Create the `admins` table
CREATE TABLE admins (
    college_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    profile_image VARCHAR(255),
    FOREIGN KEY (college_id) REFERENCES users(college_id)
);

-- Create the `students` table
CREATE TABLE students (
    college_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    year INT NOT NULL,
    total_points INT DEFAULT 0,
    department VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL,
    profile_image VARCHAR(255),
    FOREIGN KEY (college_id) REFERENCES users(college_id)
);

-- Create the `quests` table
CREATE TABLE quests (
    quest_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (created_by) REFERENCES admins(college_id)
);

-- Create the `quest_completions` table
CREATE TABLE quest_completions (
    completion_id INT PRIMARY KEY AUTO_INCREMENT,
    student_college_id VARCHAR(20) NOT NULL,
    quest_id INT NOT NULL,
    completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    verified_by VARCHAR(20),
    status ENUM('pending', 'verified', 'rejected') DEFAULT 'pending',
    FOREIGN KEY (student_college_id) REFERENCES students(college_id),
    FOREIGN KEY (quest_id) REFERENCES quests(quest_id),
    FOREIGN KEY (verified_by) REFERENCES admins(college_id),
    CONSTRAINT fk_quest FOREIGN KEY (quest_id) REFERENCES quests(quest_id) ON DELETE CASCADE
);

-- Create the `leaderboard` table
CREATE TABLE leaderboard (
    rank_id INT PRIMARY KEY AUTO_INCREMENT,
    college_id VARCHAR(20) NOT NULL,
    rank INT NOT NULL,
    total_points INT NOT NULL,
    year INT NOT NULL,
    FOREIGN KEY (college_id) REFERENCES students(college_id)
);

-- Sample queries to ensure cascading behavior (optional)
-- DELETE FROM quests WHERE quest_id = 1; -- Will delete corresponding completions as well
