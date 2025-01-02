package br.ufrn.imd.circusmanager.Control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaCircoMenuController extends Botao {

    // Referência para o LAbel que exibe o nome do circo
    @FXML
    private Label circusLabel;

    // Referência para o Label que exibe o saldo
    @FXML
    private Label saldoLabel;

    
    @FXML
    private void verificarListaFuncionarios() {
        main.showScreen(5);
    }


    @FXML
    private void adicionarFuncionario() {
        main.showScreen(6);
    }


    @FXML
    private void removerFuncionario() {
        main.showScreen(7);
    }


    @FXML
    private void zoo() {
        main.showScreen(8);
    }


    @FXML
    private void sairDoCirco() {
       main.showScreen(2);
    }

    // Atualizar a Interface
    public void atualizar() {
        saldoLabel.setText("Saldo: $" + main.getCircoAtual().getConta().getBalanco());
        circusLabel.setText("Circo: " + main.getCircoAtual().getNome());
    }
    
}
