package br.ufrn.imd.circusmanager.Control;

import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaListaFuncionariosController extends Tela {
    @FXML
    private ListView<String> listaFuncionarios;

    // Método chamado para preencher a lista de funcionários
    public void inicializarLista() {
        listaFuncionarios.getItems().clear();
    
        for (Funcionario funcionario : main.circoAtual.getListaDeFuncionarios().getFuncionarios()) {
            listaFuncionarios.getItems().add(getFuncionarioDescricao(funcionario));
        }
    }


    public void atualizar() {
        inicializarLista();
    }
}
