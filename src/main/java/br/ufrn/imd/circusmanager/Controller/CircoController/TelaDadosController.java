package br.ufrn.imd.circusmanager.Controller.CircoController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Service.CircoService;
import br.ufrn.imd.circusmanager.Service.FuncionarioService;
import br.ufrn.imd.circusmanager.Service.ZooService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The type Tela dados controller.
 */
public class TelaDadosController extends Tela {

    /**
     * The Circo service.
     */
    CircoService circoService;
    /**
     * The Funcionario service.
     */
    FuncionarioService funcionarioService;
    /**
     * The Zoo service.
     */
    ZooService zooService;

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

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        this.circoService = new CircoService();
        this.zooService = new ZooService();
        this.funcionarioService = new FuncionarioService();
    }

    public void atualizar() {
        Circo circoAtual = Tela.getCirco();

        double custoFuncionarios = funcionarioService.getCustoTotalFuncionario(circoAtual);
        double custoAnimais = zooService.getCustoTotalAnimal(circoAtual);
        double custoTotalMensal = custoFuncionarios + custoAnimais;

        int totalItens = funcionarioService.getFuncionarioItens(circoAtual);

        String funcionarioMaisAntigo = funcionarioService.getFuncionarioMaisAntigo(circoAtual);

        int totalFuncionarios = funcionarioService.buscarTodosFuncionario(circoAtual).size();
        int totalAnimais = zooService.listarAnimais(circoAtual).size();

        numeroFuncionariosLabel.setText("Numero de funcionarios: " + totalFuncionarios);
        quantidadeAnimaisLabel.setText("Quantidade de animais: " + totalAnimais);
        custoTotalMensalLabel.setText("Custo total mensal: R$ " + custoTotalMensal);
        totalItensLabel.setText("Total de itens: " + totalItens);
        funcionarioMaisAntigoLabel.setText("Funcionario mais antigo: " + funcionarioMaisAntigo);
    }
}
