package com.pb.khantimerov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Client 1 starting...");
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

/* Сообщения у клиента 1.  Пришел и ушел первым, поэтому не видел выход остальных.

Client 1 starting...
2022-01-08T23:43:31.067.
В чате новый клиент участник - № 1
2022-01-08T23:43:40.706.
В чате новый клиент участник - № 2
2022-01-08T23:43:52.430.
В чате новый клиент участник - № 3
2022-01-08T23:43:59.523.
В чате новый клиент участник - № 4
Я № 1
2022-01-08T23:44:19.599
№ 1 : Я № 1
2022-01-08T23:44:31.589
№ 2 : Я № 2
2022-01-08T23:44:39.858
№ 3 : № 10
2022-01-08T23:44:50.859
№ 4 : № 11 с Вами
Всем привет!
2022-01-08T23:45:40.157
№ 1 : Всем риет!
2022-01-08T23:45:59.859
№ 2 : Как дела?
2022-01-08T23:46:06.959
№ 3 : Отлично!
2022-01-08T23:46:19.761
№ 4 : Чат - огонь :)
Пока :(
2022-01-08T23:46:52.726
№ 1 : Пока :(
2022-01-08T23:47:04.975
№ 4 : До встречи, Первый.
2022-01-08T23:47:25.071
№ 3 : Мне будет вас нехватать :(
2022-01-08T23:47:48.024
№ 2 : Еще увидимся на 15 ДЗ :)
exit chat

 */