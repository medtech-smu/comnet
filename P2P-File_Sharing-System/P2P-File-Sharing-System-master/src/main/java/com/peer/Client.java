package com.peer;
import com.utils.ClientSetup;
import com.utils.WebServiceConnection;

import java.io.IOException;

public  class Client implements Runnable {
    @Override
    public void run() {
        try {
            WebServiceConnection webServiceConnection = new WebServiceConnection();
            ClientSetup clientSetup = new ClientSetup();
            webServiceConnection.init();
            webServiceConnection.setup();
            clientSetup.init();
            webServiceConnection.fileLookUp("file",clientSetup);
            clientSetup.getFile();
            clientSetup.closeConnection();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}