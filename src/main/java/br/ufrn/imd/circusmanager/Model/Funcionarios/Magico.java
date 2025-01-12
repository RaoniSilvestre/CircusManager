package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.Set;

public class Magico extends Funcionario {
    private MagicoEnum tipo;

    public Magico(String nome, double salario, MagicoEnum tipo, Set<Item> itens) {
        super(nome, salario, OcupacaoEnum.MAGICO, itens);
        this.tipo = tipo;
    }
}
