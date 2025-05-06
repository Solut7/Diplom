package com.example.demo;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.paint.Color;

public class ValidationUtil {
    public static boolean isFieldEmpty(Control field, Label errorLabel, String errorMessage) {
        boolean isEmpty = false;

        if (field instanceof TextInputControl) {
            isEmpty = ((TextInputControl) field).getText().trim().isEmpty();
        } else if (field instanceof ComboBox) {
            isEmpty = ((ComboBox<?>) field).getValue() == null;
        }

        if (isEmpty && errorLabel != null) {
            errorLabel.setText(errorMessage);
            errorLabel.setTextFill(Color.RED);
            field.setStyle("-fx-background-color: red");
        } else if (errorLabel != null) {
            errorLabel.setText("");
            field.setStyle("");
        }

        return isEmpty;
    }
}
