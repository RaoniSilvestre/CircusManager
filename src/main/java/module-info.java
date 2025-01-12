module br.ufrn.imd.circusmanager.Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;


    opens br.ufrn.imd.circusmanager.Controller to javafx.fxml;
    exports br.ufrn.imd.circusmanager;
    opens br.ufrn.imd.circusmanager.Controller.ZooController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.FuncionarioController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.ShowController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.CircoController to javafx.fxml;
    opens br.ufrn.imd.circusmanager.Controller.LoginController to javafx.fxml;


    opens br.ufrn.imd.circusmanager.Model.Circus to org.hibernate.orm.core;
    opens br.ufrn.imd.circusmanager.Model.Itens to org.hibernate.orm.core;
    opens br.ufrn.imd.circusmanager.Model.Funcionarios to org.hibernate.orm.core;
    opens br.ufrn.imd.circusmanager.Model.Animais to org.hibernate.orm.core;
    opens br.ufrn.imd.circusmanager.Model.ContaBancaria to org.hibernate.orm.core;

    exports br.ufrn.imd.circusmanager.Controller;
}