package com.npg005.server;

public class ServerMain {
    public static void main(String[] args) {
        ServerConnect serverConnect = new ServerConnect();
        serverConnect.runServer();
        serverConnect.start();
        serverConnect.run();
    }
}
