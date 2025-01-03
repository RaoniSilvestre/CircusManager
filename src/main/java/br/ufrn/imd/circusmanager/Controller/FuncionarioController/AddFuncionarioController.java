package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import java.util.Map;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddFuncionarioController extends Tela {
    
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


    Map<String, MagicoEnum> magicoMap = Map.of(
        "ILUSIONISTA", MagicoEnum.ILUSIONISTA,
        "INFANTIL", MagicoEnum.INFANTIL,
        "CLASSICO", MagicoEnum.CLASSICO
    );
        

    Map<String, PalhacosEnum> palhacoMap = Map.of(
        "AUGUSTO", PalhacosEnum.AUGUSTO,
        "BRANCO", PalhacosEnum.BRANCO,
        "CONTRA_AGUSTO", PalhacosEnum.CONTRA_AUGUSTO,
        "MIMICO", PalhacosEnum.MIMICO
    );
        
        
     Map<String, TrapezistaEnum> trapezistaMap = Map.of(
        "FIXO", TrapezistaEnum.FIXO,
        "VOADOR", TrapezistaEnum.VOADOR,
        "CASTIN", TrapezistaEnum.CASTIN,
        "MULTIPLO", TrapezistaEnum.MULTIPLO
    );


     @FXML
    public void initialize() {
        // Definir opções do ComboBox de ocupação
        ocupacaoComboBox.setItems(FXCollections.observableArrayList("Mágico", "Palhaço", "Trapezista", "Vendedor"));

        ocupacaoComboBox.setOnAction(event -> {
            if (ocupacaoComboBox.getValue() == null) return;
 
            String ocupacaoSelecionada = ocupacaoComboBox.getValue();

            //Limpar itens e tipo
            itensListView.getItems().clear();
            tipoComboBox.getItems().clear();
            tipoComboBox.setDisable(false);

            if (ocupacaoSelecionada.equals("Mágico")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("ILUSIONISTA", "INFANTIL", "CLASSICO"));
                itemComboBox.setItems(FXCollections.observableArrayList("Cartola","Baralho"));
            }
            else if (ocupacaoSelecionada.equals("Palhaço")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("BRANCO", "AUGUSTO", "CONTRA_AUGUSTO","MIMICO"));
                itemComboBox.setItems(FXCollections.observableArrayList("Nariz vermelho", "Bota grande"));
            }
            else if (ocupacaoSelecionada.equals("Trapezista")) {
                tipoComboBox.setItems(FXCollections.observableArrayList("FIXO","VOADOR","CASTIN","MULTIPLO"));
                itemComboBox.setItems(FXCollections.observableArrayList("Trapezio"));
            }
            else {
                tipoComboBox.setDisable(true);
                itemComboBox.setItems(FXCollections.observableArrayList("Algodão doce","Pipoca","Palhaço de brinquedo"));
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
        
        if (ocupacao == null || (tipo == null && !ocupacao.equals("Vendedor")) || nome == null) {
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
        
        Funcionario funcionarioContratado;

        switch (ocupacao) {
            case "Mágico" -> {
                MagicoEnum magicoEnum = magicoMap.get(tipo);
                Magico magico = new Magico(nome, salario, magicoEnum);
                funcionarioContratado = magico;
            }
            case "Palhaço" -> {
                PalhacosEnum palhacosEnum = palhacoMap.get(tipo);
                Palhaco palhaco = new Palhaco(nome, salario, palhacosEnum);
                funcionarioContratado = palhaco;
            }
            case "Trapezista" -> {
                TrapezistaEnum trapezistaEnum = trapezistaMap.get(tipo);
                Trapezista trapezista = new Trapezista(nome, salario, trapezistaEnum);
                funcionarioContratado = trapezista;
            }
            case "Vendedor" -> {
                Vendedor vendedor = new Vendedor(nome, salario);
                funcionarioContratado = vendedor;
            }
            default -> { showAlert("Tipo Error", "Selecione o tipo de do sua funcionario"); return; }
        }

        main.circoAtual.getListaDeFuncionarios().addFuncionario(funcionarioContratado);
        adicionarItens(funcionarioContratado);

        showAlert("Funcionario adicionado", "Funcionario foi adicionado com sucesso");
        voltar();
    }

    private void adicionarItens(Funcionario funcionario) {
        for (String item : itensListView.getItems()) {
            funcionario.getItens().add(item);   
        }
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
