package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogController {
    @FXML
    private Button EnterButt;
    @FXML
    private TextField NameF;
    @FXML
    private PasswordField PassF;
    @FXML
    private Label ErrorTxt;

    public void Try_enter(){
        AdminLog adminLog = new AdminLog();
        adminLog.setName(NameF.getText());
        adminLog.setPassword(PassF.getText());
        AdminLog[] adminRoles = new AdminLog[2];
        adminRoles[0] = new AdminLog("admin","12345");
        adminRoles[1] = new AdminLog("admin2","54321");
        boolean some = adminLog.Check(adminLog,adminRoles);
        if(!some){ErrorTxt.setText("Неверные данные");}
        else{
            ErrorTxt.setText("");
            try {
                HelloApplication.Create();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}