package com.npg005.server;

import com.npg005.client.Client;
import com.npg005.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ServerMessaging extends Thread{
    private static ObjectInputStream objectInputStream;

    public ServerMessaging(){
        try {
            objectInputStream = new ObjectInputStream(Client.getSocket().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            while (true){
                try {
                    Message receivedMessage = (Message)objectInputStream.readObject();
                    System.out.println(receivedMessage.getUsername() + ": " + receivedMessage.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("Could not read message. " + e);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not get object input stream. " + e);
        }
    }
}
