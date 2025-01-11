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
        manager.trocarTela("ListaFuncionariosView.fxml", circus);
    }

    @FXML
    private void adicionarFuncionario() {
        manager.trocarTela("AddFuncionarioView.fxml", circus);
    }


    @FXML
    private void removerFuncionario() {
        manager.trocarTela("RemoverFuncionarioView.fxml", circus);
    }


    // Atualizar a Interface
    public void atualizar() {}
}
