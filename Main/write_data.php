//Place this file in "xampp\htdocs" directory
<?php

    // Prepare variables for database connection
    $dbname= "******"; // enter database name
    $dbusername = "************";  // enter database username
    $dbpassword = "***************";  // enter database password
    $localhost = "***********"; // IMPORTANT: if you are using XAMPP enter "localhost", but if you have an online website enter its address, ie."www.yourwebsite.com"

    // Connect to your database

    $dbconnect = mysqli_connect($localhost, $dbusername, $dbpassword, $dbname);
    $dbselect = mysqli_select_db($dbconnect,$dbname);

    // Prepare the SQL statement
    
    // Insert in *...* the corresponding name
    $sql = "INSERT INTO *dbname*.*tablename* (*attribute*) VALUES ('".$_GET[" *attribute* "]."')";

    // Execute SQL statement

    mysqli_query($dbconnect,$sql);

?>
