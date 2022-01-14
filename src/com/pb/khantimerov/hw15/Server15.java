package com.pb.khantimerov.hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    ClientHandler15 client = new ClientHandler15(clientSocket, this, clName, clNr);
                    clients15.add(client);
                    new Thread(client).start();
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formattedDTime = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
                    // протокол подключений к серверу разными цетами (255 цветов, далее все клиенты белые)
                    System.out.println("\u001B[38;5;" + clNr + "m" + dateTime.format(formattedDTime) +
                            ". В чате новый участник - " + clName + "\u001B[0m");
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

/* Сообщения на серере

"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\lib\idea_rt.jar=50414:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\out\production\JavaHomeWork;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-annotations-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-core-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-databind-2.13.0.jar" com.pb.khantimerov.hw15.Server15
Сервер запущен!
13.01.2022, 22:28:34. В чате новый участник - № 1
13.01.2022, 22:28:44. В чате новый участник - № 2
13.01.2022, 22:29:10. В чате новый участник - № 3
13.01.2022, 22:29:54 :: № 3 : 'Hi from AWT 2!'
13.01.2022, 22:30:12 :: № 1 : 'Hola de AWT!'
13.01.2022, 22:30:35. В чате новый участник - № 4
13.01.2022, 22:31:13 :: № 4 : 'Hello from Console'
13.01.2022, 22:33:03 :: № 3 : 'I`m lad to see you :)'
13.01.2022, 22:33:25 :: № 1 : 'Soy contento :) '
13.01.2022, 22:34:35 :: № 1 : 'Feliz Nevidad i Ano Nuevo!'
13.01.2022, 22:35:04 :: № 4 : 'Ofigenniy chat :)))'
13.01.2022, 22:36:15 :: № 3 : 'exit chat'

 */
