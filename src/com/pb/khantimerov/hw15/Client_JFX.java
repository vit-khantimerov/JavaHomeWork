package com.pb.khantimerov.hw15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_JFX extends Application{
    public static String outMessage = "";
    public static Socket s;
    public static TextArea textArea;

    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        textArea = new TextArea();
//        textArea.setPrefColumnCount(10);
//        textArea.setPrefRowCount(10);
        TextField textField = new TextField();
        Button btn = new Button("Send");

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, textArea, textField, btn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 300);

        stage.setScene(scene);
        stage.setTitle("Chat JavaFX");
        stage.show();
        textArea.setStyle("-fx-text-fill: green ;") ;


        btn.setOnAction(event -> {
            PrintWriter out15;
            outMessage = textField.getText();
            try {
                out15 = new PrintWriter(s.getOutputStream());
                out15.println(outMessage);
                out15.flush();
                if (outMessage.equalsIgnoreCase("exit chat")) {
                    s.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException output");
            }
            textField.clear();
        });



        // подключение к серверу
        try {
            System.out.println("Client JFX starting...");
            s = new Socket("127.0.0.1",7777);
            Thread threadIn = new Thread(new Client_JFX.SocketInputThread(s));// данные от сервера
            threadIn.start();
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException in Main");
        } catch (IOException ex) {
            System.out.println("IOException in Main");
        }
    }

    public static class SocketInputThread implements Runnable {
        final private Socket s;
        Scanner in = null;
        String inMessage;

        public SocketInputThread(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                in = new Scanner(s.getInputStream());
                while(true){
                    if(in.hasNext()){
                        inMessage = in.nextLine();
                        textArea.appendText("\n" + inMessage);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException at Input");
            }
        }
    }
}
