module br.ufrn.imd.circusmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.ufrn.imd.circusmanager to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
}