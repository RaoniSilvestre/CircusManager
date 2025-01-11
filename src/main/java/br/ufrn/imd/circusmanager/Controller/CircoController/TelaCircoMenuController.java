package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TelaCircoMenuController extends TelaComImagem {
    // Referência para o LAbel que exibe o nome do circo
    @FXML
    private Label circusLabel;

    @FXML
    private Label saldoLabel;

    @FXML
    private Button editarSaldoButton;

    @FXML
    private TextField saldoTextField;

    @FXML
    private Button confirmarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private HBox editSaldoContainer; // Contêiner para edição do saldo

    @FXML
    private void editarSaldo() {
        // Ocultar o saldo e o botão "Editar"
        saldoLabel.setVisible(false);
        editarSaldoButton.setVisible(false);

        // Mostrar o contêiner de edição
        editSaldoContainer.setVisible(true);

        // Preencher o campo de texto com o saldo atual
        saldoTextField.setText(Double.toString(circus.getConta().getBalanco()));
    }

    @FXML
    private void confirmarSaldo() {
        try {
            double saldoAtual = Double.parseDouble(saldoTextField.getText());

            double valorAtingo = circus.getConta().getBalanco();

            double valorDaTransacao =  saldoAtual - valorAtingo;
            circus.getConta().addTransacao(new Transacao("Edição", TransacaoEnum.INDEFINIDO, valorDaTransacao));

            atualizar();

        } catch (NumberFormatException e) {
            showAlert("Erro!", "Valor inválido.");
        }
    }

    @FXML
    private void cancelarEdicaoSaldo() {
        editSaldoContainer.setVisible(false);

        saldoLabel.setVisible(true);
        editarSaldoButton.setVisible(true);
    }

    
    @FXML
    private void funcionarios() {
        main.showScreen(5);
    }

    @FXML
    private void zoo() {
        main.showScreen(9);
    }

    @FXML
    private void dados() {
        main.showScreen(13);
    }

    @FXML
    private void sairDoCirco() {
       main.showScreen(2);
    }

    @FXML
    private void show() {
        main.showScreen(14);
    }

    // Atualizar a Interface
    public void atualizar() {
        saldoLabel.setText("Saldo: $" + circus.getConta().getBalanco());
        circusLabel.setText("Circo: " + circus.getNome());
        cancelarEdicaoSaldo();
    }
    
}
