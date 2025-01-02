package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Animais.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddAnimalController extends Tela {

    @FXML
    private ComboBox<String> especieComboBox;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField valorManutencaoTextField;

    @FXML
    public void initialize() {
        // Define as opções do ComboBox de espécie
        especieComboBox.setItems(FXCollections.observableArrayList(
            "LEÃO", "ELEFANTE", "GIRAFA", "ORNITORRINCO"
        ));
    }

    @FXML
    private void adicionarAnimal() {
        String especieSelecionada = especieComboBox.getValue();
        String nome = nomeTextField.getText();
        String valorManutencaoString = valorManutencaoTextField.getText();

        if (especieSelecionada == null || nome == null || nome.isBlank()) {
            showAlert("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        Double valorManutencao;
        try {
            valorManutencao = Double.parseDouble(valorManutencaoString);

            if (valorManutencao < 0) {
                showAlert("Erro", "O valor da manutenção não pode ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Erro", "O valor da manutenção deve ser um número válido.");
            return;
        }

        // Converte a string da espécie para o enum correspondente
        AnimaisEnum especieEnum = AnimaisEnum.fromString(especieSelecionada);
        if (especieEnum == null) {
            showAlert("Erro", "Espécie inválida.");
            return;
        }

        // Cria o objeto Animal e adiciona ao sistema
        Animal animal = new Animal(nome, valorManutencao, especieEnum);
        main.circoAtual.getListaDeAnimais().addAnimal(animal);

        showAlert("Sucesso", "Animal adicionado com sucesso.");
        voltar();
    }

    private void limpar() {
        especieComboBox.setValue(null);
        nomeTextField.clear();
        valorManutencaoTextField.clear();
    }

    @Override
    public void voltar() {
        limpar();
        super.voltar();
    }

    @Override
    public void atualizar() {}
}
