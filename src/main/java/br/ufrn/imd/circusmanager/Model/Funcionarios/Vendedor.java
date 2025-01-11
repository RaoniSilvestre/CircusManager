package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import br.ufrn.imd.circusmanager.Model.Itens.Vendedores;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, double salario){
        super(nome, salario, OcupacaoEnum.VENDEDOR);
    }

    public String getTipo() {
        return "Vendedor";
    }

    public Vendedores getVendedores() {
        int pipoqueiros = 0;
        int doceiros = 0;
        int brinquedeiros = 0;

        for (Item item : this.getItens()) {
            switch (item.getTipo()) {
                case PIPOCA -> pipoqueiros++;
                case ALGODAO_DOCE -> doceiros++;
                case PALHACO_DE_BRINQUEDO -> brinquedeiros++;
                default -> {}
            }
        }

        return new Vendedores(pipoqueiros, doceiros, brinquedeiros);
    }

}
