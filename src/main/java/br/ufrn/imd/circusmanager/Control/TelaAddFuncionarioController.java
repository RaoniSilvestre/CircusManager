package br.ufrn.imd.circusmanager.Control;

import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacosEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TelaAddFuncionarioController extends Botao{
    
    @Override
    public void atualizar() {}
    @FXML
    private ComboBox<String> ocupacaoComboBox;
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
        ocupacaoComboBox.setItems(FXCollections.observableArrayList("Mágico", "Palhaço", "Trapezista"));

        ocupacaoComboBox.setOnAction(event -> {
            if (ocupacaoComboBox.getValue() == null) return;
 
            String ocupacaoSelecionada = ocupacaoComboBox.getValue();

            //Limpar itens e tipo
            itensListView.getItems().clear();
            tipoComboBox.getItems().clear();

            System.out.println("Ocupação selecionada: " + ocupacaoSelecionada);

            if (ocupacaoSelecionada.equals("Mágico")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("ILUSIONISTA", "INFANTIL", "CLASSICO"));
                itemComboBox.setItems(FXCollections.observableArrayList("CARTOLA","BARALHO"));
            }
            else if (ocupacaoSelecionada.equals("Palhaço")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("BRANCO", "AUGUSTO", "CONTRA_AUGUSTO","MIMICO"));
                itemComboBox.setItems(FXCollections.observableArrayList("NARIZ_VERMELHO", "BOTA_GRANDE"));
            }
            else if (ocupacaoSelecionada.equals("Trapezista")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("FIXO","VOADOR","CASTIN","MULTIPLO"));
                itemComboBox.setItems(FXCollections.observableArrayList("TRAPEZIO"));
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
        
        String ocupacao = ocupacaoComboBox.getValue();
        String nome = nomeTextField.getText();
        String salarioString = salarioTextField.getText();
        String tipo = tipoComboBox.getValue();
        
        if (ocupacao == null || tipo == null || nome == null) {
            showAlert("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        Double salario = 0.0;

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
            case "Mágico" -> {
                MagicoEnum magicoEnum = magicoMap.get(tipo);
                Magico magico = new Magico(nome, salario, magicoEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(magico);
            }
            case "Palhaço" -> {
                PalhacosEnum palhacosEnum = palhacoMap.get(tipo);
                Palhaco palhaco = new Palhaco(nome, salario, palhacosEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(palhaco);
            }
            case "Trapezista" -> {
                TrapezistaEnum trapezistaEnum = trapezistaMap.get(tipo);
                Trapezista trapezista = new Trapezista(nome, salario, trapezistaEnum);
                main.circoAtual.getListaDeFuncionarios().addFuncionario(trapezista);
            }
            default -> { showAlert("Tipo Error", "Selecione o tipo de do sua funcionario"); return; }
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


    @Override
    public void voltar() {
        limpar();
        super.voltar();
    }
}
