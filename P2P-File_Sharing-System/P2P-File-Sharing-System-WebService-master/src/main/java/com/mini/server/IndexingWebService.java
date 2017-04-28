package com.mini.server;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by admin on 4/8/2017.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IndexingWebService {
    public String lookUpFileName(String fileName);
    public String lookUpIPAddress(String fileName);
    public int lookUpPortNumber(String fileName);
    public void addFile(String fileName,String ipAddress,int portNumber);
}
