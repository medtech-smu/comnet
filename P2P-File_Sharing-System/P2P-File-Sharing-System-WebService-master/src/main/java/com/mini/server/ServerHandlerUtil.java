package com.mini.server;

import javax.xml.ws.Endpoint;
import java.net.UnknownHostException;

/**
 * Created by admin on 4/23/2017.
 */
public class ServerHandlerUtil {
    Endpoint endpoint;
    public boolean openServer() throws UnknownHostException {
        endpoint=Endpoint.publish("http://192.168.61.107:8080/home", new CentralIndexingServer());
        return endpoint.isPublished();
    }
    public boolean closeServer(){
        endpoint.stop();
        return !endpoint.isPublished();
    }
}
