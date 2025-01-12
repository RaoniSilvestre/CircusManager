package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaInicialController extends TelaComImagem {

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/ImagemInicial.png";
        super.initialize();
    }

    @Override
    public void atualizar() {
    }

    @FXML
    protected void onHelloButtonClick() {
        trocarTela("LoginView.fxml");
    }
}