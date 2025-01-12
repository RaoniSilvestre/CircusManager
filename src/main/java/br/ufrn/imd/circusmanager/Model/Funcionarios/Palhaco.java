package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.Set;

public class Palhaco extends Funcionario {
    private PalhacoEnum tipo;

    public Palhaco(String nome, double salario, PalhacoEnum tipo, Set<Item> itens) {
        super(nome, salario, OcupacaoEnum.PALHACO, itens);
        this.tipo = tipo;
    }

}
