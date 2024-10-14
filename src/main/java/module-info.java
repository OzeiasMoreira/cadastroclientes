module com.cadastroclientes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;

    opens com.cadastroclientes to javafx.fxml;
    exports com.cadastroclientes;
}
