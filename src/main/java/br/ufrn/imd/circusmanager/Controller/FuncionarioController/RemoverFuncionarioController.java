package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Service.FuncionarioService;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class RemoverFuncionarioController extends Tela {

    FuncionarioService funcionarioService;

    @FXML
    private VBox funcionariosVBox;

    @FXML
    public void initialize() {
        this.funcionarioService = new FuncionarioService();
    }

    private HBox criarLinhaFuncionario(Funcionario funcionario) {
        HBox linha = new HBox();
        linha.setSpacing(10);
        linha.setAlignment(Pos.CENTER_LEFT);

        Label nomeLabel = new Label(funcionario.toString());
        nomeLabel.setStyle("-fx-font-size: 16px;");

        Button removerButton = new Button("X");
        removerButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
        removerButton.setOnAction(event -> removerFuncionario(funcionario));

        linha.getChildren().addAll(nomeLabel, removerButton);
        return linha;
    }

    private void removerFuncionario(Funcionario funcionario) {
        funcionarioService.deletarFuncionario(funcionario);

        System.out.println("Funcionário removido: " + funcionario.getNome());

        atualizar();
    }

    @Override
    public void atualizar() {
        funcionariosVBox.getChildren().clear();

        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionario(Tela.getCirco());

        for (Funcionario funcionario : funcionarios) {
            HBox linha = criarLinhaFuncionario(funcionario);
            funcionariosVBox.getChildren().add(linha);
        }
    }
}
