package com.utils;

import java.io.File;

/**
 * Created by admin on 4/23/2017.
 */
public class SharedFiles {
    File directory;
    public File[] sharedFiles(){
        directory= new File("C:\\Users\\admin\\Downloads\\p2p-downloader-master\\comp2pfilesharing\\comp2pfilesharing\\src\\main\\resources");
        File[] files=directory.listFiles();
        return files;
    }
}
