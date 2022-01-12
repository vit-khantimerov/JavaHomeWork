package com.pb.khantimerov.hw15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChatWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Paths.get
                ("src/com/pb/khantimerov/hw15/fxml_chat_window.fxml").toUri().toURL());

        Scene scene = new Scene(root);

        stage.setTitle("Chat");
        stage.setScene(scene);
        stage.show();

        String st = null;
//        ChatWindowController sss =  new ChatWindowController();
//        String ssss = sss.getSs();

        try {
            System.out.println("Client 15 starting...");
            Socket s = new Socket("127.0.0.1",7777);
            Thread threadIn = new Thread(new Client15.SocketInputThread(s));// данные от сервера
            Thread threadOut = new Thread(new Client15.SocketOutputThread(s));// ввод с клавиатуры
            threadIn.start();
            threadOut.start();
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException in Main");
        } catch (IOException ex) {
            System.out.println("IOException in Main");
        }

        class SocketInputThread implements Runnable {
            private Socket s;
            private Scanner in = null;
            private PrintWriter out = null;
            private String inMessage;
            private String outMessage;

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
                            System.out.println(inMessage);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("IOException at Input");
                }
            }
        }
        class SocketOutputThread implements Runnable {
            private Socket s;
            private Scanner in;
            private PrintWriter out;
            private String inMessage;
            private String outMessage = null;

            public SocketOutputThread(Socket s) {
                this.s = s;
            }

            @Override
            public void run() {
                try {
                    out = new PrintWriter(s.getOutputStream());
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    while (true) {
                        outMessage = st;
                        outMessage = buffer.readLine();
//                        outMessage = sss.getSs();
                            System.out.println(outMessage + "from socket");
                            out.println(outMessage);
                            out.flush();

                        if (outMessage.equalsIgnoreCase("exit chat")) {
                            s.close();

                    }
                    }
                } catch (IOException ex) {
                    System.out.println("IOException output");
                }
            }
        }


    }
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

//    public void setSs(String ss) {
//        this.ss = ss;
//    }

//    public String getSs() {
//        return ss;
//    }

    @FXML
    protected String handleSubmitButtonAction_(ActionEvent event) {
//        String st;
//        textArea.setText("");

        textArea.setText(textArea.getText() + "\n" + textField.getText());
//        System.out.println(textField.getText());
//        st = textField.getText();
//        System.out.println(st + "from form");
//        textField.clear();
        return "st";
    }


}
