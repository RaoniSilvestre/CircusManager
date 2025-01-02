module br.ufrn.imd.circusmanager.control {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.ufrn.imd.circusmanager.Controller to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
    opens br.ufrn.imd.circusmanager.Controller.ZooTelas to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.FuncionarioTelas to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.CircoTelas to javafx.fxml;
}