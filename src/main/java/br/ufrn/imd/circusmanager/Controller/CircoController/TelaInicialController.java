package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The type Tela inicial controller.
 */
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

    /**
     * On hello button click.
     */
    @FXML
    protected void onHelloButtonClick() {
        trocarTela("LoginView.fxml");
    }
}