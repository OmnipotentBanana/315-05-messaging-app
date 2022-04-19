package com.npg005.server;
import com.npg005.message.Message;
import com.npg005.network.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerMessaging extends Thread {
    @Override
    public void run(){
        Network network = new Network();
        while (true){
            try {
                ObjectInputStream inputStream = new ObjectInputStream(network.getSocket().getInputStream());// DEFINITELY here
                Message recMessage = (Message)inputStream.readObject();
                System.out.println(recMessage.getUser().getUsername() + ": " + recMessage.getMessage());
            }catch (Exception e){
                //System.out.println(e); // error here
            }
        }
    }
}
