package com.npg005.server;

import com.npg005.message.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService extends Thread{
    public ServerService() {
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket s = ss.accept();
            System.out.println("Client connected!");

            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());

            while (true){
                ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());
                Message recMessage = (Message)inputStream.readObject();
                System.out.println(recMessage.getUser().getUsername() + ": " + recMessage.getMessage());
            }

        }catch (Exception e){
            System.out.println("Server unable to start.");
        }
    }
}
