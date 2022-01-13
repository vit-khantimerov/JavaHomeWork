package com.pb.khantimerov.hw15;

//import com.pb.khantimerov.hw14.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ClientHandler15 implements Runnable {
    private String name; // № участника чата
    private Server15 server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private int clnN;

    public ClientHandler15(Socket socket, Server15 server, String name, int clnN) {
        try {
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            this.name = name;
            this.clnN = clnN;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        LocalDateTime dateTime2;// = LocalDateTime.now();
        DateTimeFormatter formattedDTime = DateTimeFormatter.ofPattern("dd.mm.yyyy, HH:mm:ss");
//                    System.out.println(dateTime.format(formattedDTime));
//                    System.out.println(LocalDateTime.now() + ". В чате новый участник - " + clName);
        // Каждому клиенту со цвет на сервере (макс. 7 цветов в ДЗ)
//        System.out.println("\u001B[3" + clNr + "m" + dateTime2.format(formattedDTime) +
//                ". В чате новый участник - " + clName + "\u001B[0m");

        try {
            while (true) {
                server.sendMessageToAllClients(LocalDateTime.now() + "\nВ чате новый участник - " + name);
                break;
            }

            while (true) {
                if (inMessage.hasNext()) {
                    dateTime2 = LocalDateTime.now();
                    String clientMessage = inMessage.nextLine();
                    System.out.println(new StringBuilder() // протокол сообщений на сервере разными цетами
                            .append("\u001B[3" + clnN + "m")
                            .append(dateTime2.format(formattedDTime))
                            .append(" :: ")
                            .append(name)
                            .append(" : \'")
                            .append(clientMessage)
                            .append("\'")
                            .append("\u001B[0m").toString());
                    server.sendMessageToAllClients(new StringBuilder()
                            .append(dateTime2.format(formattedDTime))
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
