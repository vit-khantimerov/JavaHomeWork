package com.pb.khantimerov.hw15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client15 {
    static volatile String mensaje = "";
    static volatile java.awt.TextArea textArea = new java.awt.TextArea();

    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        java.awt.TextArea textArea = new java.awt.TextArea();
//        Label label = new Label("Employee id:");
        Button button = new Button("Submit");
        java.awt.TextField textField = new java.awt.TextField();

        textArea.setBounds(20,50,460,300);
//        label.setBounds(20, 170, 80, 30);
        textField.setBounds(20, 400, 350, 30);
        button.setBounds(400, 400, 80, 30);

        frame.add(textArea);
        frame.add(button);
//        frame.add(label);
        frame.add(textField);

        frame.setSize(500,500);
        frame.setTitle("Chat...");

        // нужно убрать менеджер компоновки который установлен по умолчанию
        // иначе будет использован BorderLayout и компоненты будут расположены не так как задумано
        frame.setLayout(null);

        // для работы кнопки закрытие окна "крестик"
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // обработка нажатия кнопки
        button.addActionListener(event -> {
            System.out.println("Button pressed, id: " + textField.getText());
            mensaje = mensaje + "\n" + textField.getText();
            textArea.setText(mensaje);
            }
        );

        frame.setVisible(true);


        // подключение к серверу
        try {
            System.out.println("Client 15 starting...");
            Socket s = new Socket("127.0.0.1",7777);
            Thread threadIn = new Thread(new SocketInputThread(s));// данные от сервера
            Thread threadOut = new Thread(new SocketOutputThread(s));// ввод с клавиатуры
            threadIn.start();
            threadOut.start();
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException in Main");
        } catch (IOException ex) {
            System.out.println("IOException in Main");
        }

        while (true) {
            textArea.setText(mensaje);
            Thread.sleep(10);
        }
    }

    public static class SocketInputThread implements Runnable {
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
                        mensaje = mensaje + "\n" + inMessage;
                        textArea.setText(mensaje);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException at Input");
            }
        }
    }
    public static class SocketOutputThread implements Runnable {
        private Socket s;
        private Scanner in;
        private PrintWriter out;
        private String inMessage;
        private String outMessage;

        public SocketOutputThread(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(s.getOutputStream());
                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    outMessage = buffer.readLine();
                    out.println(outMessage);
//                    mensaje = outMessage;
//                    textArea.setText(mensaje + "\n" + outMessage);
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

/* Сообщения у клиента 15.  Пришел и ушел первым, поэтому не видел выход остальных.


 */