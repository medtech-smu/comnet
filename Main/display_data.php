//Place this file in "xampp\htdocs" directory
// id, data and time are the attributes of the database

//Structure of the page
<?php
    $url=$_SERVER['REQUEST_URI'];
    header("Refresh: 5; URL=$url");  // Refresh the webpage every 5 seconds

    ?>
    <html>
        <head>
            <title>Data</title>
        </head>
            <body>
                <h1>Data readings</h1>
            <table border="0" cellspacing="0" cellpadding="4">
            <tr>
                    <td>ID</td>
                    <td>detail</td>
                    <td>Time</td>
            </tr>
            
        <?php
            // Connect to database
            $dbname= "*****";
            $dbusername = "*****";  // enter database username
            $dbpassword = "*****";  // enter database password
            $localhost = "*****"; // localhost ip@

            $dbconnect = mysqli_connect($localhost, $dbusername, $dbpassword, $dbname);
            
            // Retrieve all records and display them   
               // Insert the table name in /tablename/
            $result = mysqli_query($dbconnect,'SELECT * FROM /tablename/ ORDER BY id DESC');
            
            // fetch every record in the db and display it
            
            while($row = mysqli_fetch_array($result))
            {      
                echo "<tr>";
                echo "<td>" . $row['id'] . "</td>";
                echo "<td>" . $row['detail'] . "</td>";
                echo "<td>" . $row['time'] . "</td>";
                echo "</tr>";
                
            }
                
            // Close the connection   
            mysqli_close($dbconnect);
        ?>
            </table>
      </body>

    </html>
