package br.ufrn.imd.circusmanager.Controller.LoginController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import javafx.fxml.FXML;
import br.ufrn.imd.circusmanager.Model.Circus.*;
import javafx.scene.control.TextField;

public class CriarCircoController extends TelaComImagem {

    @FXML
    private TextField nomeCircoField;

    @FXML
    private TextField saldoCircoField;
    
    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoCriar.png";
        super.initialize();
    }

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
            Circus circusNovo = new Circus(nomeCirco, saldo);

            // !TODO tirar responsabilidade do main
            manager.salvarCirco(circusNovo); // Falta implementação

            showAlert("Sucesso", "Circo criado com sucesso!");
            
            limpar();
            
            manager.trocarTela("TelaCircoMenuView.fxml", circusNovo);

        } catch (NumberFormatException e) {
            showAlert("Erro", "Saldo deve ser um número válido!");
        }
    }

    private void limpar() {
        this.nomeCircoField.clear();
        this.saldoCircoField.clear();
    }

    @Override
    public void voltar() {
        limpar();
        super.voltar();
    }

    @Override
    public void atualizar() {}
}
