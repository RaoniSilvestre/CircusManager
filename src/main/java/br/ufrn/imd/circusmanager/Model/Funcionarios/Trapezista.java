package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;

public class Trapezista extends Funcionario{
    private TrapezistaEnum tipo;

    public Trapezista(String nome, double salario, TrapezistaEnum tipo) {
        super(nome, salario);
        this.tipo = tipo;
    }

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Tipo: %s - Salario: %s - Itens: %s.", getNome(), "Trapezista", getTipo().getDescricao(),  getSalario(), itensToString());
    }

    public TrapezistaEnum getTipo() {
        return tipo;
    }
}
