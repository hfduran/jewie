module com.example.jewie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.jewie to javafx.fxml;
    exports com.example.jewie;
}