package br.ufrn.imd.circusmanager.Controller.FuncionarioController;

import java.util.ArrayList;
import java.util.Arrays;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.*;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import br.ufrn.imd.circusmanager.Model.Itens.ItemFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddFuncionarioController extends Tela {
    
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
    private ListView<Item> itensListView;
    @FXML
    private ComboBox<Item> itemComboBox;

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
            tipoComboBox.setDisable(false);

            switch (ocupacaoSelecionada) {
                case VENDEDOR -> this.updateVendedorComboBox();
                case MAGICO -> this.updateComboBox(MagicoEnum.values(), ItemFactory.getMagicoItens());
                case PALHACO -> this.updateComboBox(PalhacoEnum.values(), ItemFactory.getPalhaçoItens());
                case TRAPEZISTA -> this.updateComboBox(TrapezistaEnum.values(), ItemFactory.getTrapezistaItens());
            }
        });
    }

    private void updateVendedorComboBox() {
        tipoComboBox.setDisable(true);
        itemComboBox.setItems(FXCollections.observableArrayList(ItemFactory.getVendedorItens()));
    }

    private <A> void updateComboBox(A[] tipos, ArrayList<Item> ferramentas) {
        tipoComboBox.setItems(mapListToListString(tipos));
        itemComboBox.setItems(FXCollections.observableArrayList(ferramentas));
    }

    private <T> ObservableList<String> mapListToListString(T[] list) {
        return FXCollections.observableArrayList(Arrays.stream(list).map(Object::toString).toList());
    }

    @FXML
    private void adicionarItem() {
        Item itemSelecionado = itemComboBox.getValue();
        if (itemSelecionado != null) {
            for (Item item : itensListView.getItems()){
                if (item.equals(itemSelecionado))
                    return;
            }
            itensListView.getItems().add(itemSelecionado);
        }
    }

    @FXML
    private void adicionarFuncionario() {
        OcupacaoEnum ocupacao = ocupacaoComboBox.getValue();
        String nome = nomeTextField.getText();
        String salarioString = salarioTextField.getText();
        String tipo = tipoComboBox.getValue();
        
        if (ocupacao == null || (tipo == null && !ocupacao.equals(OcupacaoEnum.VENDEDOR)) || nome == null) {
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
        
        Funcionario funcionarioContratado = switch (ocupacao) {
            case VENDEDOR -> new Vendedor(nome, salario);
            case MAGICO -> new Magico(nome, salario, MagicoEnum.fromString(tipo));
            case TRAPEZISTA -> new Trapezista(nome, salario, TrapezistaEnum.fromString(tipo));
            case PALHACO -> new Palhaco(nome, salario, PalhacoEnum.fromString(tipo));
        };


        circus.addFuncionario(funcionarioContratado);
        adicionarItens(funcionarioContratado);

        showAlert("Funcionario adicionado", "Funcionario foi adicionado com sucesso");
        voltar();
    }


    private void adicionarItens(Funcionario funcionario) {
        for (Item item : itensListView.getItems()) {
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
