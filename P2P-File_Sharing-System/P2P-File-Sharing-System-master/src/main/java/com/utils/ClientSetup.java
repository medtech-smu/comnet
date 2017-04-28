package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by admin on 4/23/2017.
 */
public class ClientSetup {
    Socket socket;
    InputStream in;
    OutputStream out;

    public void init(){
        socket=null;
        in=null;
        out=null;
    }
    public void setup(String ipAddress,int portNumber) throws IOException {
        socket= new Socket(ipAddress,portNumber);
        in=socket.getInputStream();
        out=new FileOutputStream("ReceivedFile.txt");
    }
    public void getFile() throws IOException {
        byte[] byte_array = new byte[20480];
        int i=0;
        while ((i=in.read(byte_array))>0){
            out.write(byte_array,0,i);
        }
        System.out.println("file received");
    }
    public void closeConnection() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
