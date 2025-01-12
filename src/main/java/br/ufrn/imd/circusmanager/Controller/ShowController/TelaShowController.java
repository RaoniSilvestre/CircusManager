package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;

/**
 * The type Tela show controller.
 */
public class TelaShowController extends TelaComImagem {

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaShow.png";
        super.initialize();
    }

    @FXML
    private void registrarShow() {
        trocarTela("CadastrarShowView.fxml");
    }


    @FXML
    private void simularShow() {
        trocarTela("SimularShowView.fxml");
    }


    @FXML
    private void verHistoricoDeShow() {
        trocarTela("ListaShowView.fxml");
    }


    // Atualizar a Interface
    public void atualizar() {
    }

}
