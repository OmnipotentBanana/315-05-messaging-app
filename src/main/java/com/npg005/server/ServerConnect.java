package com.npg005.server;

import com.npg005.client.Client;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerConnect extends Thread{
    private static final int PORT_NUM = 10542;
    private static ServerSocket ss;

    public void runServer(){
        try {
            ss = new ServerSocket(PORT_NUM);
        }catch (IOException e){
            System.out.println("Server could not start. " + e);
        }
    }


    @Override
    public void run(){
        while (true){
            try {
                Client client = new Client();
                client.setSocket(ss.accept());
                System.out.println("Client successfully connected!");
                ServerMessaging serverMessaging = new ServerMessaging();
                serverMessaging.start();
            }catch (IOException e){
                System.out.println("Could not accept client connection. " + e);
            }
        }
    }
}
