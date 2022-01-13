// черновик, не хочет работать

package com.pb.khantimerov.hw15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatWindowController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    public static String outMessage = "";
    Socket c = Chat_Javafx.ss;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        textArea.appendText("\n" + textField.getText());
        outMessage = textField.getText();
//        System.out.println(outMessage + " outmassage");
//        System.out.println(c + "socket");
        textField.clear();
//        this.c = c;

        PrintWriter outJFX;
            outMessage = textField.getText();
            textField.clear();
            try {
                outJFX = new PrintWriter(c.getOutputStream());
                outJFX.println(outMessage);
                outJFX.flush();
                if (outMessage.equalsIgnoreCase("exit chat")) {
                    c.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException output");
            }
            textField.setText(null);
        }
    }
