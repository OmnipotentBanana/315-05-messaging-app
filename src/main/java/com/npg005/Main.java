package com.npg005;

import com.npg005.client.Client;
import com.npg005.message.Message;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        while (!client.connectToServer()){
            Thread.sleep(5000);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        Message message = new Message();
        message.setUsername(scanner.nextLine());
        while (true){
            message.setMessage(scanner.nextLine());
            message.setTimeSent(LocalDateTime.now());
            client.sendMessage(message);
        }
    }
}
