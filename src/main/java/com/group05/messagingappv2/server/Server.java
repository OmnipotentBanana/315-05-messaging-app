package com.group05.messagingappv2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private ServerSocket serverSocket;

    public Server(){

    }

    public void startServer(){
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                System.out.println("A new client has connected");
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket(){
        try {
            if (serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
