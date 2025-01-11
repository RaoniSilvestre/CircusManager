package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.*;

public class TelaShowController extends TelaComImagem {

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaShow.png";
        super.initialize();
    }

    @FXML
    private void registrarShow() {
        manager.trocarTela("CadastrarShowView.fxml", circus);
    }


    @FXML
    private void simularShow() {
        manager.trocarTela("SimularShowView.fxml", circus);
    }


    @FXML
    private void verHistoricoDeShow() {
        manager.trocarTela("ListaShowView.fxml", circus);
    }


    // Atualizar a Interface
    public void atualizar() {}
    
}
