package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.Set;

public class Trapezista extends Funcionario {
    private TrapezistaEnum tipo;

    public Trapezista(String nome, double salario, TrapezistaEnum tipo, Set<Item> itens) {
        super(nome, salario, OcupacaoEnum.TRAPEZISTA, itens);
        this.tipo = tipo;
    }
}
