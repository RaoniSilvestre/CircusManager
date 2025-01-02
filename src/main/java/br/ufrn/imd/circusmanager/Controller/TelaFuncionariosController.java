package br.ufrn.imd.circusmanager.Controller;

import javafx.fxml.*;

public class TelaFuncionariosController extends Tela {
    
    @FXML
    private void verListaFuncionarios() {
        main.showScreen(6);
    }


    @FXML
    private void adicionarFuncionario() {
        main.showScreen(7);
    }


    @FXML
    private void removerFuncionario() {
        main.showScreen(8);
    }


    // Atualizar a Interface
    public void atualizar() {}
    

}
