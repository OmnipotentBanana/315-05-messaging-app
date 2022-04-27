package com.npg005.client;

import com.npg005.message.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private static Socket s;
    ObjectOutputStream objectOutputStream;
    public Boolean connectToServer(){
        try {
            s = new Socket("localhost", 10542);
            objectOutputStream = new ObjectOutputStream(s.getOutputStream());
            System.out.println("Connected to server!");
            return true;
        }catch (IOException e){
            System.out.println("Could not connect to server. Retrying... " + e);
            return false;
        }
    }

    public void sendMessage(Message message){
        try {
            objectOutputStream.reset();
            objectOutputStream.writeObject(message);
        }catch (IOException e){
            System.out.println("Could not create object output stream. " + e);
        }
    }

    public static Socket getSocket(){
        return s;
    }

    public void setSocket(Socket s) {
        Client.s = s;
    }
}
