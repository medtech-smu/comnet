package com.mini.server;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 4/8/2017.
 */
@WebService(endpointInterface = "com.mini.server.IndexingWebService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CentralIndexingServer implements IndexingWebService {

    List<FileIndexing> files = new ArrayList<FileIndexing>();
    public CentralIndexingServer() throws UnknownHostException {
    }

    public String lookUpFileName(String fileName) {
        for (int i=0;i<files.size();i++){
            if (files.get(i).getFileName().equalsIgnoreCase(fileName)){
                return files.get(i).getFileName();
            }
        }
        return null;
    }

    public String lookUpIPAddress(String fileName) {
        for (int i=0;i<files.size();i++){
            if (files.get(i).getFileName().equalsIgnoreCase(fileName)){
                return files.get(i).getIpAddress();
            }
        }
        return null;
    }

    public int lookUpPortNumber(String fileName) {
        for (int i=0;i<files.size();i++){
            if (files.get(i).getFileName().equalsIgnoreCase(fileName)){
                return files.get(i).getPortNumber();
            }
        }
        return 0;
    }

    public void addFile(String fileName, String ipAddress, int portNumber) {
        FileIndexing newFile =new FileIndexing(fileName,ipAddress,portNumber);
        files.add(newFile);
    }
}
