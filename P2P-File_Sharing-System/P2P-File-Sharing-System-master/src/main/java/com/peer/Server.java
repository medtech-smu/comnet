package com.peer;

import com.utils.ServerSetup;
import com.utils.WebServiceConnection;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


public class Server implements Runnable {
    @Override
    public void run() {
        try{
            WebServiceConnection webServiceConnection = new WebServiceConnection();
            ServerSetup serverSetup = new ServerSetup();
            webServiceConnection.init();
            webServiceConnection.setup();
            serverSetup.init();
            File file = new File("file");
            webServiceConnection.addFile(file.getName(), InetAddress.getLocalHost().getHostAddress(),1234);
            serverSetup.setup(file);
            System.out.println("file credentials were added to server");
            serverSetup.sendFile();
            System.out.println("this file: "+file.getName()+" was successfully sen");
            serverSetup.closeConnection();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}