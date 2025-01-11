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
