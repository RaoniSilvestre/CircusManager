package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Animais.AnimalEnum;
import br.ufrn.imd.circusmanager.Service.ZooService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * The type Add animal controller.
 */
public class AddAnimalController extends Tela {

    /**
     * The Zoo service.
     */
    ZooService zooService;

    @FXML
    private ComboBox<AnimalEnum> especieComboBox;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField valorManutencaoTextField;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        especieComboBox.setItems(FXCollections.observableArrayList(AnimalEnum.values()));
        this.zooService = new ZooService();
    }

    @FXML
    private void adicionarAnimal() {
        AnimalEnum especieSelecionada = especieComboBox.getValue();
        String nome = nomeTextField.getText();
        String valorManutencaoString = valorManutencaoTextField.getText();

        if (especieSelecionada == null || nome == null || nome.isBlank()) {
            showAlert("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        double valorManutencao;
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

        // Cria o objeto Animal e adiciona ao sistema
        Animal animal = new Animal(nome, valorManutencao, especieSelecionada);
        zooService.addAnimal(animal, Tela.getCirco());

        showAlert("Sucesso", "Animal adicionado com sucesso.");
        voltar();
    }

    private void limpar() {
        especieComboBox.setValue(null);
        nomeTextField.clear();
        valorManutencaoTextField.clear();
    }

    @Override
    public void atualizar() {
    }

    @FXML
    public void voltar() {
        limpar();
        super.voltar();
    }

}
