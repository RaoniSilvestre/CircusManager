package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import javafx.fxml.*;

public class TelaShowController extends Tela {

    
    @FXML
    private void registrarShow() {
        main.showScreen(15);
    }


    @FXML
    private void simularShow() {
        main.showScreen(16);
    }


    @FXML
    private void verHistoricoDeShow() {
        main.showScreen(17);
    }


    // Atualizar a Interface
    public void atualizar() {}
    
}
