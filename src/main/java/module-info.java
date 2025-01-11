module br.ufrn.imd.circusmanager.Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens br.ufrn.imd.circusmanager.Controller to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
    opens br.ufrn.imd.circusmanager.Controller.ZooController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.FuncionarioController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.ShowController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.CircoController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.LoginController to javafx.fxml;
}