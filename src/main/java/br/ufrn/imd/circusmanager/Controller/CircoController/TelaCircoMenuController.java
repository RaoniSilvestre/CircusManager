package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Service.CircoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void initialize() {
        this.circoService = new CircoService();
        caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoMenu.png";
        super.initialize();
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

        double saldo = circoService.calcularSaldo(circo);

        saldoLabel.setText("Saldo: " + saldo);
    }

}
