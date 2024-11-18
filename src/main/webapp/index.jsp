<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CampusQuest</title>
</head>
<body>
    <h1>Welcome to CampusQuest</h1>

    <!-- Login Form -->
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="passwd">Password: </label>
        <input type="password" id="passwd" name="passwd" required><br><br>
        
        <button type="submit">Login</button>
    </form>

    <!-- Register Form -->
    <h2>New User? Register Here</h2>
    <form action="register" method="post">
        <label for="uname">Username: </label>
        <input type="text" id="uname" name="uname" required><br><br>

        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="passwd">Password: </label>
        <input type="password" id="passwd" name="passwd" required><br><br>

        <label for="year">Year of Study: </label>
        <input type="number" id="year" name="year" required><br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
