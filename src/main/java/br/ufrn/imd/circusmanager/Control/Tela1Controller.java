package br.ufrn.imd.circusmanager.Control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Tela1Controller extends Botao {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        main.showScreen(2);
    }
}