package br.ufrn.imd.circusmanager.Controller.LoginController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController extends Tela {

    @FXML
    private Button criarNovoCircoButton;

    @FXML
    private Button entrarButton;

    @FXML
    private TextField circoTextField;

    @FXML
    private Label erroLabel;

    @FXML
    private void criarNovoCirco() {
        main.showScreen(3);
    }

    @FXML
    private void entrarEmCirco() {
        String circo = circoTextField.getText();

        if (circo == null || circo.isEmpty()) {
            erroLabel.setText("Digite o nome do seu circo");
            erroLabel.setVisible(true);
            return;
        }

        // Verificar o nome do circo
        boolean circoExiste = verificarCirco(circo);

        if (!circoExiste) {
            erroLabel.setText("Circo inexistente");
            erroLabel.setVisible(true);
            return;
        }

        System.out.println("Entrando no circo: " + circo);
        erroLabel.setVisible(false);
        // main.showScreen(4,circo);
    }

    private boolean verificarCirco(String circo) {
        return false; // Faz o codigo ai mano
        // Ok man jaja
    }

    @Override
    public void atualizar() {
    }
}
