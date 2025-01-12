package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Service.FuncionarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ListaFuncionariosController extends Tela {

    FuncionarioService funcionarioService;


    @FXML
    private ListView<Funcionario> listaFuncionarios;

    @FXML
    public void initialize() {
        this.funcionarioService = new FuncionarioService();
    }

    public void inicializarLista() {
        listaFuncionarios.getItems().clear();

        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionario(Tela.getCirco());
        ObservableList<Funcionario> observableList = FXCollections.observableArrayList(funcionarios);

        listaFuncionarios.setItems(observableList);
    }


    public void atualizar() {
        inicializarLista();
    }
}
