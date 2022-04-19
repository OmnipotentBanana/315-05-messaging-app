package com.npg005;

import com.npg005.network.Network;
import com.npg005.user.User;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Network net = new Network();
        try {
            System.out.println("Please enter a username:");
            Scanner sc = new Scanner(System.in);
            User user = new User(sc.next());

            try {
                net.start();
                net.connectToServer();
            }catch (Exception e){
                System.out.println("Could not establish connection");
            }

            while (true){
                net.sendMessage(user);
            }
        }catch (Exception e){
            System.out.println("Server Error. " + e.toString());
        }
    }
}
