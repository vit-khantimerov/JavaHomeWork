package com.pb.khantimerov.hw14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Server {

        public static void main(String[] args) {
            Server server = new Server();
        }
        // список клиентов
        private final ArrayList<ClientHandler> clients = new ArrayList<>();
        int clNr;

        public Server() {
            Socket clientSocket = null;
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(7777);
                System.out.println("Сервер запущен!");

                while (true) {
                    clientSocket = serverSocket.accept();
                    clNr++;
                    String clName = "№ " + clNr;
                    ClientHandler client = new ClientHandler(clientSocket, this, clName);
                    clients.add(client);
                    new Thread(client).start();
                    System.out.println(LocalDateTime.now() + ". В чате новый клиент участник - " + clName);
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    clientSocket.close();
                    System.out.println("Сервер остановлен.");
                    serverSocket.close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public void sendMessageToAllClients(String msg) {
            for (ClientHandler o : clients) {
                o.sendMsg(msg);
            }

        }

        // удаляем клиента при выходе из чата
        public void removeClient(ClientHandler client) {
            clients.remove(client);
        }
}

/* Сообщения на сервере.

Сервер запущен!
2022-01-08T23:43:31.067. В чате новый клиент участник - № 1
2022-01-08T23:43:40.706. В чате новый клиент участник - № 2
2022-01-08T23:43:52.429. В чате новый клиент участник - № 3
2022-01-08T23:43:59.522. В чате новый клиент участник - № 4
2022-01-08T23:44:19.453 :: № 1 : 'Я № 1'
2022-01-08T23:44:31.588 :: № 2 : 'Я № 2'
2022-01-08T23:44:39.858 :: № 3 : '№ 10'
2022-01-08T23:44:50.858 :: № 4 : '№ 11 с Вами'
2022-01-08T23:45:40.157 :: № 1 : 'Всем привет!'
2022-01-08T23:45:59.859 :: № 2 : 'Как дела?'
2022-01-08T23:46:06.959 :: № 3 : 'Отлично!'
2022-01-08T23:46:19.761 :: № 4 : 'Чат - огонь :)'
2022-01-08T23:46:52.726 :: № 1 : 'Пока :('
2022-01-08T23:47:04.974 :: № 4 : 'До встречи, Первый.'
2022-01-08T23:47:25.070 :: № 3 : 'Мне будет вас нехватать :('
2022-01-08T23:47:48.024 :: № 2 : 'Еще увидимся на 15 ДЗ :)'
2022-01-08T23:48:06.795 :: № 1 : 'exit chat'

2022-01-08T23:48:12.873 :: № 2 : 'exit chat'

2022-01-08T23:48:15.782 :: № 3 : 'exit chat'

2022-01-08T23:48:20.193 :: № 4 : 'exit chat'

 */