package com.pb.khantimerov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        try {
            System.out.println("Client 2 starting...");
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