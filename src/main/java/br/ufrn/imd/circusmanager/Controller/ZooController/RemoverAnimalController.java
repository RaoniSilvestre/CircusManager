package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Service.ZooService;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class RemoverAnimalController extends Tela {

    ZooService zooService;

    @FXML
    private VBox animaisVBox;

    @FXML
    public void initialize() {
        this.zooService = new ZooService();
    }

    private HBox criarLinhaAnimal(Animal animal) {
        HBox linha = new HBox();
        linha.setSpacing(10);
        linha.setAlignment(Pos.CENTER_LEFT);

        Label nomeLabel = new Label(animal.toString());
        nomeLabel.setStyle("-fx-font-size: 16px;");

        Button removerButton = new Button("X");
        removerButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
        removerButton.setOnAction(event -> removerAnimal(animal));

        linha.getChildren().addAll(nomeLabel, removerButton);
        return linha;
    }

    private void removerAnimal(Animal animal) {
        zooService.deletarAnimal(animal);

        System.out.println("Animal removido: " + animal.getNome());

        atualizar();
    }


    @Override
    public void atualizar() {
        animaisVBox.getChildren().clear();

        List<Animal> animais = this.zooService.listarAnimais(Tela.getCirco());

        for (Animal animal : animais) {
            HBox linha = criarLinhaAnimal(animal);
            animaisVBox.getChildren().add(linha);
        }
    }
}
