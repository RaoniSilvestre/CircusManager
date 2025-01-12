package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.Set;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, double salario, Set<Item> itens) {
        super(nome, salario, OcupacaoEnum.VENDEDOR, itens);
    }

    public String getTipo() {
        return "Vendedor";
    }

}
