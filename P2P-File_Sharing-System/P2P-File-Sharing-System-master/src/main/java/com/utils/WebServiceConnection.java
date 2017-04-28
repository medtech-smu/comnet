package com.utils;

import soa.jaxwslabs.notebookwebserviceexercice3.IndexingWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by admin on 4/23/2017.
 */
public class WebServiceConnection {
    URL url;
    QName qName;
    Service service;
    IndexingWebService indexingWebService;

    public void init(){
        url=null;
        qName=null;
        service=null;
        indexingWebService=null;
    }
    public void setup() throws MalformedURLException, UnknownHostException {
        URL url = new URL("http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/home?wsdl");
        QName qName= new QName("http://server.mini.com/","CentralIndexingServerService");
        Service service =Service.create(url,qName);
        indexingWebService =service.getPort(IndexingWebService.class);
    }
    public void fileLookUp(String fileName, ClientSetup clientSetup) throws IOException {
        clientSetup.setup(indexingWebService.lookUpIPAddress(fileName),indexingWebService.lookUpPortNumber(fileName));
    }
    public void addFile(String fileName, String ipAddress, int portNumber){
        indexingWebService.addFile(fileName,ipAddress,portNumber);
    }
}
