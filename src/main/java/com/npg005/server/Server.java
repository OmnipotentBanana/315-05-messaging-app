package com.npg005.server;

import com.npg005.message.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        new Server();
    }

    public Server() throws Exception{
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        System.out.println("Client connected!");

        ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());

        Message recMessage = (Message)inputStream.readObject();

        // String str = bf.readLine();
        System.out.println(recMessage.getTimeSent() + " " + recMessage.getUser().getUsername() + ": " + recMessage.getMessage());
    }
}
