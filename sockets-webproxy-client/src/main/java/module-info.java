module com.groupsecond.socketswebproxy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;
    requires com.groupsecond.socketswebproxycommon;
    requires org.jetbrains.annotations;

    opens com.groupsecond.socketswebproxyclient to javafx.fxml;
    exports com.groupsecond.socketswebproxyclient;
}