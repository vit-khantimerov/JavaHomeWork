package com.pb.khantimerov.hw15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ChatWindowController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

//    public void setSs(String ss) {
//        this.ss = ss;
//    }

//    public String getSs() {
//        return ss;
//    }

    @FXML
    protected String _handleSubmitButtonAction(ActionEvent event) {
//        textArea.setText("");

        textArea.setText(textArea.getText() + "\n" + textField.getText());
//        System.out.println(textField.getText());
        ss = textField.getText();
        System.out.println(ss + "from form");
        textField.clear();
        return ss;
    }

    public String ss;
}
