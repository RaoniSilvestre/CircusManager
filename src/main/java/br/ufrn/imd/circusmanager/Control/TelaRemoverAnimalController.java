package br.ufrn.imd.circusmanager.Control;

import br.ufrn.imd.circusmanager.Model.Animais.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class TelaRemoverAnimalController extends Tela {

    @FXML
    private VBox animaisVBox;

    private HBox criarLinhaAnimal(Animal animal) {
        HBox linha = new HBox();
        linha.setSpacing(10);
        linha.setAlignment(Pos.CENTER_LEFT);

        Label nomeLabel = new Label(animal.getDescricao());
        nomeLabel.setStyle("-fx-font-size: 16px;");

        Button removerButton = new Button("X");
        removerButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
        removerButton.setOnAction(event -> removerFuncionario(animal));

        linha.getChildren().addAll(nomeLabel, removerButton);
        return linha;
    }

    private void removerFuncionario(Animal animal) {
        // Lógica para remover o funcionário do sistema
        System.out.println("Animal removido: " + animal.getNome());

        main.getCircoAtual().getListaDeAnimais().deleteAnimal(animal);

        atualizar();
    }

    @Override
    public void atualizar() {
        animaisVBox.getChildren().clear();
        for (Animal animal : main.getCircoAtual().getListaDeAnimais().getAnimais()) {
            HBox linha = criarLinhaAnimal(animal);
            animaisVBox.getChildren().add(linha);
        }
    }
}
