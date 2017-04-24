//localhost ip@
char server[] = "192.168.43.66"; 
// Initialize the WiFi server library
WiFiClient client;

void saveData (String msg){
    if (client.connect(server, 80)) {
        client.print("GET /write_data.php?"); // This
        client.print("detail="); // This
        client.print(msg); // And this is what we did in the testing section above. We are making a GET request just like we would from our browser but now with live data from the sensor
        client.println(" HTTP/1.1"); // Part of the GET request
        client.println("Host: 192.168.43.66"); // IMPORTANT: If you are using XAMPP you will have to find out the IP address of your computer and put it here (it is explained in previous article). If you have a web page, enter its address (ie.Host: "www.yourwebpage.com")
        client.println("Connection: close"); // Part of the GET request telling the server that we are over transmitting the message
        client.println(); // Empty line
        client.println(); // Empty line
        client.stop();    // Closing connection to server
  }
}
