<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CampusQuest</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional: Link to your CSS file -->
</head>
<body>

    <!-- Header -->
    <header>
        <h1>Welcome to CampusQuest</h1>
        <p>Your ultimate campus challenge awaits!</p>
    </header>

    <!-- Main Content -->
    <div class="main-content">
        <div class="login-box">
            <h2>Login</h2>
            <form action="login" method="POST">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br><br>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="passwd" required><br><br>
                
                <button type="submit">Login</button>
            </form>
            <p>Don't have an account? <a href="register.jsp">Register here</a></p>
        </div>

        <!-- Register Section -->
        <div class="register-box">
            <h2>New to CampusQuest?</h2>
            <p>Join us today and start completing exciting quests!</p>
            <a href="register.jsp"><button>Register Now</button></a>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 CampusQuest. All rights reserved.</p>
    </footer>

</body>
</html>
