package com.group05.messagingappv2.server;

import com.group05.messagingappv2.HelloController;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public static String username;
    public static ArrayList<String> userList = new ArrayList<>();



    public Client(Socket socket, String username){
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Client.username = username;

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    public void setUsername(){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(TextField txtMessage){
        try {

            if (socket.isConnected()){
                String messageToSend = txtMessage.getText();
                bufferedWriter.write(username + ": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }


    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromServer;

                while (socket.isConnected()){
                    try {
                        messageFromServer = bufferedReader.readLine();
                        if (messageFromServer.contains("Server: ") && messageFromServer.contains("has entered the chat.")){
                            System.out.println(messageFromServer);
                            if (socket.isConnected()){
                                bufferedWriter.write(username + ": Server.requestUserList().##232##");
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                            }
                            String users = bufferedReader.readLine();
                            String[] userArray;
                            userArray = users.replace("[", "").replace("]", "").replace(",", "").split(" ");
                            userList = new ArrayList<>();
                            userList.addAll(Arrays.asList(userArray));
                            System.out.println(userList);
                        }else{
                            System.out.println("ERROR " +  messageFromServer);
                        }


                        //helloController.
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }

                }
            }
        }).start();
    }



    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Client client = new Client(socket, username, availableUsers);
//        client.listenForMessage();
//        client.sendMessage();
    }

}
