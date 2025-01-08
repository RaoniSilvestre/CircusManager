package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaDadosController extends Tela {

    @FXML
    private Label precoIngressoLabel;

    @FXML
    private Label numeroFuncionariosLabel;

    @FXML
    private Label quantidadeAnimaisLabel;

    @FXML
    private Label custoTotalMensalLabel;

    @FXML
    private Label totalItensLabel;

    @FXML
    private Label funcionarioMaisAntigoLabel;

    public void atualizar() {
        Circus circoAtual = circus;
        double custoTotalMensal = 0;
        int totalDeItens = 0;
        String funcionarioMaisAntigo = "Sem Funcionarios";

        for (Funcionario funcionario :  circoAtual.getListaDeFuncionarios().getFuncionarios()) {
            custoTotalMensal += funcionario.getSalario();
            if (funcionarioMaisAntigo.equals("Sem Funcionarios")) {
                funcionarioMaisAntigo = funcionario.getNome();
            }
            totalDeItens += funcionario.getItens().size();
        }
        for (Animal animal :  circoAtual.getListaDeAnimais().getAnimais()) {
            custoTotalMensal += animal.getValorManutencao();
        }
        
        numeroFuncionariosLabel.setText("Numero de funcionarios: " +  circoAtual.getListaDeFuncionarios().getFuncionarios().size());
        quantidadeAnimaisLabel.setText("Quantidade de animais: " +  circoAtual.getListaDeAnimais().getAnimais().size());
        custoTotalMensalLabel.setText("Custo total mensal: R$ " + custoTotalMensal);
        totalItensLabel.setText("Total de itens: " + totalDeItens);
        funcionarioMaisAntigoLabel.setText("Funcionario mais antigo: " + funcionarioMaisAntigo);
    }
}
