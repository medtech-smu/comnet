package com.peer;

/**
 * Created by admin on 4/13/2017.
 */
public class Node {
    public static void main(String[] args) {

        (new Thread(new Server())).start();
        (new Thread(new Client())).start();
    }
}
