package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.*;

public class TelaFuncionariosController extends TelaComImagem {

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaFuncionarios.png";
        super.initialize();
    }

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
