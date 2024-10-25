module com.example.jewie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.desktop;

    opens com.example.jewie to javafx.fxml;
    exports com.example.jewie;
    exports com.example.jewie.frontend;
    opens com.example.jewie.frontend to javafx.fxml;
}