package br.ufrn.imd.circusmanager.Control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaInicialController extends Tela {
    @FXML
    private Label welcomeText;

    @Override
    public void atualizar() {return;}

    @FXML
    protected void onHelloButtonClick() {
        main.showScreen(2);
    }
}