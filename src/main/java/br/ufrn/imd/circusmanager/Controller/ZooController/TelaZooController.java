package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import javafx.fxml.*;

public class TelaZooController extends Tela {

    
    @FXML
    private void verListaAnimais() {
        main.showScreen(10);
    }


    @FXML
    private void adicionarAnimal() {
        main.showScreen(11);
    }


    @FXML
    private void removerAnimal() {
        main.showScreen(12);
    }


    // Atualizar a Interface
    public void atualizar() {}
    
}
