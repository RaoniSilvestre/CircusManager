module br.ufrn.imd.circusmanager.Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.ufrn.imd.circusmanager.Controller to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
}