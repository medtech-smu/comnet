    <?php
    $url=$_SERVER['REQUEST_URI'];
    header("Refresh: 5; URL=$url");  // Refresh the webpage every 5 seconds

    ?>
    <html>
        <head>
            <title>Doorbell Data</title>
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
            $dbname= "doorbell";
            $dbusername = "arduino";  // enter database username, I used "arduino" in step 2.2
            $dbpassword = "arduinotest";  // enter database password, I used "arduinotest" in step 2.2
            $localhost = "192.168.43.66"; // IMPORTANT: if you are using XAMPP enter "localhost", but if you have an online website enter its address, ie."www.yourwebsite.com"
            // IMPORTANT: If you are using XAMPP you will have to enter your computer IP address here, if you are using webpage enter webpage address (ie. "www.yourwebpage.com")

            $dbconnect = mysqli_connect($localhost, $dbusername, $dbpassword, $dbname);
            
            // Retrieve all records and display them   
            $result = mysqli_query($dbconnect,'SELECT * FROM data ORDER BY id DESC');
            
            // Process every record
            
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