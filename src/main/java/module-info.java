module com.example.jewie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.desktop;

    opens com.example.jewie to javafx.fxml;
    exports com.example.jewie;
    exports com.example.jewie.frontend;
    opens com.example.jewie.frontend to javafx.fxml;
    exports com.example.jewie.frontend.exceptions;
    opens com.example.jewie.frontend.exceptions to javafx.fxml;
    exports com.example.jewie.frontend.core;
    opens com.example.jewie.frontend.core to javafx.fxml;
    exports com.example.jewie.frontend.views;
    opens com.example.jewie.frontend.views to javafx.fxml;
    exports com.example.jewie.frontend.views.pieces;
    opens com.example.jewie.frontend.views.pieces to javafx.fxml;
}