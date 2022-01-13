// черновик, не хочет работать

package com.pb.khantimerov.hw15;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Chat_Javafx extends Application {
    public static TextArea textArea = new TextArea();
    public static String outMessage = "";
    public static volatile Socket ss;

//    @FXML
//    protected void settxtArea(String txt) {
//        textArea.appendText(txt);
//    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Paths.get("src/com/pb/khantimerov/hw15/fxml_chat_window.fxml").toUri().toURL());

        Scene scene = new Scene(root);

        stage.setTitle("Chat JAVAFX");
        stage.setScene(scene);
        stage.show();


        // подключение к серверу
        try {
            System.out.println("Client JAVAFX started...");
            ss = new Socket("127.0.0.1",7777);
            System.out.println(ss + "soc");
//            PrintWriter out = new PrintWriter(ss.getOutputStream());
            Thread threadIn = new Thread(new Chat_Javafx.SocketInputThread(ss));// данные от сервера
            threadIn.start();
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException in Main");
        } catch (IOException ex) {
            System.out.println("IOException in Main");
        }

//settxtArea("test");
    }

    public static class SocketInputThread implements Runnable {
        final private Socket s;
        Scanner in = null;
//        private final PrintWriter out = null;
        String inMessage;

        public SocketInputThread(Socket s) {
            this.s = s;
//            System.out.println(s + " s");
        }

        @Override
        public void run() {
            try {
                in = new Scanner(s.getInputStream());
                while(true){
                    if(in.hasNext()){
                        inMessage = in.nextLine();
                        System.out.println(inMessage + " inmess");
                        textArea.appendText("\n" + inMessage);
//                        textArea.setText(textArea.getText() + "\n" + inMessage);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException at Input");
            }
        }
    }
}
