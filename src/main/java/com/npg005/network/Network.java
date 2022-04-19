package com.npg005.network;
import com.npg005.message.Message;
import com.npg005.user.User;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Network extends Thread{
    private static Socket s;
    //private ObjectInputStream inputStream;
    public void connectToServer() throws Exception {
        s = new Socket("localhost", 5000);
        //inputStream = new ObjectInputStream(s.getInputStream());
    }

    public void sendMessage(User user) throws Exception{
        Scanner scanner = new Scanner(System.in);
        // inputStream = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
        Message message = new Message(scanner.nextLine(), LocalDateTime.now(), user);
        outputStream.writeObject(message);
        //outputStream.flush();
    }

    public void setSocket(Socket s){
        Network.s = s;
    }

    public Socket getSocket(){
        return s;
    }
}
