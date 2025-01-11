package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class RemoverFuncionarioController extends Tela {

    @FXML
    private VBox funcionariosVBox;

    private HBox criarLinhaFuncionario(Funcionario funcionario) {
        HBox linha = new HBox();
        linha.setSpacing(10);
        linha.setAlignment(Pos.CENTER_LEFT);

        Label nomeLabel = new Label(funcionario.getDescricao());
        nomeLabel.setStyle("-fx-font-size: 16px;");

        Button removerButton = new Button("X");
        removerButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
        removerButton.setOnAction(event -> removerFuncionario(funcionario));

        linha.getChildren().addAll(nomeLabel, removerButton);
        return linha;
    }

    private void removerFuncionario(Funcionario funcionario) {
        // Lógica para remover o funcionário do sistema
        System.out.println("Funcionário removido: " + funcionario.getNome());

        circus.deleteFuncionario(funcionario);

        atualizar();
    }

    @Override
    public void atualizar() {
        funcionariosVBox.getChildren().clear();
        for (Funcionario funcionario : circus.getListaDeFuncionarios()) {
            HBox linha = criarLinhaFuncionario(funcionario);
            funcionariosVBox.getChildren().add(linha);
        }
    }
}
