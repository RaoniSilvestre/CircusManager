package br.ufrn.imd.circusmanager.Control;

import javafx.fxml.*;

public class TelaZooController extends Botao{

    
    @FXML
    private void verListaAnimais() {
        main.showScreen(9, main.getCircoAtual());
    }


    @FXML
    private void adicionarAnimal() {
        main.showScreen(10, main.circoAtual);
    }


    @FXML
    private void removerAnimal() {
        main.showScreen(11, main.circoAtual);
    }


    // Atualizar a Interface
    public void atualizar() {}
    
}
