package br.ufrn.imd.circusmanager.Controller.LoginController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import br.ufrn.imd.circusmanager.Dao.CircoDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

public class LoginController extends TelaComImagem {

    @Getter
    @Setter
    private CircoDAO circoDAO;

    @FXML
    private Button criarNovoCircoButton;

    @FXML
    private Button entrarButton;

    @FXML
    private TextField circoTextField;

    @FXML
    private Label erroLabel;

    @FXML
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoLogin.png";
        super.initialize();


        this.circoDAO = new CircoDAO();
    }

    @FXML
    private void criarNovoCirco() {
        Tela.getManager().trocarTela("CriarCircoView.fxml");
    }

    @FXML
    private void entrarEmCirco() {
        String circo = circoTextField.getText();

        if (circo == null || circo.isEmpty()) {
            erroLabel.setText("Digite o nome do seu circo");
            erroLabel.setVisible(true);
            return;
        }

        Circo circoAtual = this.getCircoDAO().buscarPorNome(circo);

        if (circoAtual == null) {
            erroLabel.setText("Circo inexistente");
            erroLabel.setVisible(true);
            return;
        }

        System.out.println("Entrando no circo: " + circo);

        Tela.setCirco(circoAtual);

        erroLabel.setVisible(false);

        trocarTela("TelaCircoMenuView.fxml");
    }


    @Override
    public void atualizar() {
    }
}
