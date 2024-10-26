package com.example.jewie.frontend.utils.formatters;

import javafx.scene.control.TextFormatter;

public class DoubleTextFormatter {
    public static TextFormatter<Double> getFormatter() {
        return new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty() || newText.matches("-?\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        });
    }
}
