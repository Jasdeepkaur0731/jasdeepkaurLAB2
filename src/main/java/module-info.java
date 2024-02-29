module com.example.jasdeepkaurlab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.jasdeepkaurlab2 to javafx.fxml;
    exports com.example.jasdeepkaurlab2;
}