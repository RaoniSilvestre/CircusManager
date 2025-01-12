package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Service.CircoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TelaCircoMenuController extends TelaComImagem {
    CircoService circoService;

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
    private HBox editSaldoContainer;

    @FXML
    public void initialize() {
        this.circoService = new CircoService();
    }

    @FXML
    private void editarSaldo() {
        // Ocultar o saldo e o botão "Editar"
        saldoLabel.setVisible(false);
        editarSaldoButton.setVisible(false);

        // Mostrar o contêiner de edição
        editSaldoContainer.setVisible(true);
    }

    @FXML
    private void confirmarSaldo() {
        try {
            double novoSaldo = Double.parseDouble(saldoTextField.getText());

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
        TelaCircoMenuController.getManager().trocarTela("TelaFuncionariosView.fxml");
    }

    @FXML
    private void zoo() {
        trocarTela("TelaZooView.fxml");
    }

    @FXML
    private void dados() {
        trocarTela("TelaDadosView.fxml");
    }

    @FXML
    private void show() {
        trocarTela("TelaShowView.fxml");
    }

    @FXML
    private void sairDoCirco() {
        Tela.setCirco(null);
        trocarTela("LoginView.fxml");
    }

    // Atualizar a Interface
    public void atualizar() {
        Circo circo = Tela.getCirco();
        circusLabel.setText("Circo: " + circo.getNome());

        double saldo = circo.getConta().calcularSaldo();

        saldoLabel.setText("Saldo: " + saldo);

        cancelarEdicaoSaldo();
    }

}
