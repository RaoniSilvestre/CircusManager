package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Service.CircoService;
import br.ufrn.imd.circusmanager.Service.FuncionarioService;
import br.ufrn.imd.circusmanager.Service.ZooService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimularShowController extends Tela {

    CircoService circoService;
    ZooService zooService;
    FuncionarioService funcionarioService;

    @FXML
    private Label ingressosVendidosLabel;

    @FXML
    private Label algodoesDocesVendidosLabel;

    @FXML
    private Label pipocasVendidasLabel;

    @FXML
    private Label brinquedosVendidosLabel;

    @FXML
    private Label totalArrecadadoLabel;

    @FXML
    private Label custoDoShowLabel;

    @FXML
    private Label lucroLabel;

    @FXML
    public void initialize() {
        this.circoService = new CircoService();
        this.funcionarioService = new FuncionarioService();
        this.zooService = new ZooService();
    }

    public void atualizar() {
        Circo circoAtual = Tela.getCirco();

        double custoDosAnimais = zooService.getCustoTotalAnimal(circoAtual);
        double custoDosFuncionarios = funcionarioService.getCustoTotalFuncionario(circoAtual);
        int totalDeAnimadores = funcionarioService.buscarTodosFuncionario(circoAtual)
                .stream().filter(funcionario -> !funcionario.getOcupacao().equals(OcupacaoEnum.VENDEDOR))
                .toList()
                .size();

        int quantidadeVendedores = funcionarioService.buscarTodosFuncionario(circoAtual)
                .stream()
                .filter(funcionario -> funcionario.getOcupacao().equals(OcupacaoEnum.VENDEDOR))
                .toList()
                .size();

        int quantidadeAnimais = zooService.listarAnimais(circoAtual).size();

        int numeroAleatorio = 4 + (int) (Math.random() * ((16 - 4) + 1));
        int totalDeIngressos = (int) (totalDeAnimadores * numeroAleatorio + quantidadeAnimais * numeroAleatorio * 1.5);

        int totalDeAlgodoesVendidos = quantidadeVendedores * (int) (Math.random() * 11);
        int totalDePipocasVendidas = quantidadeVendedores * (int) (Math.random() * 11);
        int totalDeBrinquedosVendidos = quantidadeVendedores * (int) (Math.random() * 11);

        double totalArrecadado = totalDeIngressos * 10 + totalDeAlgodoesVendidos * 5 + totalDePipocasVendidas * 3 + totalDeBrinquedosVendidos * 10;

        double custosTotais = custoDosAnimais + custoDosFuncionarios;

        ingressosVendidosLabel.setText("Ingressos vendidos: " + totalDeIngressos);
        algodoesDocesVendidosLabel.setText("Algodões doces vendidos: " + totalDeAlgodoesVendidos);
        pipocasVendidasLabel.setText("Pipocas vendidas: " + totalDePipocasVendidas);
        brinquedosVendidosLabel.setText("Brinquedos vendidos: " + totalDeBrinquedosVendidos);

        totalArrecadadoLabel.setText("Total arrecadado: R$ " + totalArrecadado);
        custoDoShowLabel.setText("Custo do show: R$ " + custosTotais);
        lucroLabel.setText("Lucro: R$ " + (totalArrecadado - custosTotais));
    }
}
