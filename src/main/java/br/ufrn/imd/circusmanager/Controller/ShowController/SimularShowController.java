package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import br.ufrn.imd.circusmanager.Model.Itens.Vendedores;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimularShowController extends Tela {

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

    public void atualizar() {
        Circus circoAtual = circus;


        double custoDosAnimais = circus.getCustoAnimais();
        double custoDosFuncionarios = circoAtual.getCustoFuncionarios();
        int totalDeAnimadores = circoAtual.getQuantidadeAnimadores();

        Vendedores vendedores = circoAtual.getVendedores();

        int numeroAleatorio = 4 + (int)(Math.random() * ((16 - 4) + 1));
        int totalDeIngressos = (int) (totalDeAnimadores*numeroAleatorio + circoAtual.getListaDeAnimais().size()*numeroAleatorio*1.5);
        
        int totalDeAlgodoesVendidos = vendedores.vendedoresDeAlgodaoDoce() * (int)(Math.random() * 11);
        int totalDePipocasVendidas = vendedores.vendedoresDePipoca() * (int)(Math.random() * 11);
        int totalDeBrinquedosVendidos = vendedores.vendedoresDeBrinquedo() * (int)(Math.random() * 11);

        double totalArrecadado = totalDeIngressos * 10 + totalDeAlgodoesVendidos*5 + totalDePipocasVendidas*3 + totalDeBrinquedosVendidos*10;

        double custosTotais = custoDosAnimais + custoDosFuncionarios;

        ingressosVendidosLabel.setText("Ingressos vendidos: " + totalDeIngressos);
        algodoesDocesVendidosLabel.setText("Algodões doces vendidos: " + totalDeAlgodoesVendidos);
        pipocasVendidasLabel.setText("Pipocas vendidas: " + totalDePipocasVendidas);
        brinquedosVendidosLabel.setText("Brinquedos vendidos: " + totalDeBrinquedosVendidos);

        totalArrecadadoLabel.setText("Total arrecadado: R$ " + totalArrecadado);
        custoDoShowLabel.setText("Custo do show: R$ " + custosTotais);
        lucroLabel.setText("Lucro: R$ " + (totalArrecadado-custosTotais));
    }
}
