package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacosEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Enums.FerramentaPalhacoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Enums.FerramentaTrapezistaEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class TelaAddFuncionarioController extends Tela {
    
    @Override
    public void atualizar() {}
    @FXML
    private ComboBox<OcupacaoEnum> ocupacaoComboBox;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField salarioTextField;
    @FXML
    private ComboBox<String> tipoComboBox;
    @FXML
    private ListView<String> itensListView;
    @FXML
    private ComboBox<String> itemComboBox;

     @FXML
    public void initialize() {
        // Definir opções do ComboBox de ocupação
        ocupacaoComboBox.setItems(FXCollections.observableArrayList(OcupacaoEnum.values()));

        ocupacaoComboBox.setOnAction(event -> {
            if (ocupacaoComboBox.getValue() == null) return;
 
            OcupacaoEnum ocupacaoSelecionada = ocupacaoComboBox.getValue();

            //Limpar itens e tipo
            itensListView.getItems().clear();
            tipoComboBox.getItems().clear();

            System.out.println("Ocupação selecionada: " + ocupacaoSelecionada);

            switch (ocupacaoSelecionada) {
                case TRAPEZISTA -> {
                    tipoComboBox.setItems(parseToString(TrapezistaEnum.values()));
                    itemComboBox.setItems(parseToString(FerramentaTrapezistaEnum.values()));
                }
                case PALHACO -> {
                    tipoComboBox.setItems(parseToString(PalhacosEnum.values()));
                    itemComboBox.setItems(parseToString(FerramentaPalhacoEnum.values()));
                }
                case MAGICO -> {
                    tipoComboBox.setItems(parseToString(MagicoEnum.values()));
                    itemComboBox.setItems(parseToString(MagicoEnum.values()));
                }
            }
        });
    }

    // Método para adicionar um item à lista de itens
    @FXML
    private void adicionarItem() {
        String itemSelecionado = itemComboBox.getValue();
        if (itemSelecionado != null) {
            for (String item : itensListView.getItems()){
                if (item.equals(itemSelecionado))
                    return;
            }
            itensListView.getItems().add(itemSelecionado);
        }
    }

    // Método para adicionar o funcionário
    @FXML
    private void adicionarFuncionario() {
        
        OcupacaoEnum ocupacao = ocupacaoComboBox.getValue();
        String nome = nomeTextField.getText();
        String salarioString = salarioTextField.getText();
        String tipo = tipoComboBox.getValue();
        
        if (ocupacao == null || tipo == null || nome == null) {
            showAlert("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        double salario = 0.0;

        try {
            salario = Double.parseDouble(salarioString);

            if (salario < 0) {
                showAlert("Erro", "O funcionario não pode pagar para trabalhar!");
                return;
            }

        } catch (NumberFormatException e) {
            showAlert("Erro", "Salario deve ser um número válido!");
            return;
        }
        
        
        switch (ocupacao) {
            case MAGICO -> {
                MagicoEnum magicoEnum = magicoMap.get(tipo);
                Magico magico = new Magico(nome, salario, magicoEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(magico);
            }
            case PALHACO -> {
                PalhacosEnum palhacosEnum = palhacoMap.get(tipo);
                Palhaco palhaco = new Palhaco(nome, salario, palhacosEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(palhaco);
            }
            case TRAPEZISTA -> {
                TrapezistaEnum trapezistaEnum = trapezistaMap.get(tipo);
                Trapezista trapezista = new Trapezista(nome, salario, trapezistaEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(trapezista);
            }
        }

        showAlert("Funcionario adicionado", "Funcionario foi adicionado com sucesso");
        voltar();
    }


    private void limpar() {
        ocupacaoComboBox.setValue(null);
        nomeTextField.clear();
        salarioTextField.clear();
        tipoComboBox.setValue(null);
        itensListView.getItems().clear();
        itemComboBox.setValue(null);
    }


    private <T> ObservableList<String> parseToString(T[] list) {
        return FXCollections.observableArrayList(
                Arrays.stream(list)
                        .map(Object::toString)
                        .toList()
        );
    }

    @Override
    public void voltar() {
        limpar();
        super.voltar();
    }
}
