package com.npg005.server;

import com.npg005.message.Message;
import com.npg005.network.Network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(5000);

            Network network = new Network();
            Socket s = network.getSocket();
            while(true){
                network.setSocket(ss.accept());
                System.out.println("Client connected!");

                ServerMessaging serverMessaging = new ServerMessaging();
                serverMessaging.start();
            }
        }catch (Exception e){
            System.out.println("Server unable to start.");
        }
    }
}
