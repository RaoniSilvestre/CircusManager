package br.ufrn.imd.circusmanager.Control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import br.ufrn.imd.circusmanager.Model.Circus.*;

public class Tela3Controller extends Botao {

    @FXML
    private TextField nomeCircoField;

    @FXML
    private TextField saldoCircoField;


    @FXML
    private void criarCirco() {
        String nomeCirco = nomeCircoField.getText();
        String saldoCirco = saldoCircoField.getText();

        if (nomeCirco.isEmpty() || saldoCirco.isEmpty()) {
            showAlert("Erro", "Todos os campos devem ser preenchidos!");
            return;
        }

        try {
            long saldo = Long.parseLong(saldoCirco);

            if (saldo < 0) {
                showAlert("Erro", "O saldo do circo deve ser um valor positivo!");
                return;
            }

            System.out.println("Circo criado: " + nomeCirco + ", Saldo: " + saldo);
            Circus circus = new Circus(nomeCirco, saldo);
            // Salvar Circo no bloco de notas();
            showAlert("Sucesso", "Circo criado com sucesso!");
            
            limpar();
            //main.showScreen(4, circus);
            voltar();

        } catch (NumberFormatException e) {
            showAlert("Erro", "Saldo deve ser um número válido!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limpar() { // Limpar os campos
        nomeCircoField.clear();
        saldoCircoField.clear();
    }

    @Override
    public void voltar() {
        limpar();
        super.voltar();
    }
}
