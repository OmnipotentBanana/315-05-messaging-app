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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerService serverService = new ServerService();
        serverService.start();
        System.out.println("1 THREAD");
        ServerMessaging serverMessaging = new ServerMessaging();
        serverMessaging.start();
        System.out.println("2 THREAD");
    }
}
