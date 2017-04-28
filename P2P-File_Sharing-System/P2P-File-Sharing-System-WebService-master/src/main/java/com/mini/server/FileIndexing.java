package com.mini.server;

public class FileIndexing {

    private String fileName;
    private String ipAddress;
    private int portNumber;

    public FileIndexing(String fileName, String ipAddress, int portNumber) {
        this.fileName = fileName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }


}
