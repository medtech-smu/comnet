package com.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 4/23/2017.
 */
public class ServerSetup {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private final static int portNumber = 1234;
    public void init(){
        serverSocket = null;
        socket = null;
        in = null;
        out = null;
    }
    public void setup(File file) throws IOException {
        serverSocket=new ServerSocket(portNumber);
        socket= serverSocket.accept();
        in=new FileInputStream(file);
        out = socket.getOutputStream();
    }
    public void sendFile() throws IOException {
        byte[] byte_array = new byte[20480];
        int i;
        while((i=in.read(byte_array))>0){
            out.write(byte_array,0,i);
        }
    }
    public void closeConnection() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
    public String getIpAddress(){
        return socket.getInetAddress().getHostAddress();
    }
    public int getPortNumber(){
        return socket.getLocalPort();
    }
}
