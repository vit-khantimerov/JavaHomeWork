package com.pb.khantimerov.hw15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_AWT {

    public static TextArea textArea = new TextArea();
    public static String outMessage = "";
    public static Socket s;

    public static void main(String[] args) throws InterruptedException {

        //создание графической формы
        Frame frame = new Frame();
        Button button = new Button("Отправить");
        TextField textField = new TextField();
        textArea.setBounds(20,50,360,300);
        textField.setBounds(20, 350, 250, 30);
        button.setBounds(300, 350, 80, 30);

        frame.add(textArea);
        frame.add(button);
        frame.add(textField);

        frame.setSize(400,400);
        frame.setTitle("Чат AWT");
        textArea.setForeground(Color.blue);

        frame.setLayout(null);

        // для работы кнопки закрытие окна "крестик"
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.setVisible(true);


        // подключение к серверу
        try {
            System.out.println("Client 15 starting...");
            s = new Socket("127.0.0.1",7777);
            PrintWriter out15 = new PrintWriter(s.getOutputStream());
            Thread threadIn = new Thread(new SocketInputThread(s));// данные от сервера
            threadIn.start();
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException in Main");
        } catch (IOException ex) {
            System.out.println("IOException in Main");
        }

        // обработка нажатия кнопки
        button.addActionListener(new ActionListener() {
            private PrintWriter out15;
            @Override
            public void actionPerformed(ActionEvent event) {
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
                textField.setText(null);
            }
        }
        );
    }
    // END MAIN

    public static class SocketInputThread implements Runnable {
        private Socket s;
        private Scanner in = null;
        private PrintWriter out = null;
        private String inMessage;

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
                        textArea.append("\n" + inMessage);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException at Input");
            }
        }
    }
}