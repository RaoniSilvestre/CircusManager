package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.*;

public class TelaZooController extends TelaComImagem {

    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaAnimais.png";
        super.initialize();
    }

    @FXML
    private void verListaAnimais() {
        manager.trocarTela("ListaAnimaisView.fxml", circus);
    }


    @FXML
    private void adicionarAnimal() {
        manager.trocarTela("AddAnimalView.fxml", circus);
    }


    @FXML
    private void removerAnimal() {
        manager.trocarTela("RemoverAnimalView.fxml", circus);
    }

    // Atualizar a Interface
    public void atualizar() {}
    
}
