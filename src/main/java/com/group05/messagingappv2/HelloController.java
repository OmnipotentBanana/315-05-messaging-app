package com.group05.messagingappv2;

import com.group05.messagingappv2.server.Client;
import com.group05.messagingappv2.server.ClientHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import org.w3c.dom.events.MouseEvent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class HelloController {

    private Socket socket;
    private Client client;
    public static String username;

    @FXML
    ListView<String> list1;
    @FXML
    ListView<String> usersList;
    ObservableList<String> items = FXCollections.observableArrayList();
    ObservableList<String> usersListItems = FXCollections.observableArrayList();
    @FXML
    TextField senderMessageBox;
    @FXML
    Text endUserName;
    @FXML
    Text endUserStatus;
    @FXML
    TextField searchBox;
    @FXML
    TextField txtUsername;

    @FXML
    Button sendButton;
    @FXML
    String sendUserMessage;
    String nextEndUsername;
    int i=0;
    @FXML
    AnchorPane myRightAnchor;
    @FXML
    void onHelloButtonClick(ActionEvent e) {
        list1.setItems(items);
        if(!( senderMessageBox.getText()==null)) { // in case user gave some text in the textbox
            sendUserMessage = senderMessageBox.getText(); // get user text
            //first add message to the listbox and then afterwards clear the textbox for the next message user wants to
            // type
            items.add(sendMessageProtocol(sendUserMessage, "Mpho", getDateAndTime()));
            list1.scrollTo(i);
            i++;
            senderMessageBox.clear();
            // we need now a function to switch the listbox scroll to the last element in the listbox
        }
    }
    @FXML
    void onGoButtonClicked(ActionEvent e){
        setUsers();
    }

    private void setUsers(){
        items.clear();
        myRightAnchor.setVisible(false);
        usersList.setItems(usersListItems);
        usersListItems.clear();// this is when a user searched for other users on the server

        //below is an example of when will happen if users are found on the server
        // they will be added to the listview
        getOnlineUsers(usersListItems); //we get a list of all available users, and then they all added to the listview for available users

        //after fetching available users, clear search box
        searchBox.clear();
    }

    @FXML
    void onSubmitButtonClicked(ActionEvent e){

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8001);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        client = new Client(socket, txtUsername.getText());
        getOnlineUsers(usersListItems);
        client.setUsername();
        client.listenForMessage();
        setUsers();
    }



    private String sendMessageProtocol(String message, String name, String DateTime){
        // should change to
        //public String sendMessageProtocol(String[] users, String message, String DateTime)
        return "("+DateTime + ") "+ name + ": "+ message;
    }
    private String getDateAndTime(){
        LocalDateTime myDate =  LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/20YY HH:mm");
        String newDate = myDate.format(myFormat);
        return newDate;
    }

    public void getOnlineUsers(ObservableList<String> availableUsers){
        //function to get available users from the server
        availableUsers.addAll(Client.userList);

    }

    public void onUserNameClick(javafx.scene.input.MouseEvent mouseEvent) {
        items.clear();
        myRightAnchor.setVisible(true);
        myRightAnchor.setDisable(false);
        sendButton.setDisable(true);
        senderMessageBox.setDisable(true);
        endUserName.setText(usersList.getSelectionModel().getSelectedItem());


        //here will be a function to check if the two users are connected
        items.add(sendMessageProtocol("Your connection is encrypted with end to end connection" ,"AppMessage",getDateAndTime()));
        endUserStatus.setText("Connected");
        sendButton.setDisable(false);
        senderMessageBox.setDisable(false);
    }
}
