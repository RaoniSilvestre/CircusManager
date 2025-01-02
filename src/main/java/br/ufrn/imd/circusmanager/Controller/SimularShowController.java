package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Vendedor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimularShowController extends Tela{

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
        Circus circoAtual = main.getCircoAtual();

        int totalDeAnimadores = 0;
        int vendedoresDeAlgodaoDoce = 0;
        int vendedoresDePipoca = 0;
        int vendedoresDeBrinquedo = 0;

        double custoDosFuncionarios = 0;
        for (Funcionario funcionario : circoAtual.getListaDeFuncionarios().getFuncionarios()) {

            if (funcionario instanceof Vendedor) {
                for (String item : funcionario.getItens()){
                    if (item.equals("Pipoca")) {
                        vendedoresDePipoca ++;
                    }
                    else if (item.equals("Algodão doce")) {
                        vendedoresDeAlgodaoDoce ++;
                    }
                    else if (item.equals("vendedoresDeBrinquedo")){
                        vendedoresDeAlgodaoDoce ++;
                    }
                }
            }

            else totalDeAnimadores++;
            custoDosFuncionarios += funcionario.getSalario();
        }
        
        double custoDosAnimais = 0;
        for (Animal animal : circoAtual.getListaDeAnimais().getAnimais()) {
            custoDosAnimais += animal.getValorManutencao();
        }

        int numeroAleatorio = 4 + (int)(Math.random() * ((16 - 4) + 1));
        int totalDeIngressos = (int) (totalDeAnimadores*numeroAleatorio + circoAtual.getListaDeAnimais().getAnimais().size()*numeroAleatorio*1.5);
        
        int totalDeAlgodoesVendidos = vendedoresDeAlgodaoDoce * (int)(Math.random() * 11);
        int totalDePipocasVendidas = vendedoresDePipoca * (int)(Math.random() * 11);
        int totalDeBrinquedosVendidos = vendedoresDeBrinquedo * (int)(Math.random() * 11);

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
