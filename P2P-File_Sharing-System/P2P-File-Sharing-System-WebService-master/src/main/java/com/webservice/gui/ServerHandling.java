package com.webservice.gui;

import com.mini.server.ServerHandlerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by admin on 4/23/2017.
 */
public class ServerHandling extends JFrame {
    private JTextArea outputTextArea;
    private JButton startButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private ServerHandlerUtil serverHandlerUtil = new ServerHandlerUtil();
    public ServerHandling() {
        closeButton.setVisible(false);
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(serverHandlerUtil.openServer()){
                        outputTextArea.append("Server has started on :"+ InetAddress.getLocalHost().getHostAddress()+"\n");
                        startButton.setVisible(false);
                        closeButton.setVisible(true);
                    }
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (serverHandlerUtil.closeServer()){
                    outputTextArea.append("server is now closed\n");
                    closeButton.setVisible(false);
                    startButton.setVisible(true);
                }
            }
        });
        setVisible(true);
    }
}
