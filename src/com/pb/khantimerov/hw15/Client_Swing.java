// не работает прокрутка в тестовом блоке :(
// возможно, проблема в myWindow.setLayout(null)

package com.pb.khantimerov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_Swing {
    public static String outMessage = "";
    public static Socket s;

    public static JTextArea jtextArea;

    public static void main(String[] args) {
        JTextField jTextField = new JTextField(15);
        jtextArea = new JTextArea();
        JButton jButton = new JButton("Send");
        JFrame myWindow = new JFrame("Chat Swing");
        JScrollPane jScrollPane= new JScrollPane(jtextArea);
//        jScrollPane.setPreferredSize(new Dimension(200, 200));
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JScrollBar vScroll = new JScrollBar();
        myWindow.setSize(400, 400);
//        jScrollPane.setVerticalScrollBar(vScroll);

        jtextArea.setBounds(20, 20, 360, 300);
        jTextField.setBounds(20, 330, 270, 30);
        jButton.setBounds(300, 330, 80, 30);
        jtextArea.setLineWrap(true);
        jScrollPane.setSize(5, 5);

        myWindow.setLayout(null);
        myWindow.add(jTextField);
        myWindow.add(jtextArea);
        myWindow.add(jScrollPane);
//        myWindow.add(vScroll);
        myWindow.add(jButton);

        myWindow.setVisible(true);



        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                PrintWriter out15;
                    outMessage = jTextField.getText();
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
                    jTextField.setText(null);
                }

        });



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
    }

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
                        jtextArea.append("\n" + inMessage);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException at Input");
            }
        }
    }
}
