module com.example.servlet {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.groovy;


    opens com.example.servlet to javafx.fxml;
    exports com.example.servlet;
}