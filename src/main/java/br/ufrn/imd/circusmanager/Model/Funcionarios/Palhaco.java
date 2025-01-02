package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacosEnum;

public class Palhaco extends Funcionario{
    private PalhacosEnum tipo;

    public Palhaco(String nome, double salario, PalhacosEnum tipo) {
        super(nome, salario);
        this.tipo = tipo;
    }

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Tipo: %s - Salario: %s - Itens: %s.", getNome(), "Palhaço", getTipo().getDescricao(),  getSalario(), itensToString());
    }

    // getters

    public PalhacosEnum getTipo() {
        return tipo;
    }
}
