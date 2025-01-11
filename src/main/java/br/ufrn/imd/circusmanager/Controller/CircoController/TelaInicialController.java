package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaInicialController extends TelaComImagem {

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/ImagemInicial.png";
        super.initialize();
    }
    
    @FXML
    private Label welcomeText;

    @Override
    public void atualizar() {return;}

    @FXML
    protected void onHelloButtonClick() {
        main.showScreen(2);
    }
}