package com.group05.messagingappv2;

import com.group05.messagingappv2.server.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MessagingInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Messaging Application");
        stage.setScene(scene);
        stage.show();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Username: ");
//        String username = scanner.nextLine();


        //Client client = new Client(socket, username);
        //client.listenForMessage();
        //client.sendMessage();

    }

    public static void main(String[] args) {
        launch();
    }
}