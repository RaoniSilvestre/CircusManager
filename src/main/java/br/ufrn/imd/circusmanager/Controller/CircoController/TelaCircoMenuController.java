package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaCircoMenuController extends Tela {

    // Referência para o LAbel que exibe o nome do circo
    @FXML
    private Label circusLabel;

    // Referência para o Label que exibe o saldo
    @FXML
    private Label saldoLabel;

    
    @FXML
    private void funcionarios() {
        main.showScreen(5);
    }

    @FXML
    private void zoo() {
        main.showScreen(9);
    }

    @FXML
    private void dados() {
        main.showScreen(13);
    }

    @FXML
    private void sairDoCirco() {
       main.showScreen(2);
    }

    @FXML
    private void show() {
        main.showScreen(14);
    }

    // Atualizar a Interface
    public void atualizar() {
        saldoLabel.setText("Saldo: $" + circus.getConta().getBalanco());
        circusLabel.setText("Circo: " + circus.getNome());
    }
    
}
