package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;

public class TelaFuncionariosController extends TelaComImagem {

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/TelaFuncionarios.png";
        super.initialize();
    }

    @FXML
    private void verListaFuncionarios() {
        trocarTela("ListaFuncionariosView.fxml");
    }

    @FXML
    private void adicionarFuncionario() {
        trocarTela("AddFuncionarioView.fxml");
    }


    @FXML
    private void removerFuncionario() {
        trocarTela("RemoverFuncionarioView.fxml");
    }


    // Atualizar a Interface
    public void atualizar() {
    }
}
