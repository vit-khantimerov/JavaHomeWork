package com.pb.khantimerov.hw15;

//import com.pb.khantimerov.hw14.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ClientHandler15 implements Runnable {
    private String name; // № участника чата
    private Server15 server;
    private PrintWriter outMessage;
    private Scanner inMessage;

    public ClientHandler15(Socket socket, Server15 server, String name) {
        try {
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            this.name = name;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.sendMessageToAllClients(LocalDateTime.now() + ".\nВ чате новый клиент участник - " + name);
                break;
            }

            while (true) {
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
                    System.out.println(new StringBuilder().append(LocalDateTime.now())
                            .append(" :: ")
                            .append(name)
                            .append(" : \'")
                            .append(clientMessage)
                            .append("\'").toString());
                    server.sendMessageToAllClients(new StringBuilder().append(LocalDateTime.now())
                            .append("\n")
                            .append(name)
                            .append(" : ")
                            .append(clientMessage).toString());

                    if (clientMessage.equalsIgnoreCase("exit chat")) {
                        System.out.println();
                        server.sendMessageToAllClients(new StringBuilder()
                                .append(LocalDateTime.now())
                                .append("\n")
                                .append(name)
                                .append(" вышел из чата.").toString());
                        this.closeCln();
                        break;
                    }
                }
                Thread.sleep(10);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            this.closeCln();
        }
    }

    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //выход клиента из чата
    public void closeCln() {
        server.removeClient(this);
    }
}
