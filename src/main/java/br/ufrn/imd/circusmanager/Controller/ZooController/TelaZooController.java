package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;

/**
 * The type Tela zoo controller.
 */
public class TelaZooController extends TelaComImagem {

    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaAnimais.png";
        super.initialize();
    }

    @FXML
    private void verListaAnimais() {
        trocarTela("ListaAnimaisView.fxml");
    }


    @FXML
    private void adicionarAnimal() {
        trocarTela("AddAnimalView.fxml");
    }


    @FXML
    private void removerAnimal() {
        trocarTela("RemoverAnimalView.fxml");
    }

    // Atualizar a Interface
    public void atualizar() {
    }

}
