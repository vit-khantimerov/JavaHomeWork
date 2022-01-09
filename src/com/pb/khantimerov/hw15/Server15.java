package com.pb.khantimerov.hw15;

//import com.pb.khantimerov.hw14.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Server15 {

        public static void main(String[] args) {
            Server15 server = new Server15();
        }
        // список клиентов
        private final ArrayList<ClientHandler15> clients15 = new ArrayList<>();
        int clNr;

        public Server15() {
            Socket clientSocket = null;
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(7777);
                System.out.println("Сервер запущен!");

                while (true) {
                    clientSocket = serverSocket.accept();
                    clNr++;
                    String clName = "№ " + clNr;
                    ClientHandler15 client = new ClientHandler15(clientSocket, this, clName);
                    clients15.add(client);
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
            for (ClientHandler15 o : clients15) {
                o.sendMsg(msg);
            }

        }

        // удаляем клиента при выходе из чата
        public void removeClient(ClientHandler15 client) {
            clients15.remove(client);
        }
}

/* Сообщения на сервере.


 */