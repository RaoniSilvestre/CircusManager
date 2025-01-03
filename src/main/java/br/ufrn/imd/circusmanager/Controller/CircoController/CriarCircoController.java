package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import br.ufrn.imd.circusmanager.Model.Circus.*;

public class CriarCircoController extends Tela {

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
            double saldo = Double.parseDouble(saldoCirco);

            if (saldo < 0) {
                showAlert("Erro", "O saldo do circo deve ser um valor positivo!");
                return;
            }

            System.out.println("Circo criado: " + nomeCirco + ", Saldo: " + saldo);
            Circus circus = new Circus(nomeCirco, saldo);
            
            main.salvarCirco(circus); // Falta implementação

            showAlert("Sucesso", "Circo criado com sucesso!");
            
            limpar();

            main.showScreen(4, circus);

        } catch (NumberFormatException e) {
            showAlert("Erro", "Saldo deve ser um número válido!");
        }
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

    @Override
    public void atualizar() {}
}
