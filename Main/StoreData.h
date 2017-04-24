//localhost ip@
char server[] = "**.**.**.**"; 
// Initialize the WiFi server library
WiFiClient client;

void saveData (String msg){
    if (client.connect(server, 80)) { // check if the connection is successful
        client.print("GET /write_data.php?"); // GET request
        client.print("detail="); // GET request
        client.print(msg); // Message stored in database after getting information from hardware 
        client.println(" HTTP/1.1"); // Part of the GET request
        client.println("Host: **.**.**.**"); // IP address of localhost
        client.println("Connection: close"); // Part of the GET request telling the server that we are over transmitting the message
        client.println(); // Empty line
        client.println(); // Empty line
        client.stop();    // Closing connection to server
  }
}
