package com.npg005.network;
import com.npg005.message.Message;
import com.npg005.user.User;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Network extends Thread{
    private Socket s;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    public void connectToServer() throws Exception {
        s = new Socket("localhost", 5000);
        //outputStream = new ObjectOutputStream(s.getOutputStream());
        //inputStream = new ObjectInputStream(s.getInputStream());
        //Message recMessage = (Message)inputStream.readObject();
        //System.out.println(recMessage.getMessage());
        //s.close();
    }

    public void sendMessage(User user) throws Exception{
        Scanner scanner = new Scanner(System.in);

        outputStream = new ObjectOutputStream(s.getOutputStream());
        // inputStream = new ObjectInputStream(s.getInputStream());

        Message message = new Message(scanner.nextLine(), LocalDateTime.now(), user);
        outputStream.writeObject(message);
        outputStream.flush();

    }
}
