module br.ufrn.imd.circusmanager.control {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.ufrn.imd.circusmanager.Control to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
}