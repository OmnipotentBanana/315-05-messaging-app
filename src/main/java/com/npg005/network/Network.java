package com.npg005.network;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Network {
    public void connectToServer() throws IOException {
        Socket s = new Socket("localhost", 5000);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Hello");
        pr.flush();
    }

}
