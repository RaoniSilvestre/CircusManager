package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacoEnum;

public class Palhaco extends Funcionario{
    private PalhacoEnum tipo;

    public Palhaco(String nome, double salario, PalhacoEnum tipo) {
        super(nome, salario);
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo.toString();
    }
}
