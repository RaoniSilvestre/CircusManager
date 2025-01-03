package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;

public class Magico extends Funcionario {
    private MagicoEnum tipo;

    public Magico(String nome, double salario, MagicoEnum tipo) {
        super(nome, salario);
        this.tipo = tipo;
    }

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Tipo: %s - Salario: %s - Itens: %s.", getNome(), getOcupacacao(), getTipo(),  getSalario(), itensToString());
    }

    // getters

    public String getTipo() {
        return tipo.toString();
    }
}
