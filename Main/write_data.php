<?php

    // Prepare variables for database connection
    $dbname= "doorbell";
    $dbusername = "arduino";  // enter database username, I used "arduino" in step 2.2
    $dbpassword = "arduinotest";  // enter database password, I used "arduinotest" in step 2.2
    $localhost = "192.168.43.66"; // IMPORTANT: if you are using XAMPP enter "localhost", but if you have an online website enter its address, ie."www.yourwebsite.com"

    // Connect to your database

    $dbconnect = mysqli_connect($localhost, $dbusername, $dbpassword, $dbname);
    $dbselect = mysqli_select_db($dbconnect,"doorbell");

    // Prepare the SQL statement

    $sql = "INSERT INTO doorbell.data (detail) VALUES ('".$_GET["detail"]."')";    

    // Execute SQL statement

    mysqli_query($dbconnect,$sql);

?>