package br.ufrn.imd.circusmanager.Controller.LoginController;

import br.ufrn.imd.circusmanager.Controller.TelaComImagem;
import br.ufrn.imd.circusmanager.Service.CircoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * The type Criar circo controller.
 */
public class CriarCircoController extends TelaComImagem {


    /**
     * The Circo service.
     */
    CircoService circoService;

    @FXML
    private TextField nomeCircoField;

    @FXML
    private TextField saldoCircoField;

    public void initialize() {
        caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoCriar.png";
        super.initialize();

        this.circoService = new CircoService();
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

            circoService.criarCirco(nomeCirco, saldo);

            TelaComImagem.setCirco(circoService.getCircoPorNome(nomeCirco));

            System.out.println("Circo criado: " + nomeCirco + ", Saldo: " + saldo);

            showAlert("Sucesso", "Circo criado com sucesso!");

            limpar();

            trocarTela("TelaCircoMenuView.fxml");

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
    public void atualizar() {
    }
}
